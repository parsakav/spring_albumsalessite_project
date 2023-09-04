
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Add Singer</title>
    <link href="<c:url value="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>" rel="stylesheet">

</head>
<body>

<div class="container">
    <div class="card">
        <form class="text-center border border-light p-5" action="/admin/addsingertodb" method="post">

            <p class=" h4 mb-4">Add Singer</p>


            <input type="text"  class="form-control mb-4" placeholder="First name" name="fname" required>
            <input type="text"  class="form-control mb-4" placeholder="Last name" name="lname" required>
            <input type="text"  class="form-control mb-4" placeholder="Nick name" name="nickname" required>



            <button class="btn btn-info btn-block my-4" type="submit">Submit</button>


        </form>
    </div>

</div>

<c:if test="${error ne null}">
    <br>
    <span>error: ${error}</span>
</c:if>
<br>
</body>

</html>
