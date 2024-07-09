package com.aluracurso.foro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foro")
public class UsuarioController {

    @GetMapping
    public String helloWorld() {
        return "Hello world from Europe!";
    }

}
