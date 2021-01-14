<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.01.2021
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/reg" method="post">
    <input type="text" name="login" placeholder="login">
    <input type="text" name="password" placeholder="password">
    <input type="text" name="name" placeholder="name">
    <button>Registration</button>
</form>
<p style="color: red">${requestScope.message}</p>
</body>
</html>
