<?php
    $servername = "localhost:3306";
    $username = "root";
    $password = "";
    $dbname = "chocoholic_db";

    try {
        $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
        $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $query = 'SELECT * FROM chocoholic_db.products WHERE type = ? and name = ?';
        if (!isset($_GET['type'])){
            $type ="white";
            $name ="Hebert";
        } else {
            $type = $_GET["type"];
            $name = $_GET["product"];
        }
        $stmt = $conn->prepare($query);
        echo $name;
        $stmt->execute([$type, $name]);
        //fetch all in array format: array ( 0 => array (""))
        /*
        array (
          0 => array('John'),
          1 => array('Mike'),
          2 => array('Mary'),
          3 => array('Kathy'),
        )*/
        $result = $stmt->fetch(PDO::FETCH_ASSOC);
    }
    catch(PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
    $conn = null;
?>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/navbar.css">
<link rel="stylesheet" type="text/css" href="css/description.css">
    
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>  
<script defer src = "js/orderCheck.js"></script>
<script type = "text/JavaScript" src = "js/auto_fill_zip_code.js"></script>
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
</div>

    
<div class = "header">
    <h1> <?php echo $result["name"] ?> </h1> 
</div>
    
<div class="description">
    
    <center> 
    <?php echo '<img src="data:image/jpg;base64,'.base64_encode( $result['image1'] ).'"/>'; ?> 
    <?php echo '<img src="data:image/jpg;base64,'.base64_encode( $result['image2'] ).'"/>'; ?> 
    <?php echo '<img src="data:image/jpg;base64,'.base64_encode( $result['image3'] ).'"/>'; ?> 
    </center>
    
    <p>
        <strong> <?php echo "$" . $result['price'] ?>   </strong> <br> 
        <?php echo $result["description"] ?>  
        
    </p>   
</div>   
<hr>
    
    
<div class = "form"> 
    <h1> Order Information </h1>
    <hr> 
    <div id = "error"> </div>
    <form action = "php/order_form.php" method = "POST" id = "form" class = "form-layout">
      
        <h2> Product </h2>
        <div class = "info-layout"> 
            
            <label for = "product"> Chocolate </label>
            <input readonly type = "text" name = "product" id = "product">
            <script type = "text/JavaScript" src="js/form.js"></script>
            
            <label for = "quantity"> Quantity </label>
            <input type = "number" name = "quantity" id = "quantity"  min = "1" step = "1" required>
        
        </div>  
        
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
            <input type = "text" name = "zipCode" id = "zip" required onblur = "getPlace (this.value)" autocomplete="on">

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

</body>
</html>
