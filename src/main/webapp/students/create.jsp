<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/9/2022
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>create</h1>
<a href="/students">Back list Student</a>
<c:if test='${requestScope["message"]!=null}'>
  <span style="color: blue">${requestScope["message"]}</span><br>
</c:if>
<form method="post">
  <label>Name</label><br>
  <input type="text" name="name"><br>
  <label> AGE</label><br>
  <input type="text" name="age"><br>
  <button>Create</button>
</form>

</body>
</html>
