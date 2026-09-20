package com.example.trabalho_mecanico.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    // Teste
    @GetMapping
    public String helloWorld(){
        return "Hello Asdrubal!";
    }

}
