package com.utp.sistema.ventas.model.dao;

import java.util.List;

/**
 *
 * @author
 */
public interface EntidadDao<T, V> {

    public void insert(T t);

    public T find(V v);

    public List<T> findAll();

    public void update(T t);

    public void delete(V v);

}
