package com.utp.sistema.ventas.model.dao;

import com.utp.sistema.ventas.model.Entrega;
import java.util.List;
import java.util.Map;

/**
 *
 * @author
 */
public interface EntregaDao extends EntidadDao<Entrega, Integer> {

    List<Map<String, String>> findAllEntregaPending();

    List<Map<String, String>> findAllEntregaComplete();
}
