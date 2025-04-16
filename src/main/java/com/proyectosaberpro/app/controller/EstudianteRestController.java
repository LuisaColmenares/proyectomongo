package com.proyectosaberpro.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosaberpro.app.model.Estudiante;
import com.proyectosaberpro.app.repository.EstudianteRepository;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteRestController {

    @Autowired
    private EstudianteRepository estudianteRepo;

    @GetMapping("/{cedula}")
    public Estudiante obtenerEstudiante(@PathVariable String cedula) {
        return estudianteRepo.findById(cedula).orElse(null);
    }
}

