<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student List</title>
    </head>
    <body>
        Student List
        <br/>
        <a href="${pageContext.request.contextPath}/ServletRedirect">Add</a>
        <br/>
        <table border="1">
            <caption>
                
            </caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Email</th>
                <th>Contact</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/ServletModify?id=${student.idStudent}">${student.idStudent}</a></td>
                    <td>${student.name} ${student.lastName}</td>
                    <td>${student.idAddress.street} ${student.idAddress.numberStreet} ${student.idAddress.country}</td>
                    <td>${student.idContact.email}</td>
                    <td>${student.idContact.phone}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
