<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.01.2021
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
<form action="/out" method="post">
    <button>Logout</button>
</form>
<p style="color: red">${requestScope.message}</p>
</body>
</html>
