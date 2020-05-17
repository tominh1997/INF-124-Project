function getParameterByName(target) {
    // Get request URL
    let url = window.location.href;
    // Encode target parameter name to url encoding
    target = target.replace(/[\[\]]/g, "\\$&");

    // Ues regular expression to find matched parameter value
    let regex = new RegExp("[?&]" + target + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';

    // Return the decoded parameter value
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}



let productId = getParameterByName('id');
let productName = getParameterByName('name');
let productPrice = getParameterByName('price');

function addCart(){

    jQuery.ajax({
        dataType: "json",  // Setting return data type
        method: "GET",// Setting request method
        url: "api/add-cart?id=" + productId + "&name=" + productName + "&price=" + productPrice, // Setting request url, which is mapped by StarsServlet in Stars.java
        success: (resultData) => alert("Added " + productName) // Setting callback function to handle data returned successfully by the SingleStarServlet
    });
}
