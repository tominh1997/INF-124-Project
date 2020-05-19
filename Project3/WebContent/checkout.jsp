<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/navbar.css">
<link rel="stylesheet" type="text/css" href="css/about-us.css">
<link rel="stylesheet" type="text/css" href="css/description.css">
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

      
    <div id="confirm">

      <div class="container">
        <div class="section" >
          <h1 class="sectionTitle"> Checkout </h1>
        </div>
      </div>
      <table style="width:100%; padding-left: 20%;" >
          <!---
          <tr>
            <td>
              <div id="title">Product</div>
            </td>
            <td>
              <div id="product">Product</div>
            </td>
          </tr>
          <tr>
            <td>
              <div id="title">Quantity</div>
            </td>
            <td>
              <div id="quantity">Quantity</div>
            </td>
          </tr>
          --->
          <c:forEach items="${cart_items}" var="cart_items">
              <tr>
                  <td>
                      <div id="title">Product</div>
                  </td>
                  <td>
                      <div id="product">${cart_items.name}</div>
                  </td>
              </tr>
              <tr>
                  <td>
                      <div id="title">Quantity</div>
                  </td>
                  <td>
                      <div id="quantity">${cart_items.quantity}</div>
                  </td>
              </tr>
              <tr>
                  <td>
                      <div id="title">Price</div>
                  </td>
                  <td>
                      <div id="price">${cart_items.price}</div>
                  </td>
              </tr>
          </c:forEach>
      </table>


    <div class = "form"> 
        <h1> Order Information </h1>
        <hr> 
        <div id = "error"> </div>
        <form action = "" method = "POST" id = "form" class = "form-layout">
            
            <h2> User Information </h2>
           
            <div class = "info-layout"> 
                <label for = "name"> Name </label>
                <input type = "text" name = "name" id = "name" placeholder="name" required>
           
                <label for = "phone"> Phone Number </label>
                <input type = "tel" name = "phone" id = "phone" placeholder="##########" required>
           
            </div>
            
            <h2> Shipping Address </h2>  
            <div class = "info-layout"> 
                <label for = "adrress"> Address </label>
                <input type = "text" name = "adrress" id = "adrress" placeholder = "street address" required>
    
            
                <label for = "city"> City </label>
                <input type = "text" name = "city" id = "city" required >
    
           
                <label for = "state"> State </label>
                <input type = "text" name = "state" id = "state" required>
    
            
                <label for = "country"> Country </label>
                <input type = "text" name = "country" id = "country" required>
          
                <label for = "zipCode"> Zip Code </label>
                <input type = "text" name = "zipCode" id = "zip" required autocomplete="on">
    
                <label for = "tax"> Tax </label>
                <input readonly type = "text" name = "tax" id = "tax" required>
            </div>
                
            
            <h3> Shipping Method </h3>
            <div> 
                <input type = "radio" name = "shipping method" id = "one-day" value = "1" required>
                <label for = "one-day"> One-Day Shipping  </label>
                
                <input type = "radio" name = "shipping method" id = "two-day" value = "2" required>
                <label for = "two-day"> Two-Day Shipping  </label>
                
                <input type = "radio" name = "shipping method" id = "standard" value = "0" required>
                <label for = "standard"> Standard (4 - 5 business days) </label>
                
            </div>
            
            <h2> Credit Card </h2>  
        
            <h3> Payment Method </h3>
            <div> 
                <input type = "radio" name = "payment method" id = "visa" value = "Visa" required>
                <label for = "visa"> Visa  </label>
    
                <input type = "radio" name = "payment method" id = "master-card" value = "Master Card" required>
                <label for = "master-card"> Master Card  </label>
    
                <input type = "radio" name = "payment method" id = "amex" value = "Amex" required>
                <label for = "amex"> Amex </label>
    
                <input type = "radio" name = "payment method" id = "discover" value = "Discover" required>
                <label for = "discover"> Discover </label>
    
                <input type = "radio" name = "payment method" id = "paypal" value = "PayPal" required>
                <label for = "paypal"> PayPal </label>
    
            </div>  
    
            
            <div class = "info-layout">
                <label for = "cardnum"> Credit Card Number </label>
                <input type = "text" name = "cardnum" id = "cardnum" required>
                
                <label for = "cvv"> CVV </label>
                <input type = "text" name = "cvv" id = "cvv" required>
    
            </div>
            
            <div class = "info-layout"> 
                <label for = "exp"> Expiration </label>
                <input type = "month" name = "exp" id = "exp" required>
            </div>
         
            <button type = "submit" id = "order"> Place Order </button>
        
        
        </form>
        
    </div>
    </div>    
</body>
</html>
