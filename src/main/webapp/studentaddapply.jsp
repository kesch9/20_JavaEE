<%--
  Created by IntelliJ IDEA.
  User: sergej
  Date: 03.10.18
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Добавление прошло успешно?</h2>
<%
    request.getAttribute("confirm");
%>
<a href="index.jsp">Вернуться назад</a>
</body>
</html>
