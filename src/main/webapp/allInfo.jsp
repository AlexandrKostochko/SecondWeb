<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.01.2021
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AllInfo</title>
</head>
<body>
<form action="/allInfo" method="post">
    <button>AllInfo</button>
</form>
<p style="color: red">${requestScope.message}</p>
</body>
</html>
