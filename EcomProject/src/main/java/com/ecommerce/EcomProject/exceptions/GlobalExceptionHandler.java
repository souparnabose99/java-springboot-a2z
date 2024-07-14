package com.ecommerce.EcomProject.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
@ExceptionHandler
public class GlobalExceptionHandler {

    public Map<String, String> myMethodArgumentNotValidException(){
        
    }
}
