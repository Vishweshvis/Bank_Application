package com.clientApplication;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class changing_amount
 */
@WebServlet("/changing_amount")
public class changing_amount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  Connection con = null;
	        PreparedStatement pst = null;
	        ResultSet rs = null;

		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_details","root","Vikkyrover@8056");	
			
			String amount = request.getParameter("amount");
			
			 
				pst.setString(1, amount);
				int rowcount = pst.executeUpdate();


			response.sendRedirect("result.jsp");
			
			if(rowcount > 0) {
				 request.setAttribute("status","success");

				} 
				else {
					request.setAttribute("status","failed");
				}
				//dispatcher.forward(request, response);

			} catch (ClassNotFoundException  | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }


				}
				
				

				


			}
