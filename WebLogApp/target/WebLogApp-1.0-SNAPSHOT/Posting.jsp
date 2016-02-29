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
    <script type="text/javascript">
        function PostComment(){
        var xhttp = new XMLHttpRequest();
        var commentcontent = document.getElementById("commentbox").value;
        var postingid = document.getElementById("postingid").value;
        var parameters = "newcomment=" + commentcontent + "&postingId=" + postingid;
        xhttp.open("POST", "posting", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.setRequestHeader("Content-length", parameters.length);
        xhttp.setRequestHeader("Connection", "close");
        
        var newelement = document.createElement('div');
        newelement.innerHTML = "etstse";
        document.getElementById("outercomment").appendChild(newelement);

        xhttp.send(parameters);
        }
    </script>
    <body>

        <p class="list-group-item-heading" name="title"><h1>${title}</h1></p>
    <p class="list-group-item" name="content">${content}</p>



    <p>Comments:</p>
    <div id="outercomment">
    <c:forEach var="comment" items="${comments}">
        <div id="innercomment">
            <p class="list-group-item">${comment.content}</p>
            <p class="list-group-item small">${comment.date}</p>
        </div>
    </c:forEach>
    </div>
    <label for="inputEmail" class="col-lg-2 control-label">New comment</label>
    <form name="CommentForm" method="post" action="posting">
        <div class="col-lg-12">
            <input type="hidden" id="postingid" name="postingId" value="${postingId}"/>

            <input type="text" id="commentbox" class="form-control" name="newcomment" placeholder="Comment">
            <input type="submit" name="placecomment" value="Submit"/>
            <input type="button" value="gogo" onclick= "PostComment()"/>
        </div>
    </form>
</body>
</html>
