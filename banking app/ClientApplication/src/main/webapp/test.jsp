<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.sql.ResultSet, java.text.DecimalFormat" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Dashboard</title>
</head>
<body>
    <h1>Bank Account Dashboard</h1>
    
    <% 
        String message = (String) request.getAttribute("message");
        if (message != null) {
            %><p><%= message %></p><%
        }
    %>
    
    <% 
        String email = (String) session.getAttribute("email"); // Ensure email is set in session after login
        
        if (email != null) {
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            Double balance = null;
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_details", "root", "password");
                String sql = "SELECT balance FROM accounts WHERE email = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, email);
                rs = pst.executeQuery();
                
                if (rs.next()) {
                    balance = rs.getDouble("balance");
                }
           
            
            if (balance != null) {
                %>
                <h2>Current Balance: $<%= new DecimalFormat("#,##0.00").format(balance) %></h2>
                <form action="DepositServlet" method="post">
                    <h3>Deposit Funds</h3>
                    <label for="amount">Amount:</label>
                    <input type="number" id="amount" name="amount" step="0.01" required>
                    <button type="submit">Deposit</button>
                </form>
                
                <form action="WithdrawServlet" method="post">
                    <h3>Withdraw Funds</h3>
                    <label for="amount">Amount:</label>
                    <input type="number" id="amount" name="amount" step="0.01" required>
                    <button type="submit">Withdraw</button>
                </form>
                <% 
            } else {
                %><p>No account found.</p><%
            
        else {
            %><p>Please log in to access your account.</p><%
        }
         
    %>
</body>
</html>
