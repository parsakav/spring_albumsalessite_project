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
    <br>

    <c:if test="${albums ne null}">
        <security:authorize access="hasRole('USER')">

            <form action="/test" method="post">
        </security:authorize>
        <table class="table table-striped">
            <thead >
            <tr>
                <td scope="col" >Name</td>
                <td scope="col" >Category</td>
                <td scope="col" >Release Date</td>
                <td scope="col" >Price</td>

                <td scope="col" >Singer nickname</td>
                <td scope="col" >Album sample</td>
                <security:authorize access="hasRole('USER')">

                    <td scope="col" >Buy album</td>
                </security:authorize>
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
                <security:authorize access="hasRole('USER')">
                    <td scope="row"><input type="checkbox" name="${albums.id}"></td>
                </security:authorize>
                </tbody>
            </c:forEach>
        </table>

        <security:authorize access="hasRole('USER')">
            <button type="submit" style="margin-top: 5px;" class="btn btn-primary">Buy Albums </button>
            </form>
            <button style="margin-top: 5px" class="btn btn-primary " onclick="window.location.href = 'vote'">Vote</button>

        </security:authorize>

    </c:if>
<c:if test="${albums.size() == 0}">
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

</c:if>
</div>

<script type="text/javascript" src="webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>
</body>

</html>