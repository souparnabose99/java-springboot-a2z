package com.security.SpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class SpringSecurityController {

    @GetMapping("/security")
    public String basicController(){
        return "Spring security demo !!";
    }
}