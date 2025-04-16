package com.proyectosaberpro.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyectosaberpro.app.model.Coordinador;

public interface CoordinadorRepository extends MongoRepository<Coordinador, String> {
    Coordinador findByCorreoAndContraseña(String correo, String contraseña);
}