<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="HomeServlet">Car Shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">




                <c:if test="${sessionScope.ACCOUNT != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Hello ${sessionScope.ACCOUNT.fullname}</a>
                    </li>
                    <li class="nav-item">
                        <form action="logout" method="POST">
                            <input type="submit" value="Logout" name="btAction" />
                        </form> 
                    </li>  
                    <li class="nav-item">
                        <a class="nav-link" href="viewHistory">View History</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.ACCOUNT == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="login2.jsp">Login</a>
                    </li>
                </c:if>

            </ul>
            <form action="DispatcherServlet"class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">

                    <input value="" name="txtSearch" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">                    
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number" name="btAction" value="SearchN">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>                               
                <a class="btn btn-success btn-sm ml-3" href="Cart.jsp">                        
                    <i class="fa fa-shopping-cart"></i> Cart                         
                    <span class="badge badge-light">${Count}</span>
                </a>                   
            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading"></h1>
        <p class="lead text-muted mb-0"></p>
    </div>
</section>
<!--end of menu-->
