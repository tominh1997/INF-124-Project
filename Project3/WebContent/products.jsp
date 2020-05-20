<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/navbar.css">
    <link rel="stylesheet" type="text/css" href="css/best-seller.css">
    <link rel="stylesheet" type="text/css" href="css/product-list.css">
    <meta charset="UTF-8">
</head>
<body>

<div class="navbar">
    <a href="homepage">
        <img src="images/logo/logo.png" alt="logo" style="width: 100px; height: 100px;">
    </a>
    <div class="subnav">
        <a href="about-us.html">About Us</a>
    </div>
    <div class="subnav-left">
        <a href="homepage">Home</a>
    </div>
    <div class="subnav-right">
        <button class="subnavbtn">Products <i class="fa fa-caret-down"></i></button>
        <div class="subnav-content">
            <a href="products?type=White&forward=true"> White Chocolate</a>
            <a href="products?type=Dark&forward=true">Dark Chocolate</a>
            <a href="products?type=Milk&forward=true">Milk Chocolate</a>
        </div>
    </div>
    <div class="subnav-right-right">
	    <a href="checkout"><i class="fa fa-shopping-cart fa-7x"></i></a>
	</div> 
</div>

<div class="best-seller">
    <span class="header">Best Seller</span>
    <div class="row">
        <c:forEach items="${products}" var="product" begin="0" end="2">
        <a href="productDescription?id=${product.id}">
            <img src="data:image/jpg;base64,${product.image1}"/>
        </a>
        </c:forEach>
    </div>
</div>

<hr>
<div class="header">
    <span >${type} Chocolate Products</span>
</div>

<table style="width:100%; padding-left: 30px;">
    <tr class="product-list">
        <c:forEach items="${products}" var="product" begin="0" end="4">
            <td>
                <div class="product-cell">
                    <a href="productDescription?id=${product.id}">
                        <img src="data:image/jpg;base64,${product.image1}"/>
                        <span> ${product.name} </span>
                    </a>
                    <span> $ ${product.price} </span>
                </div>
            </td>
        </c:forEach>
    </tr>
    <tr class="product-list">
        <c:forEach items="${products}" var="product" begin="5">
            <td>
                <div class="product-cell">
                    <a href="productDescription?id=${product.id}">
                        <img src="data:image/jpg;base64,${product.image1}"/>
                        <span> ${product.name} </span>
                    </a>
                    <span> $ ${product.price} </span>
                </div>
            </td>
        </c:forEach>
    </tr>
</table>

</body>
</html>
