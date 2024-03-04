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


@WebServlet("/deleteaccount")
public class DeleteAccount extends HttpServlet {
	
	final String Query="DELETE FROM ATM WHERE ACCNUMBER=? AND ACCHOLDERNAME=?";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String accHolderName=req.getParameter("accholdername");
		int accNumber=Integer.parseInt(req.getParameter("accnumber"));
		
		AtmDao atmDao =new AtmDao();		
		try {
			Connection con= atmDao.makeConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			
			ps.setInt(1, accNumber);
			ps.setString(2, accHolderName);
			
			ps.executeUpdate();
			
			res.sendRedirect("account-deletion-done.jsp");
		
			
			
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
