<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/9/2022
  Time: 9:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="students?action=create">Form create student</a>
<c:if test='${requestScope["message"]!=null}'>
    <span>${requestScope['message']}</span>
</c:if>
<table border="1" style="width: 75%">
    <tr>
        <th>STT</th>
        <th>NAME</th>
        <th>AGE</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    <c:forEach var="st" items='${requestScope["listStudent"]}'>
        <tr>
            <td>${st.id}</td>
            <td><a href="students?action=detail&id=${st.id}">${st.name}</a></td>
            <td>${st.age}</td>
            <td>
                <a href="students?action=edit&id=${st.id}">edit</a>
            </td>
            <td>
                <a href="students?action=delete&id=${st.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
