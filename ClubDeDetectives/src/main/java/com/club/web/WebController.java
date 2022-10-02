package com.club.web;

import com.club.data.iUserDAO;
import com.club.domain.User;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class WebController {
    
    @Autowired
    private iUserDAO userDAO;
    
    @GetMapping("/register") // signup
    public String register(User user){ // PEROOOOOO
        return "signup"; // cambiar nombre de la pagina -> sign up
    }
    
    @PostMapping("/register")
    public String registro(@RequestParam(value = "nombre", required=true) String nombre,
            @RequestParam(value = "apellido", required=true) String apellido,
            @RequestParam(value = "mail", required=true) String mail,
            @RequestParam(value = "pais", required=true) String pais,
            @RequestParam(value = "password", required=true) String password, Model model){ // probar sin/con model
        User newUser = new User(mail, nombre, apellido, password, pais);
        
        if(userDAO.existsById(mail)){
            String errorMessage = "El mail ya existe en la base de datos";
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("mail", mail);
            return "http://localhost:8080/index";
        } else {
            userDAO.save(newUser);
            return "success";  // cambiar nombre de la pagina
        }
        
//        if(!userDAO.existsById(mail)){
//            
//        } else {
//            String errorMessage = "Mail ya existe en la base de datos";
//            model.addAttribute("errorMessage", errorMessage);
//            return "index";
//        }
    }
    
//    private static List<String> countries;
//    static{ 
//        countries = new ArrayList<>();
//        countries.add("argentina");
//        countries.add("chile");
//        countries.add("paraguay");
//        countries.add("uruguay");
//    }
//    
//    @GetMapping("/register") // cuando se tipea el path en el url
//    public String registerForm(Model model) {
//        model.addAttribute("countries", countries);
//        model.addAttribute("user", new User()); 
//        return "registration";
//    }
//    
//    @PostMapping("/register")
//    public String registerSubmit(@ModelAttribute User user, Model model) {
//        if(userDAO.existsById(user.getMail())){
//            //throw new IllegalStateException("ERROR CON EL MAIL");
//            String errorMSG = "Mail ya registrado";
//            model.addAttribute("countries", countries); // compartir otra vez
//            model.addAttribute("errorMSG", errorMSG);
//            return "registration";
//        } else {
//            userDAO.save(user);
//            return "display"; 
//        }
//    }
//    
//    @GetMapping("/login")
//    public String ingresar(){
//        return "login";
//    }
}
