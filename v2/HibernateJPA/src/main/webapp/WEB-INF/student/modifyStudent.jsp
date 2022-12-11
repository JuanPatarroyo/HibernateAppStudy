<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Student</title>
        <jsp:include page="/resources/libraries.jsp" />
    </head>
    <body>
        <jsp:include page="/resources/navbar.jsp" />
        <div class="container" style="padding-top: 1%;">
            <form class="card p-3 bg-light" name="formStudent" action="${pageContext.request.contextPath}/ServletModify" method="POST">
                <input type="hidden" name="id" value="${student.idStudent}"/>
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" class="form-control" id="name" name="name" aria-describedby="Type your name" 
                           value="${student.name}"/>
                </div>
                <div class="mb-3">
                    <label for="lastName" class="form-label">LastName</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" value="${student.lastName}"/>
                </div>
                <div class="mb-3">
                    <label for="street" class="form-label">Street</label>
                    <input type="text" class="form-control" id="street" name="street" value="${student.idAddress.street}"/>
                </div>
                <div class="mb-3">
                    <label for="numberStreet" class="form-label">Street's Number</label>
                    <input type="text" class="form-control" id="numberStreet" name="numberStreet" value="${student.idAddress.numberStreet}"/>
                </div>
                <div class="mb-3">
                    <label for="country" class="form-label">Country</label>
                    <input type="text" class="form-control" id="country" name="country" value="${student.idAddress.country}"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Contact</label>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" value="${student.idContact.email}"/>
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">Phone</label>
                    <input type="tel" class="form-control" id="phone" name="phone" value="${student.idContact.phone}"/>
                </div>
                <div class="row">
                    <div class="col-md-2 offset-md-10">
                        <input type="submit" name="add" value="Edit" class="btn btn-warning"/>
                        <input type="submit" name="delete" value="Delete" class="btn btn-danger"/>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
