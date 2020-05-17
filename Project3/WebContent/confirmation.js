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

function handleResult(resultData) {
    let tableBodyElement = jQuery("#table_body");

    for (let i = 0; i < resultData["items"].length ; i++) {
        let rowHTML = "          <tr>\n" +
            "            <td>\n" +
            "              <div id=\"title\">Product</div>\n" +
            "            </td>\n" +
            "            <td>";

        rowHTML += "<div id=\"product\">" + resultData["items"][i]["name"] + "</div></td></tr>";

        rowHTML += "          <tr>\n" +
            "            <td>\n" +
            "              <div id=\"title\">Quantity</div>\n" +
            "            </td>\n" +
            "            <td>"
        rowHTML += "<div id=\"product\">" + resultData["items"][i]["quantity"] + "</div></td></tr>";
        // Append the row created to the table body, which will refresh the page
        movieTableBodyElement.append(rowHTML);
    }

    jQuery("#order_number").text();
    jQuery("#name").text();
    jQuery("#item_subtotal").text();
    jQuery("#shipping").text();
    jQuery("#total_before_tax").text();
    jQuery("#tax").text();
    jQuery("#grand_total").text();
}

jQuery.ajax({
    dataType: "json",  // Setting return data type
    method: "GET",// Setting request method
    url: "api/confirmation", // Setting request url, which is mapped by StarsServlet in Stars.java
    success: (resultData) => handleResult(resultData) // Setting callback function to handle data returned successfully by the SingleStarServlet
});

