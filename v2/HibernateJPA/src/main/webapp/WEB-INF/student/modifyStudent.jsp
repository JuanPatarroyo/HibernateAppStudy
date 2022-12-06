<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Student</title>
    </head>
    <body>
        <h1>Modify Student!</h1>
        <form name="formStudent" action="${pageContext.request.contextPath}/ServletModify" method="POST">
            <input type="hidden" name="id" value="${student.idStudent}"/>
            Name: <input type="text" name="name" value="${student.name}"/>
            <br/>
            Last Name: <input type="text" name="lastName" value="${student.lastName}"/>
            <br/>
            <br/>
            Address: 
            <br/>
            Street: <input type="text" name="street" value="${student.idAddress.street}"/>
            <br/>
            # Street: <input type="text" name="numberStreet" value="${student.idAddress.numberStreet}"/>
            <br/>
            Country: <input type="text" name="country" value="${student.idAddress.country}"/>
            <br/>
            <br/>
            Contact:
            <br/>
            Email: <input type="email" name="email" value="${student.idContact.email}"/>
            <br/>
            Phone: <input type="tel" name="phone" value="${student.idContact.phone}"/>
            <br/>
            <input type="submit" name="add" value="Edit"/>
            <input type="submit" name="delete" value="Delete"/>
        </form>
    </body>
</html>
