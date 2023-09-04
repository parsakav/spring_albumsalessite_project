
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <link href="<c:url value="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>" rel="stylesheet">

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Add Category</title>

</head>
<body>

<div class="container">


        <p class=" h4 mb-4">Add Category</p>
        <c:if test="${categories ne null}">
            <table class="table table-striped">
                <thead >
                <tr>
                    <td scope="col" >#</td>
                    <td scope="col">Name</td>
                </tr>
                </thead>

                <c:forEach items="${categories}" var="category">

                    <tbody>
                    <td scope="row"> <c:out value="${category.id}"/> </td>
                    <td scope="row"> <c:out value="${category.name}"/> </td>
                    </tbody>
                </c:forEach>

            </table>
        </c:if>
    <div class="card">

    <form class="text-center border border-light p-5" enctype="multipart/form-data" action="/admin/addcategory" method="post">


            <input  type="text" contenteditable="false" class="form-control mb-4" placeholder="category name" name="categoryname" >
            <br>
            <button class="btn btn-info btn-block my-4" type="submit">Submit</button>

        </form>


    </div>

        <a  class="btn btn-primary" href="/admin">Admin page</a>

    <script type="text/javascript" src="webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>
    <br>
</body>

</html>
