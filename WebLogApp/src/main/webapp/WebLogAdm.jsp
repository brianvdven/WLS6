<%-- 
    Document   : WebLogAdm
    Created on : 26-feb-2016, 9:40:50
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<html>
    <body>
        <div class="container">
            <form class="form-horizontal col-lg-12">
                    <legend>New Post</legend>
                    <div class="form-group jumbotron">
                        <label for="inputEmail" class="col-lg-2 control-label">Title</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="inputEmail" placeholder="Title  ">
                        </div>
                    </div> 
                    <div class="form-group jumbotron">
                        <label for="textArea" class="col-lg-2 control-label">Post</label>
                        <div class="col-lg-10">
                            <textarea class="form-control" rows="3" id="textArea"></textarea>
                            <span class="help-block">A longer block of help text that breaks onto a new line and may extend beyond one line.</span>
                        </div>
                    </div>
            </form>
        </div>
    </body>
</html>
