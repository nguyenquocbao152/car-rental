<%-- 
    Document   : ManagerProduct
    Created on : Dec 28, 2020, 5:19:02 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
            .col-sm-6 a{
                color : white;
                background: #008000;
                padding : 10px;
                text-align: right;
            }
            
        </style>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Manage <b>Product</b></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="add.jsp">Add  a new product</a>                            						
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="selectAll">
                                    <label for="selectAll"></label>
                                </span>
                            </th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Image</th>
                            <th>Price</th>
                            <th>Category/Status</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listP}" var="o">
                            <tr>
                                <td>
                                    <span class="custom-checkbox">
                                        <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                        <label for="checkbox1"></label>
                                    </span>
                                </td>
                                <td>
                                    ${o.id}</td>
                                <td>
                                    ${o.name}</td>
                                <td>
                                    <img src="${o.image}">
                                </td>
                                <td>${o.price} $</td>
                                <td>
                                    <div class="form-group">
                                        <select name="category" class="form-select"s>                                                                                        
                                            <c:forEach items="${listCC}" var="c">
                                                <c:if test = "${c.cateID == o.cateID}">      
                                                     <option value="2">${c.cateName}</option>
                                                </c:if> 
                                            </c:forEach>
                                            <option value="1">${o.status}</option>         
                                        </select>
                                    </div>
                                </td>
                                <td>
                                    <a class="nav-link" href="LoadUpServlet?pID=${o.id}">Update</a>  
                                    <a href="DispatcherServlet?btAction=Delete&pID=${o.id}"class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="clearfix">
                    <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                    <ul class="pagination">
                        <c:forEach begin="1" end="${end}" var="i">
                            <li class="page-item"><a href="DispatcherServlet?btAction=MPaging&index=${i}" class="page-link">${i}</a></li>
                            </c:forEach>                                                                    
                    </ul>
                </div>
            </div>
            <a href="ManagerProductServlet"><button type="button" class="btn btn-primary">Back to home</button>
        </div>                        
    <script src="js/manager.js" type="text/javascript"></script>
</body>
</html>