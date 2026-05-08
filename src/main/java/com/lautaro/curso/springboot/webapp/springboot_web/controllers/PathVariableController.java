package com.lautaro.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lautaro.curso.springboot.webapp.springboot_web.controllers.models.User;
import com.lautaro.curso.springboot.webapp.springboot_web.controllers.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;






@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    //@Value("${config.message}")
    //private String message;

    @Value("${config.code}")
    private Integer code;

    //manipulamos con los metodos String
    @Value("#{'${config.listOfValues}'.split(',')}")
    private List<String> listOfValues;

    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String listOfValues0;

    @Value("${config.listOfValues}")
    private List<String> listOfValues1;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    
    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Value("#{${config.valuesMap}.price}")
    private Long price;

    @Value("#{${config.valuesMap}.description}")
    private String description;

    @Autowired
    private Environment environment;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id){
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }
    
    @PostMapping("/create")
    public User create(@RequestBody User user){
        user.setName(user.getName().toUpperCase());
        return user;

    }
    
    @GetMapping("/values")
       public Map<String, Object> values(@Value("${config.message}") String message){
        Map<String, Object> json = new HashMap<>();
        Long envCode = environment.getProperty("config.code", Long.class);

        json.put("username", username);
        // se puede usar el @Value (message) directamente en el método, no es necesario declararlo como variable de clase
        json.put("message", message);
        json.put("envMessage", environment.getProperty("config.message"));
        json.put("envCode", envCode);
        json.put("code", code);
        json.put("listOfValues", listOfValues);
        json.put("listOfValues0", listOfValues0);
        json.put("listOfValues1", listOfValues1);
        json.put("product", product);
        json.put("price", price);
        json.put("description", description);
        json.put("valueMap", valuesMap);
        return json;
    }
    
    
}

