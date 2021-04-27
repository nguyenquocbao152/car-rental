<%-- 
    Document   : Edit
    Created on : Feb 8, 2021, 10:23:15 PM
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
            <h1>Update Product</h1>
            <c:set var="p" value="${PRODUCT}"/>
            <c:set var="err" value="${requestScope.EROR}"/>
            <!-- Text input-->            
            <div class="form-group">
                <label class="col-md-4 control-label" for="product_id">Product ID</label>  
                <div class="col-md-4">
                    <input id="product_id" name="txtProID" value="${p.id}" placeholder="Product ID" class="form-control input-md" required="" type="text" readonly>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="product_id">Name Product</label>  
                <div class="col-md-4">
                    <input id="product_id" name="txtProName" value="${p.name}" placeholder="Name Product" class="form-control input-md" required="" type="text">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="product_name">Image</label>  
                <div class="col-md-4">
                    <input id="product_name" name="txtImage" value="${p.image}" placeholder="Image" class="form-control input-md" required="" type="text">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="product_name_fr">Price</label>  
                <div class="col-md-4">
                    <c:if test="${not empty err.priceError}">
                        <font color ="red">${err.priceError}</font><br/>
                    </c:if> 
                    <input id="product_name_fr" name="txtPrice" value="${p.price}" placeholder="Price" class="form-control input-md" required="" type="text">

                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="product_name_fr">Quantity</label>  
                <div class="col-md-4">
                    <c:if test="${not empty err.quantityError}">
                        <font color ="red">${err.quantityError}</font><br/>
                    </c:if> 
                    <input id="product_name_fr" name="txtQuantity" value="${p.quantity}" placeholder="Quantity" class="form-control input-md" required="" type="text">

                </div>
            </div>        

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="available_quantity">Tile</label>  
                <div class="col-md-4">
                    <input id="available_quantity" name="txtTitle" value="${p.title}" placeholder="Title" class="form-control input-md" required="" type="text">
                </div>
            </div>
            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="product_categorie">Status</label>
                <div class="col-md-4">
                    
                    <select id="product_categorie" name="Status" class="form-control">                       
                        <option value="true" <c:if test="${p.status == 'true'}">selected</c:if> >true</option>
                        <option value="false" <c:if test="${p.status == 'false'}">selected</c:if> >false</option>
                    </select>
                </div>
            </div>    
            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="available_quantity">Description</label>  
                <div class="col-md-4">
                    <input id="available_quantity" name="txtDescr" value="${p.description}" placeholder="Description" class="form-control input-md" required="" type="text">
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
                        <c:forEach items="${listCC}" var="o">                              
                            <c:if test = "${p.cateID == o.cateID}">                                 
                                <option selected value="${p.cateID}">${o.cateName}</option>
                            </c:if> 

                            <c:if test = "${p.cateID != o.cateID}">                                 
                                <option value="${p.cateID}">${o.cateName}</option>
                            </c:if>   
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="block-center">
                <input class="" type="submit" value="Update" name="btAction" />
            </div>           
        </form>
    </body>
</html>
