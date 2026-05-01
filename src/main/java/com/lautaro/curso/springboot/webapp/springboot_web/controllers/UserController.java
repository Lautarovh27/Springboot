package com.lautaro.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.lautaro.curso.springboot.webapp.springboot_web.controllers.models.User;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UserController {

    //localhost:8080/user/details
    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Lautaro","VH");
        
        model.addAttribute("title", "Hola SpringBoot");
        model.addAttribute("user",user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        List<User> users = new ArrayList<>();

        model.addAttribute("users", users);
        model.addAttribute("title", "Listado de usuarios");
        return "list";
        
    }
    

}
