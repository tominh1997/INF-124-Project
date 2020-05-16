function getQueryVariable(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
      var pair = vars[i].split("=");
      if (pair[0] == variable) {
        return pair[1];
      }
    } 
    //alert('Query Variable ' + variable + ' not found');
  }

var order_number = getQueryVariable('order_number');
var name = getQueryVariable('name');
var product = getQueryVariable('product');
var quantity = getQueryVariable('quantity');
var item_subtotal = getQueryVariable('item_subtotal');
var shipping = getQueryVariable('shipping');
var total_before_tax = getQueryVariable('total_before_tax');
var tax = getQueryVariable('tax');
var grand_total = getQueryVariable('grand_total');


$("#order_number").text(order_number);
$("#name").text(name.replace(/%20/g, " "));
$("#product").text(product.replace(/%20/g, " "));
$("#quantity").text(quantity);
$("#item_subtotal").text("$" + item_subtotal);
$("#shipping").text("$" + shipping);
$("#total_before_tax").text("$" + total_before_tax);
$("#tax").text(tax + "%");
$("#grand_total").text("$" + grand_total);

