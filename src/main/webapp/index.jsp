<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>TestForm</title>
</head>
<body>
<H1>Заголовок страницы</H1>
<p>
  Абзац текста
</p>
<div>
  <a href="/hello">Hello link</a><BR>
  <a href="/iterator">Iterator link</a><BR>
  <a href="/students">Students</a><BR>
  <a href="/login">Login</a><BR>
  <a href="/addstudentform">AddStudent</a><BR><BR>
  <form method="post" action="/hello">
    <input type="text" name="testText">
    <input type="submit">
  </form>
</div>
</body>
</html>
