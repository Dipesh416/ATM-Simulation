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

@WebServlet("/checkbalance")
public class CheckBalanceServlet extends HttpServlet {
	final String Query="SELECT BALANCE FROM ATM WHERE ACCNUMBER=? AND PIN=?";
	static Double balance=0.0;
	
	

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession ses=req.getSession();
		int accnumber=(int) ses.getValue("accnumber");
		String pin=(String) ses.getValue("pin");
		
		AtmDao atmDao=new AtmDao();
		
		try {
			Connection con=atmDao.makeConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setInt(1, accnumber);
			ps.setString(2, pin);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				balance=(double) rs.getFloat("balance");
			}
			res.sendRedirect("show_balance_message.jsp");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Double sendBalance() {
		//System.out.println("balance :" + balance);
		return balance;
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
