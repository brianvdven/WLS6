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
        function PostComment() {
            var xhttp = new XMLHttpRequest();
            var commentcontent = document.getElementById("commentbox").value;
            var postingid = document.getElementById("postingid").value;
            var parameters = "newcomment=" + commentcontent + "&postingId=" + postingid;
            xhttp.open("POST", "posting", true);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.setRequestHeader("Content-length", parameters.length);
            xhttp.setRequestHeader("Connection", "close");

//            var newelement = document.createElement('div');
            var newelement2 = document.createElement('p');
            newelement2.className = ".list-group-item";
            newelement2.innerHTML = commentcontent;
//            newelement.appendChild(newelement2);

//            xhttp.open("GET", "posting", true);

            document.getElementById("outercomment").appendChild(newelement2);
            document.getElementById("commentbox").value = '';
            xhttp.send(parameters);
        }
    </script>
    <body>

        <p class="list-group-item-heading" name="title"><h1>${title}</h1></p>
    <p class="list-group-item" name="content">${content}</p>



    <p>Comments:</p>
    <div id="outercomment">
        <c:forEach var="comment" items="${comments}">
            <p >${comment.content}</p>
        </c:forEach>
    </div>
    <label for="inputEmail" class="col-lg-2 control-label">New comment</label>
    <form name="CommentForm" method="post" action="posting">
        <div class="col-lg-12">
            <input type="hidden" id="postingid" name="postingId" value="${postingId}"/>

            <input type="text" id="commentbox" class="form-control" name="newcomment" placeholder="Comment">
            <!--<input type="submit" name="placecomment" value="Submit"/>-->
            <input type="button" value="Ajax submit" onclick= "PostComment()"/>
        </div>
    </form>
</body>
</html>
