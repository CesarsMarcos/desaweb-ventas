/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.sistema.ventas.model.dto;

import com.utp.sistema.ventas.model.Articulo;

public class ProductoParaVenderDTO extends Articulo {

    private Float cantidad;

    public ProductoParaVenderDTO() {
    }

    public ProductoParaVenderDTO(int idArticulo, int idCategoria, String nombre, String descripcion, Float precio_venta, int stock, int estado) {
        super(idArticulo, idCategoria, nombre, descripcion, precio_venta, stock, estado);
        this.cantidad = cantidad;
    }

    public void aumentarCantidad() {
        this.cantidad++;
    }

    public Float  getTotal() {
        return this.getPrecio_venta() * this.cantidad;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

}
