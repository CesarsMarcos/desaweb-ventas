package com.utp.sistema.ventas.model.dao;

import com.utp.sistema.ventas.model.Venta;

/**
 *
 * @author
 */
public interface VentaDao extends EntidadDao<Venta, Integer> {

    public String findLastSerieComprobante();

    public int findLastNumeroComprobante();

    public int getLastIdVenta();

    void updateEstadoVenta(Integer idVenta);
}
