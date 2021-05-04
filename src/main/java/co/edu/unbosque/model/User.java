package co.edu.unbosque.model;

import javax.swing.*;
import java.io.File;

/**
 * Class User
 */
public class User {
    private String usuario;
    private String fecha;
    private String descripcion;
    private ImageIcon imagen;

    /**
     * Constructor
     * @param usuario
     * @param fecha
     * @param descripcion
     * @param imagen
     */
    public User(String usuario, String fecha, String descripcion, ImageIcon imagen) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.imagen = imagen;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }
}
