package com.proyectosaberpro.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyectosaberpro.app.model.Estudiante;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
    Estudiante findByCorreoAndContraseña(String correo, String contraseña);
    List<Estudiante> findAll();
    Estudiante findByCedula(String cedula);
}
