package com.utp.sistema.ventas.model;

/**
 *
 * @author
 */
public class Entrega {

    private int idEntrega;
    private int idVenta;
    private String fecha;
    private int estado;

    public Entrega() {
    }

    public Entrega(int idEntrega, int idVenta, String fecha, int estado) {
        this.idEntrega = idEntrega;
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
