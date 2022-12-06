<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add student</title>
    </head>
    <body>
        <h1>Add new Student!</h1>
        <form name="formStudent" action="${pageContext.request.contextPath}/ServletAdd" method="POST">
            Name: <input type="text" name="name"/>
            <br/>
            Last Name: <input type="text" name="lastName"/>
            <br/>
            <br/>
            Address: 
            <br/>
            Street: <input type="text" name="street"/>
            <br/>
            # Street: <input type="text" name="numberStreet"/>
            <br/>
            Country: <input type="text" name="country"/>
            <br/>
            <br/>
            Contact:
            <br/>
            Email: <input type="email" name="email"/>
            <br/>
            Phone: <input type="tel" name="phone"/>
            <br/>
            <input type="submit" name="add" value="Add"/>
        </form>
    </body>
</html>
