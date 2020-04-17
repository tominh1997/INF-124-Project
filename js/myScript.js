var curSlide = 1;
// Next/previous controls
function plusSlides(n) {
  curSlide += n;
  showSlide(curSlide);
}

function showSlide(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {n = 1;}
  if (n < 1) {n = slides.length;}
  for (i = 0; i < slides.length; i++) {
      if (i == n-1){
        slides[i].style.display = "block";
        dots[i].className += " active";
      } else{
        slides[i].style.display = "none";
        dots[i].className = dots[i].className.replace(" active", "");
      }
  }
  curSlide = n;
}