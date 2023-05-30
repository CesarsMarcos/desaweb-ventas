/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.sistema.ventas.model.dao.impl;

import com.utp.sistema.ventas.model.Menu;
import com.utp.sistema.ventas.model.dao.MenuDao;
import com.utp.sistema.ventas.model.dao.repository.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cesar
 */
public class MenuDaoimpl extends DataBase implements MenuDao {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public List<Menu> findMenuByUserName(String username) {
        List<Menu> menus = new ArrayList<>();
        try {
            con = this.getConnection();
            pst = con.prepareStatement("SELECT D.* FROM sys_venta.menu_rol A , sys_venta.usuario B, sys_venta.rol C, sys_venta.menu D\n"
                    + "WHERE B.idrol = C.idrol \n"
                    + "AND A.id_rol = C.idrol\n"
                    + "AND A.id_menu = D.id_menu\n"
                    + "AND B.num_documento = '" + username + "'");
            rs = pst.executeQuery();

            while (rs.next()) {
                Menu menu = new Menu();
                menu.setIdMenu(rs.getInt(1));
                menu.setMenu(rs.getString(2));
                menu.setRuta(rs.getString(3));

                menus.add(menu);

            }
            rs.close();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO FINDALL - findAll() "+ menus.size());
        } catch (SQLException e) {
            System.out.println("ERROR TO FINDALL - findAll()");
            System.out.println(e);
        }
        return menus;
    }

}
