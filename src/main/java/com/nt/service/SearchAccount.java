package com.nt.service;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nt.dao.AtmDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/searchaccount")
public class SearchAccount extends HttpServlet {
	
	final String Query="SELECT ACCNUMBER,ACCHOLDERNAME,BALANCE FROM ATM WHERE ACCNUMBER=? AND ACCHOLDERNAME=?";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String accHolderName=req.getParameter("accholdername");
		int accNumber=Integer.parseInt(req.getParameter("accnumber"));
		int accNo=0;
		String aHName = null;
		Double bal=0.0;
		AtmDao atmDao =new AtmDao();		
		try {
			Connection con= atmDao.makeConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			
			ps.setInt(1, accNumber);
			ps.setString(2, accHolderName);
			
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				accNo=rs.getInt(1);
				 aHName=rs.getString(2);
				 bal=rs.getDouble(3);
			}
			HttpSession ses=req.getSession();
			ses.setAttribute("accnumber", accNo);
			ses.setAttribute("accholdername", aHName);
			ses.setAttribute("balance", bal);
			
			
			res.sendRedirect("search-account-database.jsp");
		
			
			
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
