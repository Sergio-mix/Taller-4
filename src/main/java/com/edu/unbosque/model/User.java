package com.edu.unbosque.model;

/**
 * Class User
 */
public class User {
    private String usuario;
    private String fecha;
    private String descripcion;
    private String ruta;

    /**
     * Constructor
     * @param usuario
     * @param fecha
     * @param descripcion
     * @param ruta
     */
    public User(String usuario, String fecha, String descripcion, String ruta) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.ruta = ruta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripción() {
        return descripcion;
    }

    public void setDescripción(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
