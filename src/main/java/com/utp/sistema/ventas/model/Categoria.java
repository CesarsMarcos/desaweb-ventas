package com.utp.sistema.ventas.model;

/**
 *
 * @author
 */
public class Categoria {

    private int idCategoria;
    private String descripcion;
    private byte estado;

    public Categoria() {
    }

    public Categoria(int idCategoria, String descripcion, byte estado) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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
        return "\n Categoria{"
                + "\n IdCategoria=" + idCategoria + ""
                + "\n descripcion=" + descripcion + ""
                + "\n estado=" + estado + '}';
    }

}
