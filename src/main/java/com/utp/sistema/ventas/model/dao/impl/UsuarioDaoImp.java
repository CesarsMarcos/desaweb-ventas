package com.utp.sistema.ventas.model.dao.impl;

import com.utp.sistema.ventas.model.Usuario;
import com.utp.sistema.ventas.model.dao.UsuarioDao;
import com.utp.sistema.ventas.model.dao.repository.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class UsuarioDaoImp extends DataBase implements UsuarioDao {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public void insert(Usuario usuario) {
        try {
            con = this.getConnection();
            pst = con.prepareStatement("insert into usuario (idrol,nombres,apellidos,tipo_documento,num_documento,direccion,telefono,email,password,estado) values(?,?,?,?,?,?,?,?,?,?)");

            pst.setInt(1, usuario.getIdRol());
            pst.setString(2, usuario.getNombres());
            pst.setString(3, usuario.getApellidos());
            pst.setString(4, usuario.getTipo_documento());
            pst.setString(5, usuario.getNum_documento());
            pst.setString(6, usuario.getDireccion());
            pst.setString(7, usuario.getTelefono());
            pst.setString(8, usuario.getEmail());
            pst.setString(9, usuario.getPassword());
            pst.setInt(10, usuario.getEstado());

            pst.executeUpdate();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO INSERT - insert()");
        } catch (SQLException e) {
            System.out.println("ERROR TO INSERT - insert()");
            System.out.println(e);
        }
    }

    @Override
    public Usuario find(Integer idUsuario) {
        Usuario usuario = null;
        try {
            con = this.getConnection();
            pst = con.prepareStatement("select * from usuario where idusuario= " + idUsuario + "");
            rs = pst.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setIdRol(rs.getInt(2));
                usuario.setNombres(rs.getString(3));
                usuario.setApellidos(rs.getString(4));
                usuario.setTipo_documento(rs.getString(5));
                usuario.setNum_documento(rs.getString(6));
                usuario.setDireccion(rs.getString(7));
                usuario.setTelefono(rs.getString(8));
                usuario.setEmail(rs.getString(9));
                usuario.setPassword(rs.getString(10));
                usuario.setEstado(rs.getByte(11));
            } else {
                System.out.println("No se encontró Usuario con el idusuario = " + idUsuario);
            }
            rs.close();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO FIND - find()");
        } catch (SQLException e) {
            System.out.println("ERROR TO FIND - find()");
            System.out.println(e);
        }
        return usuario;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            con = this.getConnection();
            pst = con.prepareStatement("select * from usuario");
            rs = pst.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setIdRol(rs.getInt(2));
                usuario.setNombres(rs.getString(3));
                usuario.setApellidos(rs.getString(4));
                usuario.setTipo_documento(rs.getString(5));
                usuario.setNum_documento(rs.getString(6));
                usuario.setDireccion(rs.getString(7));
                usuario.setTelefono(rs.getString(8));
                usuario.setEmail(rs.getString(9));
                usuario.setPassword(rs.getString(10));
                usuario.setEstado(rs.getByte(11));
                usuarios.add(usuario);
            }
            rs.close();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO FINDALL - findAll()");
        } catch (SQLException e) {
            System.out.println("ERROR TO FINDALL - findAll()");
            System.out.println(e);
        }
        return usuarios;
    }

    @Override
    public void update(Usuario usuario) {
        try {
            con = this.getConnection();
            pst = con.prepareStatement("update usuario set idrol=?, nombres=?, apellidos=?, tipo_documento=?, num_documento=?, direccion=?, telefono=?, email=?, password=?, estado=? where idusuario=?");

            pst.setInt(1, usuario.getIdRol());
            pst.setString(2, usuario.getNombres());
            pst.setString(3, usuario.getApellidos());
            pst.setString(4, usuario.getTipo_documento());
            pst.setString(5, usuario.getNum_documento());
            pst.setString(6, usuario.getDireccion());
            pst.setString(7, usuario.getTelefono());
            pst.setString(8, usuario.getEmail());
            pst.setString(9, usuario.getPassword());
            pst.setInt(10, usuario.getEstado());

            pst.setInt(11, usuario.getIdUsuario());
            pst.executeUpdate();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO UPDATE - update()");
        } catch (SQLException e) {
            System.out.println("ERROR TO UPDATE - update()");
            System.out.println(e);
        }
    }

    @Override
    public void delete(Integer idUsuario) {
        try {
            con = this.getConnection();
            pst = con.prepareStatement("delete from usuario where idusuario=?");
            pst.setInt(1, idUsuario);

            pst.executeUpdate();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO DELETE - delete()");
        } catch (SQLException e) {
            System.out.println("ERROR TO DELETE - delete()");
            System.out.println(e);
        }
    }

}
