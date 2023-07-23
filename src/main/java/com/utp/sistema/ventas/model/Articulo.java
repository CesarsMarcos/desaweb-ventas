package com.utp.sistema.ventas.model;

/**
 *
 * @author
 */
public class Articulo {

    private Integer idArticulo;
    private int idCategoria;
    private String descripcion;
    private Float precioVenta;
    private int stock;
    private int estado;

    public Articulo() {
    }

    public Articulo(int idCategoria, String descripcion, Float precioVenta, int stock, int estado) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.estado = estado;
    }

    public Articulo(int idArticulo, int idCategoria,
            String descripcion, Float precioVenta, int stock, int estado) {
        this.idArticulo = idArticulo;
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.estado = estado;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public boolean sinExistencia() {
        return this.stock <= 0;
    }

    public void restarExistencia(Float stock) {
        this.stock -= stock;
    }

}
