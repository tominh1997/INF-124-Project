<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/homePage.css">
<link rel="stylesheet" href="css/navbar.css">
<script src="js/myScript.js"></script>
<meta charset="UTF-8">
</head>
<body>
<div class="navbar">
  <a href="#home"> 
      <img src="images/logo/logo.png" alt="logo" style="width: 100px; height: 100px;">
  </a>
  <div class="subnav-left">
    <a href="homepage.jsp">Home</a>
  </div> 
  <div class="subnav">
    <a href="about-us.html">About Us</a>
  </div> 
  <div class="subnav-right">
    <button class="subnavbtn">Products <i class="fa fa-caret-down"></i></button>
    <div class="subnav-content">
      <a href="products.php?type=white"> White Chocolate</a>
      <a href="products.php?type=dark">Dark Chocolate</a>
      <a href="products.php?type=milk">Milk Chocolate</a>
    </div>
  </div>
</div>

<!-- Slideshow container -->
<div class="slideshow-container">
    <!-- Slide 1: About Us -->
    <div id="slide1" class="mySlides fade">
      <img class="slideImage" src="images/about-us.jfif">
    <div class="textContainer">
      <h1 class="slidesHeading">About Us</h1>
      <h3 class="slidesDescription">As ChocoHolics Chocolate Factory, our mission is to make the world both bitter and sweeter one person at a time 
        by offering high quality chocolate boxes to our customers.
      </h3>
      <a href="about-us.html"> <button class="slideButton">  Learn More </button> </a>
      <div id="navigation" style="text-align:center">
        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
        <span class="dot active" onclick="showSlide(1)"></span>
        <span class="dot" onclick="showSlide(2)"></span>
        <span class="dot" onclick="showSlide(3)"></span>
        <span class="dot" onclick="showSlide(4)"></span>
        <a class="next" onclick="plusSlides(1)">&#10095;</a>
      </div>
    </div>
    </div>
    <!-- Slide 2: White Chocolate -->
    <div class="mySlides fade">
      <img class="slideImage" src="images/white.png">
    <div class="textContainer">
      <h1 class="slidesHeading">Sweet Dreams That You Can't Resist</h1>
      <h3 class="slidesDescription">Creamy, sweet and rich in flavor. Try out our white chocolates and fall in love with them in your dreams.</h3>
      <a href="products.php?type=white"> <button class="slideButton">  Learn More </button> </a>
      <div class="navigation" style="text-align:center">
        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
        <span class="dot" onclick="showSlide(1)"></span>
        <span class="dot active" onclick="showSlide(2)"></span>
        <span class="dot" onclick="showSlide(3)"></span>
        <span class="dot" onclick="showSlide(4)"></span>
        <a class="next" onclick="plusSlides(1)">&#10095;</a>
      </div>
    </div>
    </div>
    <!-- Slide 3: Dark Chocolate -->
    <div class="mySlides fade">
      <img class="slideImage" src="images/dark.jpg">
    <div class="textContainer">
      <h1 class="slidesHeading">Addicting Flavor That You Can't Stop</h1>
      <h3 class="slidesDescription">Bitter, bold and rich in flavor. Try out our dark chocolates and you would wish you have bought more.</h3>
      <a href="products.php?type=dark"> <button class="slideButton">  Learn More </button>  </a>
      <div class="navigation" style="text-align:center">
        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
        <span class="dot" onclick="showSlide(1)"></span>
        <span class="dot" onclick="showSlide(2)"></span>
        <span class="dot active" onclick="showSlide(3)"></span>
        <span class="dot" onclick="showSlide(4)"></span>
        <a class="next" onclick="plusSlides(1)">&#10095;</a>
      </div>
    </div>
    </div>
    <!-- Slide 4: Milk Chocolate -->
    <div class="mySlides fade">
      <img class="slideImage" src="images/milk.jpg">
    <div class="textContainer">
      <h1 class="slidesHeading">Mixtures of Goodness That You Can't Have Enough</h1>
      <h3 class="slidesDescription">Milky, sweet and smooth in flavor. Try out our milk chocolates and you can never have enough of them.</h3>
      <a href="products.php?type=milk"> <button class="slideButton">  Learn More </button> </a>
      <div class="navigation" style="text-align:center">
        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
        <span class="dot" onclick="showSlide(1)"></span>
        <span class="dot" onclick="showSlide(2)"></span>
        <span class="dot" onclick="showSlide(3)"></span>
        <span class="dot active" onclick="showSlide(4)"></span>
        <a class="next" onclick="plusSlides(1)">&#10095;</a>
      </div>
    </div>
    </div>
</div>
<br>

<div> ${test} </div>
<table>
    <c:forEach items="${whiteProducts}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.type}</td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>
</table>

<div class = "description"> 
    <div class = "description-img"> 
        <a href = "products.php?type=white"> <img src="images/wc1.jpg"> </a>
    </div>
    
    <div> 
        <p>
        A Dutch chemist by the name of Coenraad Van Houten was the one who discovered how to separate the cocoa liquor into cocoa powder and cocoa butter. On a side note, it was Coenraad Van Houten who also invented “Dutched Cocoa Powder,” which is made by treating the cocoa powder with alkaline salts. Whilst this improves the mixability for cooking baking purposes, it also washes out crucial nutrients found in cacao powder.
        <br><br> 
        It wasn’t until many years later that the cocoa butter was mixed together with sugar and milk powder to create the first white chocolate bar. The same process is used today and thanks to craft chocolate makers, white chocolate is making a proud come back as a delicious fine food.
        <br><br> 
        Some chocolate makers even have caramelised white or blonde bars on offer. These bars are made by heating the white chocolate mixture for longer than usual causing the sugar to caramelise and create a fudgy flavour and golden colour.
        </p>  
    </div>

</div>
<hr>
    
<div class = "description"> 
    <div class = "description-img"> 
        <a href = "products.php?type=dark"> <img src="images/dc1.jpg"> </a>
    </div>
    
    <div> 
        <p>
           Once the cacao pods have been harvested from the tree, the cocoa beans within are removed and fermented to a certain standard. The fermented beans are then dried and shipped to the chocolate maker who roasts them. After they’ve been roasted they are cracked and sorted.
            <br><br>
            The inside of the bean, also known as cocoa nibs, are separated from the shell, or husk. The nibs, along with the cocoa butter, are then ground and heated to create a thick chocolatey substance known as cocoa liquor.
            <br><br>
            If sugar is part of the recipe then it’s added towards the end of the mixing process. The chocolate is then cooled in a process also known as tempering before it’s poured into chocolate bar moulds. This process is the standard chocolate-making process and is also known as “bean to bar.”
        </p>  
    </div>

</div>
<hr>
    
<div class = "description"> 
    <div class = "description-img"> 
        <a href = "products.php?type=milk"> <img src="images/mc1.jpg"> </a>
    </div>
    
    <div> 
        <p>
         A Swiss chemist and entrepreneur, Henri Nestlé, discovered how to produce powdered milk in 1867. Fast forward a few years and people started mixing the powdered milk together with the cocoa liquor during the bean to bar process. This method is still used by chocolate makers today.
        </p>  
    </div>

</div>
<hr>


<!-- Load jQuery and Bootstrap JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="homepage.js"></script>
</body>
</html>