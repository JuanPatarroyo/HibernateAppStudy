<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student List</title>
        <jsp:include page="/resources/libraries.jsp" />
    </head>
    <body>
        <jsp:include page="/resources/navbar.jsp" />
        <div class="container">
            <div class="row" style="padding-top: 1%;">
                <div class="col-md-1 offset-md-11">
                    <a class="btn btn-warning" href="${pageContext.request.contextPath}/ServletRedirect">Add</a>  
                </div>
            </div>
            <table class="table table-bordered table-striped" style="margin-top: 1%;">
                <thead class="table-warning">
                    <tr>
                        <th class="text-center">ID</th>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Email</th>
                        <th>Contact</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${students}">
                        <tr>
                            <td class="text-center"><a href="${pageContext.request.contextPath}/ServletModify?id=${student.idStudent}">${student.idStudent}</a></td>
                            <td>${student.name} ${student.lastName}</td>
                            <td>${student.idAddress.street} ${student.idAddress.numberStreet} ${student.idAddress.country}</td>
                            <td>${student.idContact.email}</td>
                            <td>${student.idContact.phone}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
