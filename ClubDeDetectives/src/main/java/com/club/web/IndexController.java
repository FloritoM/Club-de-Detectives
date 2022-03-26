package com.club.web;

import com.club.data.iUserDAO;
import com.club.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class IndexController {
    
    @Autowired
    private iUserDAO userDAO;
    
    @RequestMapping("/register")
    public String registro(@RequestParam(value = "nombre", required=true) String nombre,
            @RequestParam(value = "apellido", required=true) String apellido,
            @RequestParam(value = "mail", required=true) String mail,
            @RequestParam(value = "pais", required=true) String pais,
            @RequestParam(value = "password", required=true) String password, Model model){
        User newUser = new User(mail, nombre, apellido, password, pais);
        // aca primero podria evaluar si el mail existe y return "error" por el momento
        if(!userDAO.existsById(mail)){
            userDAO.save(newUser);
            return "register";
        } else {
            return "error";
        }
    }
    
    @GetMapping("/login")
    public String ingresar(){
        return "login";
    }
    
    
    
}
