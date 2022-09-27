<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/9/2022
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/students">back menu</a>
<form method="post">
    <label>Id</label>
    <span>${requestScope["student"].getId()}</span><br>
    <label>Name</label>
    <span>${requestScope["student"].getName()}</span><br>
    <label>Age</label>
    <span>${requestScope["student"].getAge()}</span><br>
</form>
</body>
</html>
