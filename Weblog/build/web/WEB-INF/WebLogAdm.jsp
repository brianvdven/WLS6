<%-- 
    Document   : WebLogAdm
    Created on : 24-feb-2016, 9:17:39
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>My Blog Adm</h1>

        <a href="#" >View my blog!</a></br>

        <form id="PostForm" method="post" action="ControllerServlet">        
            Title: <input type="text" name="title"/></br>
            Posting: <input type="text" name=" topost"/>
            <input type="submit" value="Post" name="postbutton"/>
        </form>

    </body>
</html>
