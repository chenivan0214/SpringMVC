<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contentPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:out value="${contentPath}" />/resources/js/jquery.min.js"></script>
<title>Sample - Get and Post</title>
</head>
<body>

<div id="container">
    <c:choose>
        <c:when test="${code  == '1'}" >
            <form action="${contentPath}/sample/getandpost?code=2" method="post">
            Name:<input type="text" id="name" name="name" />
            <br/>
            Password:<input type="password" id="passwd" name="passwd" />
            <br/>
            <input type="submit" value="submit"/>
            </form>
        </c:when>
        <c:when test="${code  == '2'}" >
        Name:<c:out value="${name}"/>
        <br/>
        Password:<c:out value="${passwd}"/>
        <!--
        <c:out value="${modelUser.getName()}" /> / <c:out value="${modelUser.getPasswd()}" />
        -->
        <br/>
        <a href="<c:out value="${contentPath}/sample/showmeagain" />">Show me again</a>
        </c:when>
        <c:otherwise>
        Error
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
<script>
(function() {
    console.log($("#container").html());
})();
</script>