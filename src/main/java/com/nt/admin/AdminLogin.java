package com.nt.admin;

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

@WebServlet("/login")
public class AdminLogin extends HttpServlet {
	final String login_Query="SELECT * FROM ADMIN WHERE USER=? AND PASSWORD=?";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String user=req.getParameter("username");
		String pswd=req.getParameter("password");
		
		AtmDao atmDao=new AtmDao();
		try {
			Connection con= atmDao.makeConnection();
			PreparedStatement ps=con.prepareStatement(login_Query);
			ps.setString(1, user);
			ps.setString(2, pswd);
			
			ResultSet rs=ps.executeQuery();
			boolean flag=rs.next();
			if(flag) {
				HttpSession ses=req.getSession();
				ses.setAttribute("user", user);
				ses.setAttribute("pswd", pswd);
				
				res.sendRedirect("account_creation_deletion_page.html");
			}
			else {
				res.sendRedirect("wrong_admin_user_pswd.jsp");
			}
			
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
