const navPfp = document.getElementById("navPfp");
const navToggle = document.getElementById("pf");

navToggle.addEventListener("click", function(){
    if (navPfp.style.display == "none" || navPfp.style.display === "") {
        navPfp.style.display = "block";
    } else {
        navPfp.style.display = "none";
    }
});