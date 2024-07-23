package com.clientApplication;

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
 * Servlet implementation class withdraw
 */
@WebServlet("/withdraw")
public class withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       String email = request.getParameter("email");
	        double amount = Double.parseDouble(request.getParameter("amount"));

	        Connection con = null;
	        PreparedStatement pst = null;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_details", "root", "password");

	            // Get account ID
	            String accountIdSql = "SELECT account_id FROM accounts WHERE User_EmaEl = ?";
	            pst = con.prepareStatement(accountIdSql);
	            pst.setString(1, email);
	            ResultSet rs = pst.executeQuery();

	            if (rs.next()) {
	                int accountId = rs.getInt("account_id");

	                // Update the balance
	                String updateBalanceSql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
	                pst = con.prepareStatement(updateBalanceSql);
	                pst.setDouble(1, amount);
	                pst.setInt(2, accountId);
	                pst.executeUpdate();

	                // Insert transaction record
	                String insertTransactionSql = "INSERT INTO transactions (account_id, amount, transaction_type) VALUES (?, ?, 'deposit')";
	                pst = con.prepareStatement(insertTransactionSql);
	                pst.setInt(1, accountId);
	                pst.setDouble(2, amount);
	                pst.executeUpdate();

	                request.setAttribute("message", "Deposit successful!");
	            } else {
	                request.setAttribute("message", "Account not found!");
	            }

	            request.getRequestDispatcher("index.jsp").forward(request, response);
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            request.setAttribute("message", "Error: " + e.getMessage());
	            request.getRequestDispatcher("index.jsp").forward(request, response);
	        } finally {
	            try {
	                if (pst != null) pst.close();
	                if (con != null) con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		
		// TODO Auto-generated method stub
		
	}

}
