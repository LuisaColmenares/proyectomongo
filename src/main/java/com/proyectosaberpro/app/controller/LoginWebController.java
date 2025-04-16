package com.proyectosaberpro.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginWebController {

    @GetMapping("/")
    public String mostrarLogin() {
        return "login";  // Esto busca templates/login.html
    }
}
