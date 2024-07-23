package com.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class message
 */
@WebServlet("/message")
public class message extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
      
//String name = request.getParameter("email");
		response.setContentType("text/html");
String UserEmail = request.getParameter("email");
String name = request.getParameter("Username");
	SendMail mail = new SendMail();
	
	String temp = mail.generate_password();
	String account = mail.generateAccountNumber();
	User user = new User(UserEmail,account , temp);
		//PrintWriter writer = response.getWriter();
	boolean test = mail.sendemail(user);
		 if(test) {
			 HttpSession session = request.getSession();
			 session.setAttribute("authcode", user);
			 //response.sendRedirect("verify.jsp");
		 }
		 
//		 String pass = temp ;
//		 String acc  = account;
//		 String email = UserEmail;
//		 RequestDispatcher dispatcher = null;
//	        Connection con = null;
//	PrintWriter out = response.getWriter();


	/*
	 * try { Class.forName("com.mysql.cj.jdbc.Driver"); con =
	 * DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_details",
	 * "root","Vikkyrover@8056"); PreparedStatement pst = con.
	 * prepareStatement("insert into accountanumber(AccountAnumber , temp_pass,User_Email ) values(?,?,?)"
	 * ); pst.setString(1, acc); pst.setString(2, temp); pst.setString(3,
	 * UserEmail); int rowcount = pst.executeUpdate(); dispatcher =
	 * request.getRequestDispatcher("account.html");
	 * 
	 * if(rowcount > 0) { request.setAttribute("status","success");
	 * 
	 * } else { request.setAttribute("status","failed"); }
	 * dispatcher.forward(request, response);
	 * 
	 * } catch (ClassNotFoundException | SQLException e) { // TODO Auto-generated
	 * catch block System.out.println(e); } finally { try { con.close(); } catch
	 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */
		 String acc = account;
	        String temp1 = temp;
	        String userEmail = request.getParameter("email");

	        Connection con = null;
	        PreparedStatement pst = null;
	        RequestDispatcher dispatcher = null;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_details", "root", "Vikkyrover@8056");
	            pst = con.prepareStatement("INSERT INTO customer_acc (AccountAnumber, temp_pass, User_Email) VALUES (?, ?, ?)");
	            pst.setString(1, acc);
	            pst.setString(2, temp1);
	            pst.setString(3, userEmail);

	            int rowcount = pst.executeUpdate();

	            if (rowcount > 0) {
	                request.setAttribute("status", "success");
	            } else {
	                request.setAttribute("status", "failed");
	            }
	            //dispatcher.forward(request, response);
	            dispatcher = request.getRequestDispatcher("account.jsp");

	        } catch (ClassNotFoundException | SQLException e) {
	            if (e instanceof SQLException && ((SQLException) e).getSQLState().equals("23000") && e.getMessage().contains("email")) { // Specific check for duplicate email
	                request.setAttribute("status", "duplicate");
	            } else {
	                request.setAttribute("status", "error");
	                request.setAttribute("error", e.getMessage());
	            }
	            dispatcher = request.getRequestDispatcher("account.jsp");
	           
	        } finally {
	            try {
	                if (pst != null) pst.close();
	                if (con != null) con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (dispatcher != null) {
	            dispatcher.forward(request, response);
	        }
	    }

	}

	


