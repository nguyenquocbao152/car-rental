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
        <c:set var="error" value="${requestScope.ERROR}" />
        <div class="container">
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="home">Home</a></li>                              
                            <li class="breadcrumb-item"><a href="#"></a></li>

                            <form action="search">
                                <div class="input-group input-group-sm"> 
                                    <c:if test="${not empty error.namError}">
                                        <font color="red">${error.namError}</font>
                                    </c:if>
                                        <input value="${param.txtName}" name="txtName" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="SearchName...">
                                    <label for="cars">Choose a car:</label>
                                    <select id="cars" name="Category">
                                        <c:forEach items="${ListC}" var="ca">
                                            <option value="${ca.cateID}">${ca.cateName}</option>
                                        </c:forEach>
                                    </select>

                                    
                                    <label for="start">Rental Date:</label>
                                    <input type="date" id="start" name="txtRetalDate"
                                           value="${param.txtRetalDate}"
                                           min="2021-01-01" max="2021-12-31">

                                    <label for="start">Return  Date:</label>
                                    <input type="date" id="start" name="txtReturnDate"
                                           value="${param.txtReturnDate}"
                                           min="2021-01-01" max="2021-12-31">
                                    <c:if test="${not empty error.amount}">
                                        <font color="red">${error.amount}</font>
                                    </c:if>
                                        <input type="text" name="txtAmount" value="${param.txtAmount}" placeholder="SearchAmount..."/>
                                    <div class="input-group-append">
                                        <button type="submit" class="btn btn-secondary btn-number" name="btAction" value="SearchP">
                                            <i class="fa fa-search"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>

                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <jsp:include page="Left.jsp"></jsp:include>
                    <div class="col-sm-9"> 
                        <div class="row">
                        <c:forEach items="${listCar}" var="o">
                            <div class="col-12 col-md-6 col-lg-4">
                                <div class="card">
                                    <img class="card-img-top" src="${o.image}" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?pID=${o.carID}" title="View Product">${o.carName}</a></h4>
                                        <p class="card-text show_txt">${o.title}</p> 
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block">${o.price} $</p>
                                            </div>

                                            <div class="col">
                                                <a href="AddToCart?carID=${o.carID}" class="btn btn-success btn-block">Add to cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>
        <ul class="pagination justify-content-center">
            <c:forEach begin="1" end="${end}" var="i">
                <li class="page-item"><a class="page-link" href="paging?index=${i}">${i}</a></li>
                </c:forEach>
        </ul>
        <!-- Footer -->
        <jsp:include page="Footer.jsp"></jsp:include>
    </body>
</html>

