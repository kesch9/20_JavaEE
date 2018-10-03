<%--
  Created by IntelliJ IDEA.
  User: sergej
  Date: 03.10.18
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% if ("wrongUser".equals(request.getParameter("action"))){%>
        <div style="color: #AA0000">Неверное имя пользователя</div>
<%}%>
<form action="/login" method="post">
    Логин:<<br>
    <input type="text" name = "login">
    Пароль:<<br>
    <input type="password" name="password">
    <input type="submit">
</form>

</body>
</html>
