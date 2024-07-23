tml>
<head>
    <title>Account Creation</title>
</head>
<body>
    <div>
        <!-- Check for status attribute and display messages accordingly -->
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
    <!-- Your form for account creation goes here -->
    <form method="post" action="AccountServlet">
        <label for="acc">Account Number:</label>
        <input type="text" id="acc" name="acc" required><br>
        <label for="temp">Temporary Password:</label>
        <input type="text" id="temp" name="temp" required><br>
        <label for="UserEmail">Email:</label>
        <input type="email" id="UserEmail" name="UserEmail" required><br>
        <input type="submit" value="Create Account">
    </form>
</body>
</html>