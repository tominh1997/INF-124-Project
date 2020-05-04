<?php
    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "chocoholic_db";

    try {
        $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
        $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $query = 'SELECT * FROM chocoholic_db.products WHERE type = ?';
        $type = "dark";
        $stmt = $conn->prepare($query);
        $stmt->execute([$type]);
        //fetch all in array format: array ( 0 => array (""))
        /*
        array (
          0 => array('John'),
          1 => array('Mike'),
          2 => array('Mary'),
          3 => array('Kathy'),
        )*/
        $result = $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
    catch(PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
    $conn = null;
    echo $_GET["product"];
?>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/navbar.css">
<link rel="stylesheet" type="text/css" href="css/description.css">
    
<script defer src = "js/orderCheck.js"></script>
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
        <a href="white-chocolate.php">White Chocolate</a>
        <a href="dark-chocolate.php">Dark Chocolate</a>
        <a href="milk-chocolate.php">Milk Chocolate</a>
    </div>
  </div>
</div>

    
<div class = "header">
    <h1> Insert Chocolate Name</h1>   
</div>
    
<div class="description">
    
    <center> 
    <img src="MCImg/mc1.jpg"> 
    <img src="MCImg/mc1.jpg"> 
    <img src="MCImg/mc1.jpg"> 
    </center>
    
    <p>
        <strong> $Price </strong> <br> 
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
        
    </p>   
</div>   
<hr>
    
    
<div class = "form"> 
    <h1> Order Information </h1>
    <hr> 
    <div id = "error"> </div>
    <form action = "mailto:inf124@uci.edu" method = "post" enctype="text/plain" id = "form" class = "form-layout">
      
        <h2> Product </h2>
        <div class = "info-layout"> 
            
            <label for = "product"> Chocolate Type </label>
            <input type = "text" name = "product" id = "product"  min = "1" step = "1"  placeholder= "Chocolate Name" required>
            
            <label for = "quantity"> Quantity </label>
            <input type = "number" name = "quantity" id = "quantity"  min = "1" step = "1" required>
        
        </div>  
        <hr> 
        <h2> User Information </h2>
       
        <div class = "info-layout"> 
            <label for = "firstName"> First Name </label>
            <input type = "text" name = "firstName" id = "firstName" placeholder="First Name" required>

            <label for = "lastName"> Last Name </label>
            <input type = "text" name = "lastName" id = "lastName" placeholder="Last Name" required>
       
            <label for = "phone"> Phone Number </label>
            <input type = "tel" name = "phone" id = "phone" placeholder="##########" required>
       
        </div>
        <hr>
        <h2> Shipping Address </h2>  
        <div class = "info-layout"> 
            <label for = "address"> Address </label>
            <input type = "text" name = "address" id = "address" placeholder = "Street Address" required>

        
            <label for = "city"> City </label>
            <input type = "text" name = "city" id = "city" placeholder= "City" required >

       
            <label for = "state"> State </label>
            <input type = "text" name = "state" id = "state" placeholder= "State" required>

        
            <label for = "country"> Country </label>
            <input type = "text" name = "country" id = "country" placeholder= "Country" required>
      
            <label for = "zipCode"> Zip Code </label>
            <input type = "text" name = "zipCode" id = "zip" required>

        </div>
            
        
        <h3> Shipping Method </h3>
        <div class = "radio-layout"> 
            <input type = "radio" name = "shipping method" id = "one-day" value = "one-day" required>
            <label for = "one-day"> One-Day Shipping  </label>
            
            <input type = "radio" name = "shipping method" id = "two-day" value = "two-day" required>
            <label for = "two-day"> Two-Day Shipping  </label>
            
            <input type = "radio" name = "shipping method" id = "standard" value = "standard" required>
            <label for = "standard"> Standard (4 - 5 business days) </label>
            
        </div>
        <hr>
        <h2> Credit Card </h2>  
    
        <h3> Payment Method </h3>
        <div class = "radio-layout"> 
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
            <label for = "exp"> Expiration Date </label>
            <input type = "month" name = "exp" id = "exp"  required>
        </div>
     
        <button type = "submit" id = "order"> Place Order </button>
    
    
    </form>
    
</div>

</body>
</html>
