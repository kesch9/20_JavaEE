<%@ page import="ru.innopolis.stc12.servlets.pojo.Group" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Student to DataBase</title>
</head>
<body>
<form action="/addstudent" method="post">
    <fieldset>
        <legend>Personal Information</legend>
        First name:<br>
        <input type="text" name="firstname" value="first name"><br>
        Last name:<br>
        <input type="text" name="lastname" value="last name"><br>
        Age:<br>
        <input type="number" name="age" value="age"><br>
        Contact:<br>
        <input type="text" name="contact" value="contact"><br>
        City:<br>
        <input type="text" name="city" value="city"><br>
        <select name="nameCourse">
            <option disabled>Выберите курс</option>
            <%
                List<Group> list = (List<Group>) request.getAttribute("list");
                for (Group group : list) {
            %>
            <option><%=group.getNameCourse()%></option>
            <%
                }
            %>
        </select>
        <select name="nameStream">
            <option disabled>Выберите курс</option>
            <%
                for (Group group : list) {
            %>
            <option><%=group.getNumberStream()%></option>
            <%
                }
            %>
        </select>
        <input type="submit" value="Submit">
    </fieldset>
</form>
</body>
</html>
