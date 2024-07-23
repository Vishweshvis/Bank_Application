<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    Double initialAmount = (Double) session.getAttribute("initialAmount");
    String dateOfBirth = (String) session.getAttribute("dateOfBirth");

    if (initialAmount != null && dateOfBirth != null) {
%>
    <p>Initial Amount: <%= new DecimalFormat("#.##").format(initialAmount) %></p>
    <p>Date of Birth: <%= dateOfBirth %></p>
<%
    } else {
%>
    <p>No account details available.</p>
<%
    }
%>
</body>
</html>