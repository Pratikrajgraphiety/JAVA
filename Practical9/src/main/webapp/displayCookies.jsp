<%@ page import="javax.servlet.http.Cookie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Display Cookies - Practical 9B</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; line-height: 1.6; }
        .nav { margin-bottom: 20px; padding: 10px; background: #f4f4f4; border-radius: 5px; }
        .nav a { margin-right: 15px; text-decoration: none; color: #0066cc; font-weight: bold; }
        table { border-collapse: collapse; width: 60%; margin-top: 15px; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background-color: #007bff; color: white; }
        tr:nth-child(even) { background-color: #f9f9f9; }
        tr:hover { background-color: #f1f1f1; }
    </style>
</head>
<body>

<div class="nav">
    <strong>Practical 9 Navigation:</strong> 
    <a href="index.html">Part A: Cookie Form</a> | 
    <a href="displayCookies.jsp">Part B: Display All Cookies</a> | 
    <a href="session.html">Part C: Session Form</a>
</div>

<h2>Part B: Cookies Stored on Client</h2>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null && cookies.length > 0) {
%>
    <table>
        <tr>
            <th>Cookie Name</th>
            <th>Cookie Value</th>
        </tr>
<%
        for (Cookie cookie : cookies) {
%>
        <tr>
            <td><%= cookie.getName() %></td>
            <td><%= cookie.getValue() %></td>
        </tr>
<%
        }
%>
    </table>
<%
    } else {
%>
    <p>No cookies found.</p>
<%
    }
%>

<br>
<p><a href="index.html">&larr; Add or update a cookie using Part A</a></p>

</body>
</html>
