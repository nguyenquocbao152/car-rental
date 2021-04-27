<%-- 
    Document   : viewDetail
    Created on : Mar 26, 2021, 4:48:33 AM
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
                                        <th>Car ID</th>
                                        <th>Date Rent</th>
                                        <th>Date Return</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Feedback</th>

                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listDetail}" var="rd" varStatus="counter"> 
                                <form action="feedback">

                                    <tr>
                                        <td>${counter.count}</td>
                                        <td>
                                            ${rd.rentID}
                                            <input type="text" name="txtRentID" value="${rd.rentID}" />
                                        </td>
                                        <td>
                                            ${rd.carID}
                                            <input type="hidden" name="txtCarID" value="${rd.carID}" />
                                        </td>
                                        <td>${rd.dateRent}</td>
                                        <td>${rd.dateReturn}</td>
                                        <td>${rd.price}</td>
                                        <td>${rd.quantity}</td>                                                                      
                                        <td>
                                            <input type="text" name="txtFeeback" value="" />
                                            <input type="submit" value="Save" />
                                        </td>                                                                      
                                    </tr>
                                </form>
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
