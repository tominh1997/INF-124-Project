function handleResult(resultData) {

    console.log("handleResult: populating table from resultData");

    // Populate the star table
    // Find the empty table body by id "movie_table_body"
    let tableBodyElement = jQuery("#table_body");
    if(resultData["items-history"].length === 0)
    {
        return
    }
    // Concatenate the html tags with resultData jsonObject to create table rows
    let rowHTML = "";
    rowHTML += "<tr>";
    for (let i = 0; i < Math.min(5, resultData["items-history"].length); i++) {
        rowHTML += "<th>" + resultData["items-history"][i]["name"] + "</th>";

    }
    rowHTML += "</tr>";


    tableBodyElement.append(rowHTML);
}

// Makes the HTTP GET request and registers on success callback function handleResult
jQuery.ajax({
    dataType: "json",  // Setting return data type
    method: "GET",// Setting request method
    url: "api/recent-visit",
    success: (resultData) => handleResult(resultData) // Setting callback function to handle data returned successfully by the SingleStarServlet
});