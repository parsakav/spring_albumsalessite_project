<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 4/11/20
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

    <link href="<c:url value="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body>
<%@include file="header.jsp"%>


<div class="container">
<br>
    <c:if test="${singers ne null}">

    <table class="table table-striped">
        <thead >
        <tr>
            <td scope="col" width="50">#</td>
            <td scope="col" width="150">First Name</td>
            <td scope="col" width="150">Last Name</td>
            <td scope="col" width="150">Nick Name</td>
            <td scope="col" width="100">Open</td>
        </tr>
        </thead>

        <c:forEach items="${singers}" var="category">

            <tbody>
            <td scope="row"> <c:out value="${category.id}"/> </td>
            <td scope="row"> <c:out value="${category.fname}"/> </td>
            <td scope="row"> <c:out value="${category.lname}"/> </td>
            <td scope="row"> <c:out value="${category.nickname}"/> </td>
            <td scope="row"> <a href='/admin/visitalbum/?id=${category.id}'>${category.id}</a> </td>
    </tbody>
        </c:forEach>

    </table>


</c:if>
    <button class="btn btn-primary" onclick="window.location.href = '/admin/addsinger'">Add Singer</button>
    <button class="btn btn-primary" onclick="window.location.href = '/admin/topcategory'"> Best selling albums</button>
    <button class="btn btn-primary" onclick="window.location.href = '/admin/topvote'"> Best rated albums</button>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</body>
</html>
