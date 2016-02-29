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
                    <form name="postingform" action="posting" methdo="GET">
                        <input type="hidden" name="hiddenId" value="${posting.id}"/>
                        <div class="jumbotron">         
                            <p class="list-group-item-heading"><b>${posting.title}</b></p>
                            <p class="list-group-item">${posting.content}</p>
                            <span class="label label-default">${date}</span>
                            <input type="submit" name="commentbtn" value="Comments" class="btn btn-primary btn-sm">
                        </div>
                    </form>

                </c:forEach>
            </div>
        </div>
    </body>
</html>
