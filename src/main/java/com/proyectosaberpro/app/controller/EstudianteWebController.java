package com.proyectosaberpro.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyectosaberpro.app.model.Estudiante;
import com.proyectosaberpro.app.repository.EstudianteRepository;

@Controller
public class EstudianteWebController {

    @Autowired
    private EstudianteRepository estudianteRepo;

    @PostMapping("/login-estudiante")
    public String loginEstudiante(@RequestParam String correo, @RequestParam String contraseña, Model model) {
        Estudiante e = estudianteRepo.findByCorreoAndContraseña(correo, contraseña);
        if (e != null) {
            model.addAttribute("estudiante", e);
            return "estudiante-dashboard";
        }
        return "login";
    }
}

