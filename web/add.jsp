<%-- 
    Document   : add
    Created on : Mar 21, 2021, 3:56:48 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <style>
            h1{
                text-align: center;

            }
            body{
                background: #F8F8FF;
            }

            .block-center {
                width: 300px; 
                margin: 0 auto
            }
            .block-center input{
                width: 100px;
                height: 30px;
            }
        </style>
    </head>
    <body>
        <form class="form-horizontal" action="DispatcherServlet" method="POST">
            <!-- Form Name -->
            <h1>Add Product</h1>
            <c:set var="err" value="${requestScope.ERROR}"/>
            <div class="form-group">                
                <label class="col-md-4 control-label" for="product_id">Product ID</label>  
                <div class="col-md-4">
                    <c:if test="${not empty err.dulicateProId}">
                        <font color ="red">${err.dulicateProId}</font><br/>
                    </c:if> 
                        <input id="product_id" name="txtProID" value="${param.txtProID}" placeholder="Product ID" class="form-control input-md" required="" type="text">

                </div>
            </div>
            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label" for="product_id">Name Product</label>  
                <div class="col-md-4">
                    <input id="product_id" name="txtProName" value="${param.txtProName}" placeholder="Name Product" class="form-control input-md" required="" type="text">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="product_name">Image</label>  
                <div class="col-md-4">
                    <input id="product_name" name="txtImage" value="${param.txtImage}" placeholder="Image" class="form-control input-md" required="" type="text">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="product_name_fr">Price</label>  
                <div class="col-md-4">                    
                    <input id="product_name_fr" name="txtPrice" value="${param.txtPrice}" placeholder="Price" class="form-control input-md" required="" type="text">
                    <c:if test="${not empty err.priceError}">
                        <font color="red">${err.priceError}</font>
                    </c:if> 
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="product_name_fr">Quantity</label>  
                <div class="col-md-4">
                    <input id="product_name_fr" name="txtQuantity" value="${param.txtQuantity}" placeholder="Quantity" class="form-control input-md" required="" type="text">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="available_quantity">Tile</label>  
                <div class="col-md-4">
                    <input id="available_quantity" name="txtTitle" value="${param.txtTitle}" placeholder="Title" class="form-control input-md" required="" type="text">
                </div>
            </div>
            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="available_quantity">Description</label>  
                <div class="col-md-4">
                    <input id="available_quantity" name="txtDescr" value="${param.txtDescr}" placeholder="Description" class="form-control input-md" required="" type="text">
                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="product_categorie">Category</label>
                <div class="col-md-4">
                    <c:if test="${not empty err.cateIdError}">
                        <font color ="red">${err.cateIdError}</font><br/>
                    </c:if> 
                    <select id="product_categorie" name="Category" class="form-control">
                        <option value="">Select category</option>
                        <c:forEach var="ca" items="${listCC}">
                            <option value="${ca.cateID}">${ca.cateName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="block-center">
                <input class="" type="submit" value="Add" name="btAction" />
            </div>           
        </form>
    </body>
</html>
