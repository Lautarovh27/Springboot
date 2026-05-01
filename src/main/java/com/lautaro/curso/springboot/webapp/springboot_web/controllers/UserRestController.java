package com.lautaro.curso.springboot.webapp.springboot_web.controllers;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lautaro.curso.springboot.webapp.springboot_web.controllers.models.User;
import com.lautaro.curso.springboot.webapp.springboot_web.controllers.models.dto.UserDto;


@RestController
@RequestMapping("/api")
public class UserRestController {
    
    @GetMapping("/details")
    public UserDto etails() {
       UserDto userDto = new UserDto();
       User user = new User("Lautaro","VH");
       userDto.setUser(user);
       userDto.setTitle("Hola SpringBoot");

      
        return userDto;
    }
    
    @GetMapping("/list")
    public List<User> list() {
        User user1 = new User("Lautaro","VanH");
        User user2 = new User("Lau","VH");
        User user3 = new User("Lautt","VHoo");
        
        List<User> users = Arrays.asList(user1,user2,user3);
        /*
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
         */
        return users;
    }


    @GetMapping("/details-map")
    public Map<String, Object> details() {
        User user = new User("Lautaro","VH");
        Map<String, Object> body = new HashMap<>();
        
        body.put("title", "Hola SpringBoot");
        body.put("user", user);
        return body;
    }

} 
