<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/navbar.css">
    <link rel="stylesheet" type="text/css" href="css/description.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src ="addCart.js"></script>
    <script defer src = "js/orderCheck.js"></script>
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
</div>


<div class = "header">
    <h1>${product.name}</h1>
</div>

<div class="description">
    <div style="width:100%; text-align: center;">
        <img src="data:image/jpg;base64,${product.image1}"/>
        <img src="data:image/jpg;base64,${product.image2}"/>
        <img src="data:image/jpg;base64,${product.image3}"/>
    </div>

    <p>
        <strong> $${product.price} </strong> <br>
        <strong> ${product.description} </strong>
    </p>
</div>
<hr>
<div style="width:100%; text-align: center;">
    <a href="addToCart?id=${product.id}">
    <button id="sdButton" onclick="">Add To Cart</button>
    </a>
</div>
</body>
</html>

