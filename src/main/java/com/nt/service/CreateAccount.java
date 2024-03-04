package com.nt.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nt.dao.AtmDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/createaccount")
public class CreateAccount extends HttpServlet {
	
	final String Query="INSERT INTO ATM(ACCHOLDERNAME,PIN,BALANCE) VALUES(?,?,?)";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String accHolderName=req.getParameter("accholdername");
		Double balance=Double.parseDouble(req.getParameter("balance"));
		String pin=req.getParameter("password");
		
		AtmDao atmDao =new AtmDao();		
		try {
			Connection con= atmDao.makeConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			
			ps.setString(1, accHolderName);
			ps.setString(2, pin);
			ps.setDouble(3, balance);
			
			ps.executeUpdate();
			
			res.sendRedirect("account-creation-done.jsp");
		
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
