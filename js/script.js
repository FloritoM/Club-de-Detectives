function passwordValidation(){
    const form = document.getElementById("register_form");
    let password = form["password"].value;
    let password_repeat = form["password_repeat"].value;
    
    if(password !== password_repeat){
        document.getElementById("password_validation").innerHTML = "Las contraseñas NO coinciden";
    } 
    
}