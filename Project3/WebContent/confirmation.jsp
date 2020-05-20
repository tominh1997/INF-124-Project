<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/navbar.css">
<link rel="stylesheet" type="text/css" href="css/about-us.css">
    <link rel="stylesheet" type="text/css" href="css/confirmation.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
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
        <a href="checkout"><i style="font-size: 2em;" class="fa fa-shopping-cart fa-7x"></i></a>
    </div>
</div>

      <div class="container">
        <div class="section" >
          <h1 class="sectionTitle"> Order Confirmation </h1>
        </div>
      <table>
          <tr>
              <th>
                  <h3>Product's Name</h3>
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
      </table>
          <hr>
          <div class="section" >
              <h1 class="sectionTitle"> Payment Summary </h1>
          </div>
        <table>
          <tr>
              <td>
                  <h3>Order Number</h3>
              </td>
              <td>
                  <h3>${order_number}</h3>
              </td>
          </tr>
          <tr>
              <td>
                  <h3>Buyer's Name</h3>
              </td>
              <td>
                  <h3>${name}</h3>
              </td>
          </tr>
        <tr>
          <td>
            <h3>Items' Subtotal</h3>
          </td>
          <td>
            <h3>$${item_subtotal}</h3>
          </td>
        </tr>
        <tr>
          <td>
            <h3>Shipping's Cost</h3>
          </td>
          <td>
            <h3>$${shipping}</h3>
          </td>
        </tr>
        <tr>
          <td>
            <h3>Total Before Tax</h3>
          </td>
          <td>
            <h3>$${total_before_tax}</h3>
          </td>
        </tr>
        <tr>
          <td>
            <h3>Tax</h3>
          </td>
          <td>
            <h3>${tax}%</h3>
          </td>
        </tr>
        <tr>
          <td>
            <h3>Grand Total</h3>
          </td>
          <td>
            <h3>$${grand_total}</h3>
          </td>
        </tr>
        </table>
    </div>
</body>
</html>
