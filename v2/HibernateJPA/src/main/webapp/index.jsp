<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <jsp:include page="/resources/libraries.jsp" />
    </head>
    <body class="background d-flex justify-content-center">
        <div id="containerIndex" class="container">
            <div class="row">
                <div class="col text-center">
                    <h5 class="display-5">Student's application</h5>
                </div>
            </div>
            <hr/>
            <div class="row">
                <div class="col text-center">
                    <a class="btn btn-warning" href="${pageContext.request.contextPath}/ServletController">Student List</a>  
                </div>
            </div>
        </div>
        <footer class="footer">
            <div class="container">
                <div class="row">
                    <div class="col text-end">
                        <p>Developed by Juanes!</p>
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>
