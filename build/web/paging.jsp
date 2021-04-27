<%-- 
    Document   : paging
    Created on : Jan 31, 2021, 10:54:29 PM
    Author     : Administrator
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <link href="css/paging.css" rel="stylesheet" type="text/css"/>
    </head>
</head>
<body>
    <ul class="pagination justify-content-center">
        <c:forEach begin="1" end="5" var="i">
            <li class="page-item"><a class="page-link" href="#">${i}</a></li>
        </c:forEach>
    </ul>
</body>
</html>
