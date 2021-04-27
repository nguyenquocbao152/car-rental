<%-- 
    Document   : login2
    Created on : Jan 21, 2021, 8:35:03 PM
    Author     : Administrator
--%>

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

        <!-- reCAPTCHA Libary -->
        <script src='https://www.google.com/recaptcha/api.js?hl=en'></script>

    </head>
    <body>
        <div class="login-page">
            <h1>Login Page</h1>
            <div class="form">
                <p style="color:red;">${errorString}</p>                
                <form class="Login-form" action="login" method="POST">                       
                    <input name="txtEmail" type="text" value="${param.txtEmail}" placeholder="email"/>                                        
                    <input name="txtPassword" type="password" value="${param.txtPassword}" placeholder="password"/>   
                    <!-- reCAPTCHA -->
                    <div class="g-recaptcha"
                         data-sitekey="6Lee0okaAAAAAHze8WlEpR843jE6Hyvyub_Kxhf7"></div>

                    <input type="submit" value="Login" name="btAction"/>  
                    <a href="register.jsp">Create an account</a>
                </form>
            </div>           
        </div>
    </body>
</html>
