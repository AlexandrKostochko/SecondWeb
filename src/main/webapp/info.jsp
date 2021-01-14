<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.01.2021
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
</head>
<body>
<form action="/info" method="post">
    <button>Info</button>
</form>
<p style="color: red">${requestScope.message}</p>
</body>
</html>
