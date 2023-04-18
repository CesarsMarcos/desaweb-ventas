package com.utp.sistema.ventas.model;

/**
 *
 * @author
 */
public class Venta {

    private int idVenta;
    private String ruc;
    private String tipo_comprobante;
    private String num_comprobante;
    private int idCliente;
    private String fecha_hora;
    private double impuesto;
    private double descuento;
    private double total;
    private byte estado;
    private int idUsuario;

    public Venta() {
    }

    public Venta(int idVenta, String ruc, String tipo_comprobante,
            String num_comprobante, int idCliente, String fecha_hora, double impuesto,
            double descuento, double total, byte estado, int idUsuario) {
        this.idVenta = idVenta;
        this.ruc = ruc;
        this.tipo_comprobante = tipo_comprobante;
        this.num_comprobante = num_comprobante;
        this.idCliente = idCliente;
        this.fecha_hora = fecha_hora;
        this.impuesto = impuesto;
        this.descuento = descuento;
        this.total = total;
        this.estado = estado;
        this.idUsuario = idUsuario;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipo_comprobante() {
        return tipo_comprobante;
    }

    public void setTipo_comprobante(String tipo_comprobante) {
        this.tipo_comprobante = tipo_comprobante;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNum_comprobante() {
        return num_comprobante;
    }

    public void setNum_comprobante(String num_comprobante) {
        this.num_comprobante = num_comprobante;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "\n Venta{"
                + "\n idVenta=" + idVenta + ""
                + "\n RUC=" + ruc + ""
                + "\n tipo_comprobante=" + tipo_comprobante + ""
                + "\n num_comprobante=" + num_comprobante + ""
                + "\n idCliente=" + idCliente + ""
                + "\n fecha_hora=" + fecha_hora + ""
                + "\n impuesto=" + impuesto + ""
                + "\n descuento=" + descuento + ""
                + "\n total=" + total + ""
                + "\n estado=" + estado + ""
                + "\n idUsuario=" + idUsuario + '}';
    }

}
