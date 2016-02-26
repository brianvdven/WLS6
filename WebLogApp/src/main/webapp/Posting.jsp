<%-- 
    Document   : Posting
    Created on : 26-feb-2016, 21:17:49
    Author     : Brian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<jsp:include page="header.jsp"/>

<html>
    <body>
        <h1>Title here</h1>

        <p class="list-group-item-heading">${posting.title}</p>
        <p class="list-group-item">${posting.content}</p>

        <c:forEach var="comment" items="${comments}">
            <p>${comment.content}</p>
        </c:forEach>

        <!--<div class="form-group">-->
            <label for="inputEmail" class="col-lg-2 control-label">Comment</label>
            <div class="col-lg-12">
                <input type="text" class="form-control" name="newcomment" placeholder="Comment">
            </div>
        <!--</div>-->

    </body>
</html>
