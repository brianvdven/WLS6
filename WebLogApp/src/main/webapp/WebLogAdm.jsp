<%-- 
    Document   : WebLogAdm
    Created on : 26-feb-2016, 9:40:50
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<html>
    <body>
        <div class="container">
            <form method="POST" action="" class="form-horizontal col-lg-12">
                <legend>New Post</legend>
                <div class="form-group jumbotron">
                    <label for="inputEmail" class="col-lg-2 control-label">Title</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" name="title" placeholder="Title  ">
                    </div>
                </div> 
                <div class="form-group jumbotron">
                    <label for="textArea" class="col-lg-2 control-label">Post</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" rows="3" name="content"></textarea>
                        <span class="help-block">A longer block of help text that breaks onto a new line and may extend beyond one line.</span>
                    </div>
                </div>

                <input type="submit" class="btn btn-primary" value="Post"></a>

            </form>
        </div>
        <c:if test="${mode == 'admin'}">
            <div class="container">
                <div class=" col-lg-12">
                    <table class="table table-striped table-hover">
                        <tr>
                            <th>Title</th>
                            <th>Content</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach var="post" items="${postings}">
                            <form method="post">
                            <input type="hidden" name="hiddenpostid" value="${post.id}"
                            <tr>
                                <td>
                                    <input type="text" name="titlepost" value="${post.title}"/>
                                </td>
                                <td>
                                    <input type="text" name="contentpost" value="${post.content}"/>
                                </td>
                                <td>
                                    <input type="submit" value="Edit" name="editbutton"
                                </td>
                                <td>
                                    <input type="submit" value="Delete" name="deletebutton"/>
                                </td>
                            </tr>
                            </form>
                        </c:forEach>
                    </table> 
                </div>
            </div>
        </c:if>

    </body>
</html>
