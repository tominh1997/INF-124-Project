<?php
    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "chocoholic_db";

    try {
        $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
        $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $query = 'SELECT * FROM chocoholic_db.products WHERE type = ?';
        $type = $_GET['type'];
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
?>

<!DOCTYPE html>
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
  <a href="#home"> 
      <img src="images/logo/logo.png" alt="logo" style="width: 100px; height: 100px;">
  </a>
  
  <div class="subnav">
    <a href="about-us.html">About Us</a>
  </div> 
  <div class="subnav-left">
    <a href="homepage.html">Home</a>
  </div> 
  <div class="subnav-right">
    <button class="subnavbtn">Products <i class="fa fa-caret-down"></i></button>
    <div class="subnav-content">
      <a href="products.php?type=white"> White Chocolate</a>
      <a href="products.php?type=dark">Dark Chocolate</a>
      <a href="milk-chocolate.php?type=milk">Milk Chocolate</a>
    </div>
  </div>
</div>

<div class="best-seller">
    <span class="header">Best Seller</span>
    <div class="row">
        <?php for ($i = 0; $i <= 2; $i++){ ?>
        <a href="<?php echo "productDescription.php?product=" . $result[$i]['name'] ?>">
            <?php echo '<img src="data:image/jpg;base64,'.base64_encode( $result[$i]['image1'] ).'"/>'; ?>
        </a>
        <?php } ?>
    </div>
</div>

<hr>
<div class="header">
<span ><?php echo $_GET["type"]. "Chocolate Products" ?></span>
</div>

<table style="width:100%; padding-left: 30px;">
    <?php 
    $size = count($result);
    $rows = 2;
    $columns = $size / $rows;
    for ($r = 0; $r < $rows; $r++) { ?>
    <tr class="product-list">
        <?php for ($c = 0; $c < $columns; $c++) { 
        $cur = $result[$c + $columns * $r] ?>
        <td >
            <div class = "product-cell">
                <a href="productDescription.php">
                    <?php echo '<img href="productDescription.php" src="data:image/jpg;base64,'.base64_encode($cur['image1'] ).'"/>'; ?> 
                    <span>
                    <?php echo $cur['name'] ?>
                    </span>
                </a>
                <span>
                  <?php echo "$" . $cur['price'] ?>  
                </span>
            </div>
        </td>
        <?php } ?>
    </tr>
    <?php } ?>
</table>

</body>
</html>