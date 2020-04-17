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
    
    if(!isNaN(productVal)){
        alert("Please Enter a String not an Integer for Product Value"); 
        return true; 
    }
    
    if(!isNaN(firstNameVal)){
        alert("Please Enter a String not an Integer for First Name"); 
        return true; 
    }
    
    if(!isNaN(lastNameVal)){
        alert("Please Enter a String not an Integer for Last Name"); 
        return true; 
    }
    
    if (phoneVal.length > 10 || phoneVal.length < 10 || isNaN(phoneVal) ) { 
        alert("Please Enter a Valid Phone Number"); 
        return true; 
    }
    
    if(!isNaN(cityVal)){
        alert("Please Enter a String not an Integer for City"); 
        return true; 
    }
    
    if(!isNaN(stateVal) ){
        alert("Please Enter a String not an Integer for State"); 
        return true; 
    }
    
    if(!isNaN(countryVal)){
        alert("Please Enter a String not an Integer for Country"); 
        return true; 
    }
    
    if (zipVal.length > 5 || zipVal.length < 5 || isNaN(zipVal)) { 
        alert("Please Enter a Valid Zip Code"); 
        return true; 
    }
    
    if (cardNumVal.length > 16 || cardNumVal.length < 16 || isNaN(cardNumVal)) { 
        alert("Please Enter a Valid Credit Card Number"); 
        return true; 
    }
    
    if (cvvVal.length > 3 || cvvVal.length < 3 || isNaN(cvvVal)) { 
        alert("Please Enter a Valid CVV"); 
        return true; 
    }

}
