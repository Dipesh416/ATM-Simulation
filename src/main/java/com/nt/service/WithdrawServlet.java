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
@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	
	final String Query="SELECT BALANCE FROM ATM WHERE ACCNUMBER=? AND PIN=?";
	static Double balance = 0.0;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AtmDao atmDao =new AtmDao();
		Double amount=Double.parseDouble(req.getParameter("amount"));
		
//		read value from the session object
		HttpSession ses=req.getSession();
		int accnumber=(int) ses.getValue("accnumber");
		String pin=(String) ses.getValue("pin");
		
		try {
			Connection con= atmDao.makeConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setInt(1, accnumber);
			ps.setString(2, pin);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				balance=(double) rs.getFloat("balance");
//				System.out.println(balance+ "    balanavgshdjd");
			}
//			 checking the balnce and withdraw
			if(balance<amount) {
				res.sendRedirect("insufficient_page.jsp");
			}
			else {
				balance=balance-amount;
				
				final String Query1= "UPDATE ATM SET BALANCE=? WHERE ACCNUMBER=? AND PIN=?";
				PreparedStatement ps1=con.prepareStatement(Query1);
				ps1.setDouble(1, balance);
				ps1.setInt(2, accnumber);
				ps1.setString(3, pin);
				
				ps1.executeUpdate();
				
				res.sendRedirect("show_withdrawl_message.jsp");
				//System.out.println("current cash  is :"+balance);
			}
			
			
			
		} catch (Exception e) {
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
