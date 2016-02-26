<%-- 
    Document   : Login.asp
    Created on : 26-feb-2016, 22:00:10
    Author     : Brian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>

<html>

    <body>
        <h1>Loginpage</h1>
        <div class="form-group">
            <label for="inputEmail" class="col-lg-2 control-label">Username</label>
            <div class="col-lg-10">
                <input type="text" class="form-control" name="username" placeholder="Email">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="col-lg-2 control-label">Password</label>
            <div class="col-lg-10">
                <input type="password" class="form-control" id="inputPassword" placeholder="Password">
            </div>
    </body>
</html>
