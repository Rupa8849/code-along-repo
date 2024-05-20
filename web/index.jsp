<%-- 
    Document   : index
    Created on : Feb 21, 2023, 12:17:52 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="js/index.js"></script>
        <%@include file="header.jsp" %>

    </head>
    <body>
        <div class="container-fluid w-75">
            <form>
                <div class="mb-3 mt-3">
                    <label for="username" class="form-label">Username:</label>
                    <input type="text" class="form-control" id="username" placeholder="Enter Username" name="username">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password:</label>
                    <input type="password" class="form-control" id="password" placeholder="Enter Password" name="password">
                </div>
                <button class="btn btn-primary" onclick="return validateForm()">Submit</button>
                <button type="reset" class="btn btn-warning">RESET</button>
            </form>
            <br/>
            If you are not registered, kindly register here: <a href="registration.jsp" class="link-primary">Registration Form</a>
        </div>
        <div id="ajax" >

         

        
    </body>
</html>
