/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.utp.sistema.ventas.model.dao;

import com.utp.sistema.ventas.model.Menu;
import java.util.List;

/**
 *
 * @author Cesar
 */
public interface MenuDao {
    
    List<Menu> findMenuByUserName(String username);
    
}
