package com.proyectosaberpro.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



import com.proyectosaberpro.app.model.Estudiante;
import com.proyectosaberpro.app.model.Coordinador;
import com.proyectosaberpro.app.repository.CoordinadorRepository;
import com.proyectosaberpro.app.repository.EstudianteRepository;

import org.springframework.ui.Model;

@Controller
public class CoordinadorWebController {

    @Autowired
    private CoordinadorRepository coordinadorRepo;

    @Autowired
    private EstudianteRepository estudianteRepo;

    @PostMapping("/login-coordinador")
    public String loginCoordinador(@RequestParam String correo, @RequestParam String contraseña, Model model) {
        Coordinador c = coordinadorRepo.findByCorreoAndContraseña(correo, contraseña);
        if (c != null) {
            model.addAttribute("estudiantes", estudianteRepo.findAll());
            return "coordinador-dashboard";
        }
        return "login";
    }

    @GetMapping("/agregar-estudiante")
    public String mostrarFormularioAgregarEstudiante() {
        return "agregar-estudiante";
        }

    @PostMapping("/guardar-estudiante")
    public String guardarEstudiante(
        @RequestParam String cedula,
        @RequestParam String nombre,
        @RequestParam String apellido,
        @RequestParam String correo,
        @RequestParam String telefono,
        @RequestParam String contraseña,
        @RequestParam String registroPrueba,
        @RequestParam int puntajeSaberPro,
        @RequestParam int puntajeComunicacion,
        @RequestParam int puntajeCuantitativo,
        @RequestParam int puntajeLectura,
        @RequestParam int puntajeCiudadanas,
        @RequestParam int puntajeIngles,
        @RequestParam int puntajeProyectos,
        @RequestParam int puntajePensamiento,
        @RequestParam int puntajeSoftware,
        @RequestParam String nivelIngles,
        Model model) {

        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setCedula(cedula);
        nuevoEstudiante.setNombre(nombre);
        nuevoEstudiante.setApellido(apellido);
        nuevoEstudiante.setCorreo(correo);
        nuevoEstudiante.setTelefono(telefono);
        nuevoEstudiante.setContraseña(contraseña);
        nuevoEstudiante.setNumeroRegistro(registroPrueba);
        nuevoEstudiante.setPuntajeSaberPro(puntajeSaberPro);
        nuevoEstudiante.setNivelSaberPro(calcularNivel(puntajeSaberPro));
        nuevoEstudiante.setMediaNacional(calcularEstado(puntajeSaberPro));

        nuevoEstudiante.setPuntajeComunicacion(puntajeComunicacion);
        nuevoEstudiante.setNivelComunicacion(calcularNivel(puntajeComunicacion));

        nuevoEstudiante.setPuntajeCuantitativo(puntajeCuantitativo);
        nuevoEstudiante.setNivelCuantitativo(calcularNivel(puntajeCuantitativo));

        nuevoEstudiante.setPuntajeLectura(puntajeLectura);
        nuevoEstudiante.setNivelLectura(calcularNivel(puntajeLectura));

        nuevoEstudiante.setPuntajeCiudadanas(puntajeCiudadanas);
        nuevoEstudiante.setNivelCiudadanas(calcularNivel(puntajeCiudadanas));

        nuevoEstudiante.setPuntajeIngles(puntajeIngles);
        nuevoEstudiante.setNivelIngles(calcularNivel(puntajeIngles));

        nuevoEstudiante.setPuntajeProyectos(puntajeProyectos);
        nuevoEstudiante.setNivelProyectos(calcularNivel(puntajeProyectos));

        nuevoEstudiante.setPuntajePensamiento(puntajePensamiento);
        nuevoEstudiante.setNivelPensamiento(calcularNivel(puntajePensamiento));

        nuevoEstudiante.setPuntajeSoftware(puntajeSoftware);
        nuevoEstudiante.setNivelSoftware(calcularNivel(puntajeSoftware));

        nuevoEstudiante.setNivelGeneralIngles(nivelIngles);

        estudianteRepo.save(nuevoEstudiante);

        model.addAttribute("estudiantes", estudianteRepo.findAll());
        return "coordinador-dashboard";
    }

    // 👉 Aquí va el método calcularNivel
    private String calcularNivel(int puntaje) {
        if (puntaje >= 191 && puntaje <= 300) {
            return "Nivel 4";
        } else if (puntaje >= 156 && puntaje <= 190) {
            return "Nivel 3";
        } else if (puntaje >= 126 && puntaje <= 155) {
            return "Nivel 2";
        } else if (puntaje >= 0 && puntaje <= 125) {
            return "Nivel 1";
        } else {
            return "Error";
        }
    }


    private String calcularEstado(int puntaje) {
        if (puntaje >= 125 && puntaje <= 300) {
            return "Aprobado";
        } else if (puntaje >= 1 && puntaje <= 124) {
            return "Reprobado";
        } else if (puntaje == 0) {
            return "Anulado";
        } else {
            return "Error";
        }
    }

    @GetMapping("/editar-estudiante/{cedula}")
    public String editarEstudiante(@PathVariable String cedula, Model model) {
        Estudiante estudiante = estudianteRepo.findByCedula(cedula);
        if (estudiante != null) {
        model.addAttribute("estudiante", estudiante);
        return "editar-estudiante";
    } else {
        return "redirect:/coordinador-dashboard"; // o una vista de error si prefieres
    }
}

@GetMapping("/eliminar-estudiante/{cedula}")
public String eliminarEstudiante(@PathVariable String cedula, Model model) {
    Estudiante estudiante = estudianteRepo.findByCedula(cedula);
    if (estudiante != null) {
        estudianteRepo.delete(estudiante);
    }
    model.addAttribute("estudiantes", estudianteRepo.findAll());
    return "coordinador-dashboard";
}

@GetMapping("/coordinador-dashboard")
public String mostrarDashboard(Model model) {
    model.addAttribute("estudiantes", estudianteRepo.findAll());
    return "coordinador-dashboard";
}

@GetMapping("/ver-estudiante/{cedula}")
public String verEstudiante(@PathVariable String cedula, Model model) {
    Estudiante estudiante = estudianteRepo.findByCedula(cedula);
    if (estudiante != null) {
        model.addAttribute("estudiante", estudiante);
        return "ver-estudiante";
    } else {
        return "redirect:/coordinador-dashboard";
    }
}


}

