package com.proyectosaberpro.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estudiantes")
public class Estudiante {

    @Id
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String contraseña;
    private String numeroRegistro;
    private int puntajeSaberPro;
    private String nivelSaberPro;
    private String mediaNacional;
    private String estado;

    private int puntajeComunicacion;
    private String nivelComunicacion;

    private int puntajeCuantitativo;
    private String nivelCuantitativo;

    private int puntajeLectura;
    private String nivelLectura;

    private int puntajeCiudadanas;
    private String nivelCiudadanas;

    private int puntajeIngles;
    private String nivelIngles;

    private int puntajeProyectos;
    private String nivelProyectos;

    private int puntajePensamiento;
    private String nivelPensamiento;

    private int puntajeSoftware;
    private String nivelSoftware;

    private String nivelGeneralIngles;

    // Constructor vacío
    public Estudiante() {
    }

    // Getters y Setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public int getPuntajeSaberPro() {
        return puntajeSaberPro;
    }

    public void setPuntajeSaberPro(int puntajeSaberPro) {
        this.puntajeSaberPro = puntajeSaberPro;
    }

    public String getNivelSaberPro() {
        return nivelSaberPro;
    }

    public void setNivelSaberPro(String nivelSaberPro) {
        this.nivelSaberPro = nivelSaberPro;
    }

    public String getMediaNacional() {
        return mediaNacional;
    }

    public void setMediaNacional(String mediaNacional) {
        this.mediaNacional = mediaNacional;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPuntajeComunicacion() {
        return puntajeComunicacion;
    }

    public void setPuntajeComunicacion(int puntajeComunicacion) {
        this.puntajeComunicacion = puntajeComunicacion;
    }

    public String getNivelComunicacion() {
        return nivelComunicacion;
    }

    public void setNivelComunicacion(String nivelComunicacion) {
        this.nivelComunicacion = nivelComunicacion;
    }

    public int getPuntajeCuantitativo() {
        return puntajeCuantitativo;
    }

    public void setPuntajeCuantitativo(int puntajeCuantitativo) {
        this.puntajeCuantitativo = puntajeCuantitativo;
    }

    public String getNivelCuantitativo() {
        return nivelCuantitativo;
    }

    public void setNivelCuantitativo(String nivelCuantitativo) {
        this.nivelCuantitativo = nivelCuantitativo;
    }

    public int getPuntajeLectura() {
        return puntajeLectura;
    }

    public void setPuntajeLectura(int puntajeLectura) {
        this.puntajeLectura = puntajeLectura;
    }

    public String getNivelLectura() {
        return nivelLectura;
    }

    public void setNivelLectura(String nivelLectura) {
        this.nivelLectura = nivelLectura;
    }

    public int getPuntajeCiudadanas() {
        return puntajeCiudadanas;
    }

    public void setPuntajeCiudadanas(int puntajeCiudadanas) {
        this.puntajeCiudadanas = puntajeCiudadanas;
    }

    public String getNivelCiudadanas() {
        return nivelCiudadanas;
    }

    public void setNivelCiudadanas(String nivelCiudadanas) {
        this.nivelCiudadanas = nivelCiudadanas;
    }

    public int getPuntajeIngles() {
        return puntajeIngles;
    }

    public void setPuntajeIngles(int puntajeIngles) {
        this.puntajeIngles = puntajeIngles;
    }

    public String getNivelIngles() {
        return nivelIngles;
    }

    public void setNivelIngles(String nivelIngles) {
        this.nivelIngles = nivelIngles;
    }

    public int getPuntajeProyectos() {
        return puntajeProyectos;
    }

    public void setPuntajeProyectos(int puntajeProyectos) {
        this.puntajeProyectos = puntajeProyectos;
    }

    public String getNivelProyectos() {
        return nivelProyectos;
    }

    public void setNivelProyectos(String nivelProyectos) {
        this.nivelProyectos = nivelProyectos;
    }

    public int getPuntajePensamiento() {
        return puntajePensamiento;
    }

    public void setPuntajePensamiento(int puntajePensamiento) {
        this.puntajePensamiento = puntajePensamiento;
    }

    public String getNivelPensamiento() {
        return nivelPensamiento;
    }

    public void setNivelPensamiento(String nivelPensamiento) {
        this.nivelPensamiento = nivelPensamiento;
    }

    public int getPuntajeSoftware() {
        return puntajeSoftware;
    }

    public void setPuntajeSoftware(int puntajeSoftware) {
        this.puntajeSoftware = puntajeSoftware;
    }

    public String getNivelSoftware() {
        return nivelSoftware;
    }

    public void setNivelSoftware(String nivelSoftware) {
        this.nivelSoftware = nivelSoftware;
    }

    public String getNivelGeneralIngles() {
        return nivelGeneralIngles;
    }

    public void setNivelGeneralIngles(String nivelGeneralIngles) {
        this.nivelGeneralIngles = nivelGeneralIngles;
    }
}
