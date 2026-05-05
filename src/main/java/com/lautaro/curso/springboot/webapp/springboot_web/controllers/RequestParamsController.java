package com.lautaro.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lautaro.curso.springboot.webapp.springboot_web.controllers.models.dto.ParamDto;
import com.lautaro.curso.springboot.webapp.springboot_web.controllers.models.dto.ParamMixDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo (@RequestParam(required = false, defaultValue = "No se ha recibido ningun mensaje") String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }
    
    @GetMapping("/bar")
    public ParamMixDto bar (@RequestParam String text, @RequestParam Integer code) {
        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

}
