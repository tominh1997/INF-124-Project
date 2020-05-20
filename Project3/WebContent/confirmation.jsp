<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/navbar.css">
<link rel="stylesheet" type="text/css" href="css/about-us.css">
<meta charset="UTF-8">
</head>
<body>
    <div class="navbar">
        <a href="homepage.html"> 
            <img src="images/logo/logo.png" alt="logo" style="width: 100px; height: 100px;">
        </a>
        <div class="subnav-left">
          <a href="homepage.html">Home</a>
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
        <div class="subnav-right-right">
          <a href="checkout"><i class="fa fa-shopping-cart fa-7x"></i></a>
        </div> 
      </div>

      
    <div id="confirm">

      <div class="container">
        <div class="section" >
          <h1 class="sectionTitle"> Confirmation </h1>
        </div>
      </div>
      <table style="width:100%; padding-left: 20%;" >
          <tr>
              <th>
                  <h3>Name</h3>
              </th>
              <th>
                  <h3>Description</h3>
              </th>
              <th>
                  <h3>Quantity</h3>
              </th>
              <th>
                  <h3>Price</h3>
              </th>
          </tr>
          <c:forEach items="${cart_items}" var="item">
              <tr>
                  <td>
                      <h3> ${item.value.name} </h3>
                  </td>
                  <td>
                      <img style="width: 150px; height: 150px" src="data:image/jpg;base64,${item.value.image1}"/>
                  </td>
                  <td>
                      <h3> ${item.value.quantity} </h3>
                  </td>
                  <td>
                      <h3> $${item.value.price} </h3>
                  </td>
              </tr>
          </c:forEach>
          <tr>
              <td>
                  <div id="title">Order Number</div>
              </td>
              <td>
                  <div id="order_number">${order_number}</div>
              </td>
          </tr>
          <tr>
              <td>
                  <div id="title">Name</div>
              </td>
              <td>
                  <div id="name">${name}</div>
              </td>
          </tr>
        <tr>
          <td>
            <div id="title">Item Subtotal</div>
          </td>
          <td>
            <div id="item_subtotal">${item_subtotal}</div>
          </td>
        </tr>
        <tr>
          <td>
            <div id="title">Shipping</div>
          </td>
          <td>
            <div id="shipping">${shipping}</div>
          </td>
        </tr>
        <tr>
          <td>
            <div id="title">Total Before Tax</div>
          </td>
          <td>
            <div id="total_before_tax">${total_before_tax}</div>
          </td>
        </tr>
        <tr>
          <td>
            <div id="title">Tax</div>
          </td>
          <td>
            <div id="tax">${tax}</div>
          </td>
        </tr>
        <tr>
          <td>
            <div id="title">Grand Total</div>
          </td>
          <td>
            <div id="grand_total">${grand_total}</div>
          </td>
        </tr>
      </table>

    <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
    <script type = "text/JavaScript" src="confirmation.js"></script>

    </div>    
</body>
</html>
