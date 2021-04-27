<%-- 
    Document   : register
    Created on : Mar 17, 2021, 7:23:13 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/login2.css" rel="stylesheet" type="text/css"/>
        <script src="js/login.js"></script>
    </head>
    <body>
        <div class="login-page">
            <h1>Register Page</h1>
            <c:set var="error" value="${requestScope.ERROR}" />

            <div class="form">                
                <form class="Login-form" action="register" method="POST">   
                    <c:if test="${not empty error.dulicateEmail}">
                        <font color="red">${error.dulicateEmail}</font>
                    </c:if>

                        <input name="txtEmail" type="text" value="${param.txtEmail}" placeholder="email"/>
                    <c:if test="${not empty error.emailError}">
                        <font color="red">${error.emailError}</font>
                    </c:if>

                        <input name="txtFullName" type="text" value="${param.txtFullName}" placeholder="Full Name"/>
                    <c:if test="${not empty error.nameError}">
                        <font color="red">${error.nameError}</font>
                    </c:if>

                        <input name="txtAddress" type="text" value="${param.txtAddress}" placeholder="address"/>
                    <c:if test="${not empty error.addError}">
                        <font color="red">${error.addError}</font>
                    </c:if>

                        <input name="txtPhone" type="text" value="${param.txtPhone}" placeholder="phoneNumber"/>
                    <c:if test="${not empty error.phoneError}">
                        <font color="red">${error.phoneError}</font>
                    </c:if>

                        <input name="txtPassword" type="password" value="${param.txtPassword}" placeholder="password"/>
                     <c:if test="${not empty error.pasError}">
                        <font color="red">${error.pasError}</font>
                    </c:if>
                        <input name="txtCofirm" type="password" value="${param.txtCofirm}" placeholder="confirm"/>
                    <c:if test="${not empty error.confirmError}">
                        <font color="red">${error.confirmError}</font>
                    </c:if>

                    <input type="submit" value="Register" name="btAction"/>                    
                </form>
            </div>           
        </div>
    </body>
</html>
