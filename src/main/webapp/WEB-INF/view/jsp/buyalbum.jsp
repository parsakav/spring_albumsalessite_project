<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 4/12/20
  Time: 12:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy album</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <spring:url value="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css" var="bootstrap" />
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

    <link rel="stylesheet" type="text/css" href="${bootstrap}" />

</head>
<body>
<%@include file="header.jsp"%>

<div class="container">
    <div class="card">
        <c:if test="${albums ne null}">
<form action="/getinvoice" method="post">
    <security:authentication property="principal.username" var="user"/>
<input type="hidden" value="${user}" name="username">
    <table class="table table-striped">
            <thead >
            <tr>
                <td scope="col" >#</td>
                <td scope="col" >Album Name</td>

                <td scope="col">Number</td>
                <td scope="col">Price</td>
            </tr>
            </thead>

            <c:forEach items="${albums}" var="category">
                <tbody>
                <td scope="row"> <c:out value="${category.id}"/> </td>
                <td scope="row"> <c:out value="${category.albumname}"/> </td>
<td scope="row"><input class="input-group-text" value="1" type="number" name="${category.id}"></td>
                <td scope="row"> <c:out value="${category.albumprice}"/> </td>

                </tbody>
            </c:forEach>

       </table>
    <button type="submit" style="margin-top: 5px;" class="btn btn-primary">Continue</button>

</form>
        </c:if>
    </div>
</div>

</body>
</html>
