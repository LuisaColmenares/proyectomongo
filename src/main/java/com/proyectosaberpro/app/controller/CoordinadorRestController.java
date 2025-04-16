package com.proyectosaberpro.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosaberpro.app.model.Estudiante;
import com.proyectosaberpro.app.repository.EstudianteRepository;

@RestController
@RequestMapping("/api/coordinador")
public class CoordinadorRestController {

    @Autowired
    private EstudianteRepository estudianteRepo;

    @GetMapping("/estudiantes")
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepo.findAll();
    }

    @PostMapping("/estudiantes")
    public Estudiante crearEstudiante(@RequestBody Estudiante e) {
        calcularNiveles(e);
        return estudianteRepo.save(e);
    }

    private void calcularNiveles(Estudiante e) {
        e.setNivelComunicacion(calcularNivel(e.getPuntajeComunicacion()));
        e.setNivelCuantitativo(calcularNivel(e.getPuntajeCuantitativo()));
        e.setNivelLectura(calcularNivel(e.getPuntajeLectura()));
        e.setNivelCiudadanas(calcularNivel(e.getPuntajeCiudadanas()));
        e.setNivelIngles(calcularNivel(e.getPuntajeIngles()));
        e.setNivelProyectos(calcularNivel(e.getPuntajeProyectos()));
        e.setNivelPensamiento(calcularNivel(e.getPuntajePensamiento()));
        e.setNivelSoftware(calcularNivel(e.getPuntajeSoftware()));
        e.setMediaNacional(e.getPuntajeSaberPro() > 125 ? "Aprobado" : "Reprobado");
    }

    private String calcularNivel(int puntaje) {
        if (puntaje >= 191 && puntaje <= 300) return "Nivel 4";
        if (puntaje >= 156 && puntaje <= 190) return "Nivel 3";
        if (puntaje >= 126 && puntaje <= 155) return "Nivel 2";
        if (puntaje >= 0   && puntaje <= 125) return "Nivel 1";
        return "Error";
    }
}

