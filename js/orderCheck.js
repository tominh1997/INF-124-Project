const product = document.getElementById('product'); 
const firstName = document.getElementById('firstName'); 
const lastName = document.getElementById('lastName'); 
const phone = document.getElementById('phone'); 
const address = document.getElementById('address'); 
const city = document.getElementById('city'); 
const state = document.getElementById('state'); 
const country = document.getElementById('country'); 
const zip = document.getElementById('zip'); 
const cardNum = document.getElementById('cardnum'); 
const cvv = document.getElementById('cvv'); 
const exp = document.getElementById('exp'); 

const form = document.getElementById('form'); 
form.addEventListener('submit', (e) => {
     
    if (checkValidInputs()){ 
        e.preventDefault(); 
    }  
   
})

function checkValidInputs(){ 
    const productVal = product.value.trim()  
    const firstNameVal = firstName.value.trim() 
    const lastNameVal = lastName.value.trim() 
    const phoneVal = phone.value.trim() 
    const cityVal = city.value.trim() 
    const stateVal = state.value.trim() 
    const countryVal =country.value.trim() 
    const zipVal = zip.value.trim() 
    const cardNumVal =cardNum.value.trim() 
    const cvvVal = cvv.value.trim() 
    const expVal = exp.value 
    
    let errorMsgs = []; 
    
    if(!isNaN(productVal)){
        errorMsgs.push("Please Enter a String not an Integer for Product Value"); 
    }
    
    if(!isNaN(firstNameVal)){
        errorMsgs.push("Please Enter a String not an Integer for First Name"); 
    }
    
    if(!isNaN(lastNameVal)){
        errorMsgs.push("Please Enter a String not an Integer for Last Name"); 
    }
    
    if (phoneVal.length > 10 || phoneVal.length < 10 || isNaN(phoneVal) ) { 
        errorMsgs.push("Please Enter a Valid Phone Number");  
    }
    
    if(!isNaN(cityVal)){
        errorMsgs.push("Please Enter a String not an Integer for City"); 
    }
    
    if(!isNaN(stateVal) ){
        errorMsgs.push("Please Enter a String not an Integer for State"); 
    }
    
    if(!isNaN(countryVal)){
        errorMsgs.push("Please Enter a String not an Integer for Country"); 
    }
    
    if (zipVal.length > 5 || zipVal.length < 5 || isNaN(zipVal)) {
        errorMsgs.push("Please Enter a Valid Zip Code"); 

    }
    
    if (cardNumVal.length > 16 || cardNumVal.length < 16 || isNaN(cardNumVal)) { 
        errorMsgs.push("Please Enter a Valid Credit Card Number"); 

    }
    
    if (cvvVal.length > 3 || cvvVal.length < 3 || isNaN(cvvVal)) { 
        errorMsgs.push("Please Enter a Valid CVV");  
    }
    
    if(errorMsgs.length > 0){ 
        alert(errorMsgs.join(", ")); 
        return true; 
    }

}
