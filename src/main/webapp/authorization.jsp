<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.01.2021
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<form action="/auth" method="post">
    <input type="text" name="login" placeholder="login">
    <input type="text" name="password" placeholder="password">
    <button>Authorization</button>
</form>
<p style="color: red">${requestScope.message}</p>
</body>
</html>
