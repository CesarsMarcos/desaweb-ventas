package com.utp.sistema.ventas.model.dao;
import com.utp.sistema.ventas.model.DetalleVenta;

/**
 *
 * @author
 */
public interface DetalleVentaDao extends  EntidadDao<DetalleVenta, Integer>{
    public int getLastIdDetalleVenta();
}
