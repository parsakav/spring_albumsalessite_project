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
        <div class="card">
            <form class="text-center border border-light p-5" action="/admin/bestvote" method="post">
                <select required name="category" >
                    <c:forEach items="${categories}" var="category">

                        <option value="${category.name}">${category.name}</option>
                    </c:forEach>
                </select>
                <button class="btn btn-info btn-block my-4" type="submit">Continue</button>


            </form>
            <!-- Default form login -->
        </div>

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
<br>


</body>
</html>