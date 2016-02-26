<%-- 
    Document   : WebLog
    Created on : 26-feb-2016, 9:28:45
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<html>
    <body>
        <div class="container">
            <h1>Welkom op mijn blog! :)</h1>

            <div class="jumbotron">
                <c:forEach var="posting" items="${postings}">
                    <div class="jumbotron">
                        <p class="list-group-item-heading"><b>${posting.title}</b></p>
                        <p class="list-group-item">${posting.content}</p>
                        <span class="label label-default">${date}</span>
                        <a href="posting" class="btn btn-primary btn-sm">Comments</a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
