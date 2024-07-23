<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<%
            String status = (String) request.getAttribute("status");
            if (status != null) {
                if (status.equals("success")) {
                    out.println("<p>Account created successfully!</p>");
                } else if (status.equals("duplicate")) {
                    out.println("<p style='color: red;'>Error: Duplicate email address. Please use a different email.</p>");
                } else if (status.equals("failed")) {
                    out.println("<p style='color: red;'>Account creation failed. Please try again.</p>");
                } else if (status.equals("error")) {
                    String error = (String) request.getAttribute("error");
                    out.println("<p style='color: red;'>Error: " + error + "</p>");
                }
            }
        %>



</div>


</body>
</html>