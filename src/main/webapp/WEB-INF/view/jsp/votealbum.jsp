<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->
    <link href="<c:url value="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>" rel="stylesheet">


    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <c:url value="" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />

</head>
<body>
<%@include file="header.jsp"%>
<div class="container">


    <c:if test="${albums ne null}">
        <security:authentication property="principal.username" var="user"/>
        <table class="table table-striped">
            <thead >
            <tr>
                <td scope="col" >Name</td>
                <td scope="col" >Category</td>
                <td scope="col" >Release Date</td>
                <td scope="col" >Price</td>

                <td scope="col" >Singer nickname</td>
                <td scope="col" >Album sample</td>
          <td scope="col">Vote</td>
            </tr>
            </thead>

            <c:forEach items="${albums}" var="albums">
                <tbody>

                <td scope="row" > <c:out value="${albums.albumname}"/> </td>
                <td scope="row"> <c:out value="${albums.category.name}"/> </td>

                <td scope="row"> <c:out value="${albums.albbumreleasedate}"/> </td>
                <td scope="row"> <c:out value="${albums.albumprice}"/> </td>
                <td scope="row"> <c:out value="${albums.singer.nickname}"/> </td>
                <td scope="row"> <a href='/downloadalbumsampl/?albumid=${albums.id}'>Download Sample</a> </td>
               <td> <form action="/votesavetodb" method="post">
                    <input type="hidden" name="albumid" value="${albums.id}">
                    <input type="hidden" name="username" value="${user}">
                <button type="submit" style="margin-top: 5px;" class="btn btn-primary">Vote</button>
                </form></td>

                </tbody>
            </c:forEach>
        </table>


    </c:if>
</div>
<script type="text/javascript" src="webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>
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