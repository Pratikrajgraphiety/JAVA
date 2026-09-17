<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Get Session - Practical 9C</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; line-height: 1.6; }
        .nav { margin-bottom: 20px; padding: 10px; background: #f4f4f4; border-radius: 5px; }
        .nav a { margin-right: 15px; text-decoration: none; color: #0066cc; font-weight: bold; }
        .box { border: 1px solid #ccc; padding: 20px; border-radius: 5px; max-width: 450px; background: #fdfdfd; }
        .success { color: #28a745; }
        .error { color: #dc3545; }
    </style>
</head>
<body>

<div class="nav">
    <strong>Practical 9 Navigation:</strong> 
    <a href="index.html">Part A: Cookie Form</a> | 
    <a href="displayCookies.jsp">Part B: Display All Cookies</a> | 
    <a href="session.html">Part C: Session Form</a>
</div>

<div class="box">
    <h2>Session Value</h2>

<%
    String username = (String) session.getAttribute("username");

    if (username != null) {
        out.println("<p class='success'><strong>User Name:</strong> " + username + "</p>");
    } else {
        out.println("<p class='error'>Session variable not found.</p>");
    }
%>

    <br>
    <a href="session.html">&larr; Back to Session Form</a>
</div>

</body>
</html>
