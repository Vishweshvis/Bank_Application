<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
 <title>verification</title>
 <link href="css/account.css" rel="stylesheet" >
</head>
<body>
<div class="background-wrap">
  <div class="background"></div>
</div>
<div>
 <%
            String status = (String) request.getAttribute("status");
            if (status != null) {
                if (status.equals("success")) {
                    out.println("<h1 style='color: green; font-size:30px'>Account created successfully!</h1>");
                } else if (status.equals("duplicate")) {
                    out.println("<h1 style='color: red; font-size:40px'>Error: Duplicate email address. Please use a different email.</p>");
                } else if (status.equals("failed")) {
                    out.println("<p style='color: red;'>Account creation failed. Please try again.</p>");
                } else if (status.equals("error")) {
                    String error = (String) request.getAttribute("error");
                    out.println("<h1 style='color: red; font-size:40px'>Error: " + error + "</h1>");
                }
            }
        %>

</div>

<form id="accesspanel" action="message" method="post">
  <h1 id="litheader">Quziee</h1>
  <div class="inset">
    <p>
      <input type="text" name="email" id="email" placeholder="Email address">
    </p>
    <p>
      <input type="text" name="Username" id="password" placeholder="username">
    </p>
    <div style="text-align: center;">
      <div class="checkboxouter">
        <input type="checkbox" name="rememberme" id="remember" value="Remember">
        <label class="checkbox"></label>
      </div>
      <label for="remember">Remember me for 14 days</label>
    </div>
    <input class="loginLoginValue" type="hidden" name="service" value="login" />
  </div>
  <p class="p-container">
    <input type="submit" name="Login" id="go" value="Authorize">
  </p>
</form>
</body>
</html>
    