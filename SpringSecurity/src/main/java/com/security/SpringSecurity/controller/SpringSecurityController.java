package com.security.SpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityController {

    @GetMapping("/security")
    public String basicController(){
        return "Spring security demo !!";
    }

    @GetMapping("/user")
    public String userEndpoint(){
        return "Hello User !!";
    }

    @GetMapping("/admin")
    public String adminEndpoint(){
        return "Hello Admin !!";
    }
}
