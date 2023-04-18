package com.utp.sistema.ventas.model;

/**
 *
 * @author 
 */
public class Rol {
    private int idRol;
    private String nombre;
    private String descripcion;
    private byte estado;

    public Rol() {
    }

    public Rol(int idRol, String nombre, String descripcion, byte estado) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "\n Rol{"
                + "\n idRol= "+ idRol +""
                + "\n Nombre= "+ nombre +""
                + "\n Descripcion= " + descripcion +""
                + "\n Estado= " + estado + "}";
    }

    
    
    
}
