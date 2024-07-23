<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.text.DecimalFormat" %>
    
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Bank Account</title>
        <link rel="stylesheet" href="styles.css">
        
    </head>
    <body>
    
        
        <div class="actions">
        <form method=post action="validate">
         <%  Double initialAmount = (Double) session.getAttribute("initialAmount");
         if (initialAmount != null) {
    	%>
                    
               <h2>amount: <%=new DecimalFormat("#.##").format(initialAmount) %></h2>
                      <%
    } else {
%>
    <p>No account details available.</p>
<%
    }
%>
        
         <h2> ${amount}</h2>
            <input type="number" name=amount  id="amount" placeholder="Enter Amount">
            <input type="submit" onclick="deposit()" name="validate" id="go" >
            </form>
        </div>
        
        <script src="withdraw.js"></script>
    </body>
</html>