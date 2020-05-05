function getPlace (zip)
{
  if (window.XMLHttpRequest)
  {  // IE7+, Firefox, Chrome, Opera, Safari
     var xhr = new XMLHttpRequest();
  }
  else
  {  // IE5, IE6
     var xhr = new ActiveXObject ("Microsoft.XMLHTTP");
  }

  // Register the embedded handler function
  // This function will be called when the server returns
  // (the "callback" function)
  xhr.onreadystatechange = function ()
  { // 4 means finished, and 200 means okay.
    if (xhr.readyState == 4 && xhr.status == 200)
    { // Data should look like "Fairfax, Virginia"
      var result = xhr.responseText;
      var place = result.split (', ');
      if (document.getElementById ("city").value == "")
        document.getElementById ("city").value = place[0];
      if (document.getElementById ("state").value == "")
        document.getElementById ("state").value = place[1];
      if (document.getElementById ("country").value == "")
        document.getElementById ("country").value = place[2];
      getTax (zip);  
    }
  }
  // Call the response software component
  xhr.open ("GET", "php/getCityState.php?zip=" + zip);
  xhr.send (null);
}


function getTax (zip)
{
  if (window.XMLHttpRequest)
  {  // IE7+, Firefox, Chrome, Opera, Safari
     var xhr = new XMLHttpRequest();
  }
  else
  {  // IE5, IE6
     var xhr = new ActiveXObject ("Microsoft.XMLHTTP");
  }

  // Register the embedded handler function
  // This function will be called when the server returns
  // (the "callback" function)
  xhr.onreadystatechange = function ()
  { // 4 means finished, and 200 means okay.
    if (xhr.readyState == 4 && xhr.status == 200)
    { // Data should look like "Fairfax, Virginia"
      var result = xhr.responseText;
      var place = result.split (', ');
      if (document.getElementById ("tax").value == "")
        document.getElementById ("tax").value = place;
    }
  }
  // Call the response software component
  xhr.open ("GET", "php/getTax.php?zip=" + zip);
  xhr.send (null);
}