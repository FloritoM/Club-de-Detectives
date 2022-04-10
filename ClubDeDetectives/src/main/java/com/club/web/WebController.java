package com.club.web;

import com.club.domain.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {
    
    private static List<String> countries;
    static{
        countries = new ArrayList<>();
        countries.add("argentina");
        countries.add("chile");
        countries.add("paraguay");
        countries.add("uruguay");
    }
    
    
    @GetMapping("/registration") // cuando se tipea el path en el url
    public String registerForm(Model model) {
        model.addAttribute("countries", countries);
        model.addAttribute("user", new User()); 
        return "registration";
    }
    
    @PostMapping("/registration")
    public String registerSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        return "display";
    }
    
    @GetMapping("/login")
    public String ingresar(){
        return "login";
    }
}
