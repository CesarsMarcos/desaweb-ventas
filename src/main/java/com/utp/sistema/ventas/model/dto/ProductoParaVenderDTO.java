/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.sistema.ventas.model.dto;

import com.utp.sistema.ventas.model.Articulo;

public class ProductoParaVenderDTO extends Articulo {

    private Float cantidad;

    public ProductoParaVenderDTO(Float cantidad, int idCategoria, String descripcion, Float precioVenta, int stock, int estado) {
        super(idCategoria, descripcion, precioVenta, stock, estado);
        this.cantidad = cantidad;
    }

    public ProductoParaVenderDTO(Float cantidad, int idArticulo, int idCategoria, String descripcion, Float precioVenta, int stock, int estado) {
        super(idArticulo, idCategoria, descripcion, precioVenta, stock, estado);
        this.cantidad = cantidad;
    }

    public void aumentarCantidad() {
        this.cantidad++;
    }

    public Float getTotal() {
        return this.getPrecioVenta() * this.cantidad;
    }

 
    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

}
