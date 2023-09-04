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
    <title>Best Album</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
    <link href="<c:url value="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body>
<%@include file="header.jsp"%>


<div class="container">

    <c:if test="${albums ne null}">

        <table class="table table-striped">
            <thead >
            <tr>
                <td scope="col" width="50">#</td>
                <td scope="col" >Category</td>
                <td scope="col" >Name</td>
                <td scope="col" >Number</td>
            </tr>
            </thead>

            <c:forEach items="${albums}" var="category">

                <tbody>
                <td scope="row"> <c:out value="${category.id}"/> </td>
                <td scope="row"> <c:out value="${category.category.name}"/> </td>
                <td scope="row"> <c:out value="${category.albumname}"/> </td>
                <td scope="row"> <c:out value="${category.counter}"/> </td>
                </tbody>
            </c:forEach>

        </table>

    </c:if>
    <button class="btn btn-primary" onclick="window.location.href = '/admin/topcategory'"> best selling album</button>
</div>

</body>
</html>
