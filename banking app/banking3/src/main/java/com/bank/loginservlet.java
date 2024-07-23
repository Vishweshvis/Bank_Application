package com.bank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vishwesh1","root","Vikkyrover@8056");	
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		PreparedStatement pst = con.prepareStatement("Select * FROM login WHERE username =? AND password=?");
		pst.setString(1, name);
		pst.setString(2, password);
         ResultSet rs = pst.executeQuery();
         if(rs.next()) {
        	 response.sendRedirect("index1.html");
         }
         else {
        	 response.sendRedirect("incorrect.jsp");

         }
		}
		
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	

	}

}
