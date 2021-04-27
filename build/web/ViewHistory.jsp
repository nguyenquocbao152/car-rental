<%-- 
    Document   : ViewHistory
    Created on : Mar 26, 2021, 4:07:31 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <link href="css/paging.css" rel="stylesheet" type="text/css"/>

        <style>
            .input-group label{
                display: inline;
                font: 1rem 'Fira Sans', sans-serif;
            }
            .input-group input,label{
                margin: .4rem 0;
            }
        </style>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <h1>History order</h1>
        <div class="container">
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="home">Home</a></li>                                                                             
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">

                <div class="col-sm-9"> 
                    <div class="row">
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>No.</th>                                   
                                    <th>Rent ID</th>
                                    <th>Email</th>
                                    <th>Date</th>
                                    <th>Total</th>
                                    <th>View Detail</th>
                                    <th>Delete</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${ListRent}" var="re" varStatus="counter">
                                    <tr>
                                        <td>${counter.count}</td>
                                        <td>${re.rentID}</td>
                                        <td>${re.email}</td>
                                        <td>${re.date}</td>
                                        <td>${re.total}</td>
                                        <td>
                                            <a href="ViewDetail?rentID=${re.rentID}">View Details</a>
                                        </td>
                                        <td>
                                            <a href="DeleteOrder?rentID=${re.rentID}">Delete</a>
                                        </td>
                                    </tr>
                            </c:forEach>                                
                        </tbody>
                    </table>

                </div>
            </div>

        </div>
    </div>
    
    <!-- Footer -->
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
