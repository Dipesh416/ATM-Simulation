package com.nt.controller;

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

@WebServlet("/findaccount")
public class FindAccount extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		final String Query="SELECT ACCNUMBER,PIN FROM ATM WHERE ACCNUMBER=? AND PIN=?";
				
		
		String pin=req.getParameter("pin");
		int accnumber=Integer.parseInt(req.getParameter("accnumber"));
		
		AtmDao atmDao= new AtmDao();
		try {
			Connection con=atmDao.makeConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setInt(1, accnumber);
			ps.setString(2, pin);
			
			
			ResultSet rs=ps.executeQuery();
			boolean flag=rs.next();
			if(flag) {
//				set to session object
				HttpSession ses=req.getSession(true);
				ses.setAttribute("accnumber", accnumber);
				ses.setAttribute("pin", pin);
				
				res.sendRedirect("page1.html");
				
			}
			else {
				res.sendRedirect("wrong_id_pswd.jsp");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
