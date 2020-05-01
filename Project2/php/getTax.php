<?php
// getCityState.php
//  Gets the form value from the "zip" widget, looks up the
//  city and state for that zip code, and prints it for the
//  form
$pdo=new PDO('mysql:host=localhost:3306;dbname=chocoholic_db','root', '');
$sql ="SELECT CombinedRate FROM tax_rates WHERE ZipCode = :zip AND State = :state AND TaxRegionName = :tax_region_name";
$stmt = $pdo->prepare($sql);
$stmt->execute(array(':zip' => $_GET["zip"],
                    ':state' => $_GET["state"],
                    ':tax_region_name' =>$_GET['tax_region_name']
                    ));

$row = $stmt->fetch(PDO::FETCH_ASSOC);

if (isset($row))
  print_r($row["CombinedRate"]);
else
  print " , ";

?>
