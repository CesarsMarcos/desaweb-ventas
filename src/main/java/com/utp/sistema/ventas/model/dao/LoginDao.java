package com.utp.sistema.ventas.model.dao;

import com.utp.sistema.ventas.model.Usuario;

/**
 *
 * @author
 */
public interface LoginDao {
    
    public Usuario validateLogin(String dni, String password);
}
