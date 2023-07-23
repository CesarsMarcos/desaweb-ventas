package com.utp.sistema.ventas.model;

/**
 *
 * @author
 */
public class Articulo {

    private int idArticulo;
    private int idCategoria;
    private String descripcion;
    private Float precio_venta;
    private int stock;
    private int estado;

    public Articulo() {
    }

    public Articulo(int idArticulo, int idCategoria, String nombre,
            String descripcion, Float precio_venta, int stock, int estado) {
        this.idArticulo = idArticulo;
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.precio_venta = precio_venta;
        this.stock = stock;
        this.estado = estado;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Float precio_venta) {
        this.precio_venta = precio_venta;
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

    @Override
    public String toString() {
        return "\n Articulo{"
                + "\n idArticulo=" + idArticulo + ""
                + "\n idCategoria=" + idCategoria + ""
                + "\n descripcion=" + descripcion + ""
                + "\n precio_venta=" + precio_venta + ""
                + "\n stock=" + stock + ""
                + "\n estado=" + estado + '}';
    }

 

}
