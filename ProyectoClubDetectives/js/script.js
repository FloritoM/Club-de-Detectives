const form = document.getElementById("register_form");

form.addEventListener('submit', (e) => {
    let password = form["password"].value;
    let password_repeat = form["password_repeat"].value;
    if(password !== password_repeat){
        document.getElementById("password_validation").innerHTML = "Las contraseñas NO coinciden";
        e.preventDefault();
    }

    if(password.length < 6 && password_repeat.length < 6){
        document.getElementById("password_validation").innerHTML = "La contraseña debe tener mas de 5 caracteres";
        e.preventDefault();
    }

    if(password === "" || password_repeat === ""){
        document.getElementById("password_validation").innerHTML = "Completar el campo";
        e.preventDefault();
    }
});