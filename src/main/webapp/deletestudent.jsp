<%@ page import="ru.innopolis.stc12.servlets.pojo.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: sergej
  Date: 05.10.18
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удаление студента</title>
</head>
<body>
<form method="post" action="/deletestudentform">
<table> <caption>Список студентов</caption>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th>Contact</th>
        <th>City</th>
        <th>Delete?</th>
    </tr>
    <%
        List<Student> list = (List<Student>) request.getAttribute("studentList");
        for (Student student : list) {
    %>
    <tr>
        <th><%=student.getId()%></th>
        <th><%=student.getFirstName()%></th>
        <th><%=student.getLastName()%></th>
        <th><%=student.getAge()%></th>
        <th><%=student.getContact()%></th>
        <th><%=student.getCity()%></th>
        <th><input type="checkbox" name = "del_stud" value="<%=student.getId()%>">Delete </th>
    </tr>
    <%
        }
    %>

</table>
    <input type="submit" value="Submit">
</form>
</body>
</html>
