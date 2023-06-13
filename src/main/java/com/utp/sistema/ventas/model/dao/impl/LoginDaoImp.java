package com.utp.sistema.ventas.model.dao.impl;

import com.utp.sistema.ventas.model.Usuario;
import com.utp.sistema.ventas.model.dao.LoginDao;
import com.utp.sistema.ventas.model.dao.RolDao;
import com.utp.sistema.ventas.model.dao.repository.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class LoginDaoImp extends DataBase implements LoginDao{

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public Usuario validateLogin(String dni, String password) {
        Usuario usuario = null;
        try {
            con = getConnection();
            pst = con.prepareStatement("select * from usuario where num_documento= " + dni + " and password=" + password + "");
            rs = pst.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setIdRol(rs.getInt(2));
                usuario.setNombres(rs.getString(3));                                                        
               //JOptionPane.showMessageDialog(null, "Bienvenido al Sistema " + rs.getString(3) + " - " + getNombreRol(rs.getInt(2)));
               
                System.out.println("Usuario ingresado " + usuario.getNombres());   
            } else {
                System.out.println("No se encontró Usuario con el DNI y PASSWORD ingresado");                
            }
            rs.close();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO VALIDATE_LOGIN - validateLogin()");
        } catch (SQLException e) {
            System.out.println("ERROR TO VALIDATE_LOGIN - validateLogin()");
        }
        return usuario;
    }

    private String getNombreRol(int idRol) {
        RolDao rolDao = new RolDaoImp();

        return rolDao.find(idRol).getNombre();
    }
}
