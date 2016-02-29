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

    </script>
    <body>

<!--<p class="list-group-item" name="postingId">${postingId}</p>-->
        <p class="list-group-item-heading" name="title"><h1>${title}</h1></p>
    <p class="list-group-item" name="content">${content}</p>



    <p>Comments:</p>
    <c:forEach var="comment" items="${comments}">
        <p class="list-group-item">${comment.content}</p>
    </c:forEach>

    <label for="inputEmail" class="col-lg-2 control-label">New comment</label>
    <form>
        <div class="col-lg-12">
            <input type="text" class="form-control" name="newcomment" placeholder="Comment">
            <input type="submit" name="placecomment" value="Submit"/>
        </div>
    </form>
</body>
</html>
