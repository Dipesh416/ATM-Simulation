package com.nt.service;

import java.io.IOException;
import java.sql.Connection;

import com.nt.dao.AtmDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/checkoperation")
public class CheckOperation extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String check=req.getParameter("check");
		
		
//		now check the operation 
		if(check.equals("CheckBalance")) {
			res.sendRedirect("checkbalance");
		}
		else if(check.equals("Withdraw")) {
			res.sendRedirect("withdraw.jsp");
		}
		else {
			res.sendRedirect("index.html");
		}
	}
	
}
