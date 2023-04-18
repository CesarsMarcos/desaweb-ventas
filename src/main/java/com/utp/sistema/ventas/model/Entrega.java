package com.utp.sistema.ventas.model;

/**
 *
 * @author
 */
public class Entrega {

    private int identrega;
    private int idVenta;
    private String fecha;
    private byte estado;

    public Entrega() {
    }

    public Entrega(int identrega, int idVenta, String fecha, byte estado) {
        this.identrega = identrega;
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getIdentrega() {
        return identrega;
    }

    public void setIdentrega(int identrega) {
        this.identrega = identrega;
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

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

}
