<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String username = request.getParameter("username");

    if (username != null && !username.trim().equals("")) {
        session.setAttribute("username", username);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Session Saved - Practical 9C</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; line-height: 1.6; }
        .nav { margin-bottom: 20px; padding: 10px; background: #f4f4f4; border-radius: 5px; }
        .nav a { margin-right: 15px; text-decoration: none; color: #0066cc; font-weight: bold; }
        .box { border: 1px solid #ccc; padding: 20px; border-radius: 5px; max-width: 450px; background: #f9fff9; }
        .btn { display: inline-block; padding: 8px 16px; background-color: #28a745; color: white; text-decoration: none; border-radius: 4px; margin-top: 10px; }
        .btn:hover { background-color: #218838; }
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
    <h2 style="color: #28a745;">Session Variable Stored Successfully</h2>
    <p><strong>User Name:</strong> <%= username %></p>
    <a class="btn" href="getSession.jsp">View Session</a>
</div>

</body>
</html>

<%
    } else {
%>

<!DOCTYPE html>
<html>
<head>
    <title>Error - Practical 9C</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .error { color: #dc3545; }
    </style>
</head>
<body>

<h2 class="error">Error: User Name is empty!</h2>
<a href="session.html">Go Back</a>

</body>
</html>

<%
    }
%>
