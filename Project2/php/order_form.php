<?php
$pdo=new PDO('mysql:host=localhost:3306;dbname=chocoholic_db','root', '');
$sql ="INSERT INTO orders VALUES(NULL, :buyer_name, :phone_number,
                 :product_id, :product_name, :quantity, :total_amount,
                 :address, :shipping_method, :credit_card_number, :CVV 
                 ) ";
$stmt = $pdo->prepare($sql);
$total_amount = 99*$_POST["quantity"];
$stmt->execute(array(':buyer_name' => $_POST["firstName"], 
                     ':phone_number' => $_POST["phone"],
                     ':product_id' => 1,
                     ':product_name' => $_POST["product"],
                     ':quantity' => $_POST["quantity"],
                     ':total_amount' => $total_amount,
                     ':address' => $_POST["adrress"],
                     ':shipping_method' => $_POST["shipping_method"],
                     ':credit_card_number' => $_POST["cardnum"],
                     ':CVV' => $_POST["cvv"],
                    ));          
print_r($_POST);         
//header("Location: http://".$_SERVER['HTTP_HOST']."/confirmation.html?buyer_name=".$_POST["firstName"]."&total_amount=".$total_amount);
//exit(0); 
?>