package com.utp.sistema.ventas.model;

/**
 *
 * @author
 */
public class Articulo {

    private int idArticulo;
    private int idCategoria;
    private String descripcion;
    private double precio_venta;
    private int stock;
    private byte estado;

    public Articulo() {
    }

    public Articulo(int idArticulo, int idCategoria, String nombre,
            String descripcion, double precio_venta, int stock, byte estado) {
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

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
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

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
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
