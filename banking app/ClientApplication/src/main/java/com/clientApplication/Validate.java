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
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_details", "root", "Vikkyrover@8056");
            
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String amount = request.getParameter("send");
            pst = con.prepareStatement("SELECT * FROM customer_acc WHERE User_Email = ? AND temp_pass = ?");
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            double newamount = Double.parseDouble(amount);
            if (rs.next()) {
                // Retrieve additional details
                String sql = "SELECT initialamount, dataofbirth , fullname FROM details WHERE User_Email = ?";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, email);
                ResultSet userRs = statement.executeQuery();
                
                if (userRs.next()) {
                    double initialAmount = userRs.getDouble("initialamount");
                    String dateOfBirth = userRs.getString("dataofbirth");
                    String fullname = userRs.getString("fullname");

                    
                    // Do something with the retrieved data
                    // For example, you could store it in the session or request attributes
                    request.getSession().setAttribute("initialAmount", initialAmount);
                    request.getSession().setAttribute("dateOfBirth", dateOfBirth);
                    request.getSession().setAttribute("fullname", fullname);
                    request.getSession().setAttribute("amount", newamount);

                }
                
                userRs.close();
                statement.close();
                
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("pages-error-404.html");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
