package com.lautaro.curso.springboot.webapp.springboot_web.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.lautaro.curso.springboot.webapp.springboot_web.controllers.models.User;



@Controller
public class UserController {

    //localhost:8080/user/details
    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Lautaro","VH");
        user.setEmail("Spring@correo.com");
        
        model.addAttribute("title", "Hola SpringBoot");
        model.addAttribute("user",user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("title", "Listado de usuarios");
        return "list";
        
    }

    @ModelAttribute("users")
    public List<User> usersModel(){
          List<User> users = Arrays.asList(
            new User("Lautaro","VH"),
            new User("Maria","Gomez"),
            new User("Juan","Perez","juan.perez@example.com")
        );
        return users;
    }

}
    