
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <link href="<c:url value="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Add Singer</title>

</head>
<body>

<div class="container">


    <div class="card">
        <form class="text-center border border-light p-5" enctype="multipart/form-data" action="/admin/addalbumtodb" method="post">

            <p class=" h4 mb-4">Add Album</p>

            <input value='${singer_id}' type="hidden" contenteditable="false" class="form-control mb-4" placeholder="singer id" name="id" >
            <input type="text"  class="form-control mb-4" placeholder="Album name" name="albumname" required>
            <input type="date"  class="form-control mb-4" placeholder="Album Release date" name="albumdate" required>
            <input type="number"  class="form-control mb-4" placeholder="Album amount" name="price" required>
            <input class="custom-file" required type="file" name="file" accept="audio/*"/><br/><br/>
            <c:if test="${categories ne null}">
            <select class="custom-select-lg" required name="category" >
            <c:forEach items="${categories}" var="category">

                <option value="${category.name}">${category.name}</option>
            </c:forEach>
            </select>
            </c:if>
            <br>
            <br>
            <button class="btn btn-info btn-block my-4" type="submit">Submit</button>

        </form>
    </div>
<c:if test="${error ne null}">
    <br>
    <span>error: ${error}</span>
</c:if>
<script type="text/javascript" src="webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>
    </div>
<br>

</body>

</html>
