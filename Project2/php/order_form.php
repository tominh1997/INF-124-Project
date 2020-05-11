<?php
$pdo=new PDO('mysql:host=localhost:3306;dbname=chocoholic_db','root', '');
$sqlCheck = "SELECT * FROM zip_codes WHERE zip_codes.city = :city AND zip_codes.state = :state AND zip_codes.zip = :zip ; ";
$stmtCheck = $pdo->prepare($sqlCheck);
$stmtCheck->execute(array(':city' => $_POST["city"],
                ':state' => $_POST["state"],
                ':zip' => $_POST["zipCode"]));
$resultCheck = $stmtCheck->fetch(PDO::FETCH_ASSOC);     
if(empty($resultCheck)){
    echo "Wrong information";
    exit(0);
}

$sql ="INSERT INTO orders VALUES(NULL, :buyer_name, :phone_number,
                 :product_id, :product_name, :quantity, :total_amount,
                 :address, :shipping_method, :credit_card_number, :CVV 
                 ) ";
$stmt = $pdo->prepare($sql);
$total_amount = ($_POST["tax"]* ($_POST["product_price"]*$_POST["quantity"] + $_POST["shipping_method"]) ) + 
($_POST["product_price"]*$_POST["quantity"] + $_POST["shipping_method"]);
$stmt->execute(array(':buyer_name' => $_POST["name"], 
                     ':phone_number' => $_POST["phone"],
                     ':product_id' => 9,
                     ':product_name' => $_POST["product"],
                     ':quantity' => $_POST["quantity"],
                     ':total_amount' => $total_amount,
                     ':address' => $_POST["adrress"],
                     ':shipping_method' => $_POST["shipping_method"],
                     ':credit_card_number' => $_POST["cardnum"],
                     ':CVV' => $_POST["cvv"],
                    ));          
//print_r($_POST);  
//$address = $_POST["adrress"]." ".$_POST["city"]." ".$_POST["state"]." ".$_POST["country"];
$item_subtotal = $_POST["product_price"]*$_POST["quantity"];
$total_before_tax = ($_POST["product_price"]*$_POST["quantity"] + $_POST["shipping_method"]);
$order_number = $pdo->lastInsertId();  
header("Location: http://".$_SERVER['HTTP_HOST']
."/confirmation.html?"
."order_number=".$order_number
."&name=".$_POST["name"]
."&product=".$_POST["product"]
."&quantity=".$_POST["quantity"]
."&item_subtotal=".$item_subtotal
."&shipping=".$_POST["shipping_method"]
."&total_before_tax=".$total_before_tax
."&tax=".$_POST["tax"]
."&grand_total=".$total_amount
);
exit(0); 
?>