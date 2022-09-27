<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/9/2022
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete</h1>
<a href="/students">back menu</a>
<form method="post">
    <label>Name</label>
    <span>${requestScope["student"].getName()}</span><br>
    <label>Age</label>
    <span>${requestScope["student"].getAge()}</span><br>
    <span>Are you sure delete?</span><br>
    <button>Yes</button>
</form>
<a href="/students"><button>No</button></a>
</body>
</html>
