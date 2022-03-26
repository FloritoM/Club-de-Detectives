// elemento formulario
const form = document.getElementById("register_form");

form.addEventListener('submit', (e) => {
    let password = form["password"].value; // probar comentando estos dos valores
    let password_repeat = form["password_repeat"].value;
    if (password !== password_repeat) {
        document.getElementById("password_validation").innerHTML = "Las contraseñas NO coinciden";
        e.preventDefault();
    }

    if (password.length < 6 && password_repeat.length < 6) {
        document.getElementById("password_validation").innerHTML = "La contraseña debe tener mas de 5 caracteres";
        e.preventDefault();
    }

    if (password === "" || password_repeat === "") {
        document.getElementById("password_validation").innerHTML = "Completar el campo";
        e.preventDefault();
    }
});

// elemento icono
const showPassword = document.getElementById('show_password');
//CAMBIE ABAJO
//const showPasswordRepeat = document.getElementById('show_passwordRepeat');
// elemento input
const passwordInput = document.getElementById('password');
const passwordInputRepeat = document.getElementById('password_repeat');
// valores del input
const password = form["password"].value;
const password_repeat = form["password_repeat"].value;

/* showPassword.addEventListener('click', () => {
 if(passwordInput.type === "password"){
 passwordInput.type = "text";
 } else {
 passwordInput.type = "password";
 }
 }); 
 */

[showPassword].forEach(element => {
    element.addEventListener('click', () => {
        if (passwordInput.type === "password") {
            passwordInput.type = "text";
        } else {
            passwordInput.type = "password";
        }

        if (passwordInputRepeat.type === "password") {
            passwordInputRepeat.type = "text";
        } else {
            passwordInputRepeat.type = "password";
        }
    });
});


