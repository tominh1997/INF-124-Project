let order_form = $("#form");

function submitForm(formSubmitEvent) {
    console.log("submit form");
    /**
     * When users click the submit button, the browser will not direct
     * users to the url defined in HTML form. Instead, it will call this
     * event handler when the event is triggered.
     */
    formSubmitEvent.preventDefault();

    $.ajax(
        "php/order_form.php", {
            method: "POST",
            // Serialize the login form to the data sent by POST request
            data: order_form.serialize(),
            success: handleResult
        }
    );
}
//order_form.submit(submitForm);