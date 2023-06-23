package com.utp.sistema.ventas.model.dao.impl;

import com.utp.sistema.ventas.model.Categoria;
import com.utp.sistema.ventas.model.dao.CategoriaDao;
import com.utp.sistema.ventas.model.dao.repository.DataBase;
import com.utp.sistema.ventas.model.util.Constantes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class CategoriaDaoImp extends DataBase implements CategoriaDao {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    static String mensaje = null;

    @Override
    public String insert(Categoria categoria) {
        int flag = 0;
        try {
            con = this.getConnection();
            pst = con.prepareStatement("insert into categoria (descripcion,estado) values (?,?)");

            pst.setString(1, categoria.getDescripcion());
            pst.setInt(2, categoria.getEstado());

            flag = pst.executeUpdate();
            if (flag != 0) {
                mensaje = Constantes.MENSAJE_REGISTRO;
            }

            pst.close();
            con.close();

            System.out.println("SUCCESS TO INSERT - insert()");
        } catch (SQLException e) {
            System.out.println("ERROR TO INSERT - insert()");
            System.out.println(e);
        }
        return mensaje;
    }

    @Override
    public Categoria find(Integer idCategoria) {
        Categoria categoria = null;
        try {
            con = this.getConnection();
            pst = con.prepareStatement("select * from categoria where idcategoria= " + idCategoria + "");
            rs = pst.executeQuery();
            if (rs.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt(1));
                categoria.setDescripcion(rs.getString(2));
                categoria.setEstado(rs.getByte(3));
            } else {
                System.out.println("No se encontró Categoria con el idcategoria = " + idCategoria);
            }

            rs.close();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO FIND - find()");
        } catch (SQLException e) {
            System.out.println("ERROR TO FIND - find()");
            System.out.println(e);
        }
        return categoria;
    }

    @Override
    public List<Categoria> findAll() {
        List<Categoria> categorias = new ArrayList<>();
        try {
            con = this.getConnection();
            pst = con.prepareStatement("select * from categoria");
            rs = pst.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt(1));
                categoria.setDescripcion(rs.getString(2));
                categoria.setEstado(rs.getByte(3));
                categorias.add(categoria);
            }
            rs.close();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO FINDALL - findAll()");

        } catch (SQLException e) {
            System.out.println("ERROR TO FINDALL - findAll()");
            System.out.println(e);
        }

        System.out.println("SUCCESS TO FINDALL - findAll() " + categorias.size());
        return categorias;
    }

    @Override
    public String update(Categoria categoria) {
        int flag = 0;
        try {
            con = this.getConnection();
            pst = con.prepareStatement("update categoria set descripcion= ?, estado= ? where idcategoria=?");

            pst.setString(1, categoria.getDescripcion());
            pst.setInt(2, categoria.getEstado());

            pst.setInt(3, categoria.getIdCategoria());

            flag = pst.executeUpdate();
            if (flag != 0) {
                mensaje = Constantes.MENSAJE_ACTUALIZAR;
            }
            pst.close();
            con.close();
            System.out.println("SUCCESS TO UPDATE - update()");
        } catch (SQLException e) {
            System.out.println("ERROR TO UPDATE - update()");
            System.out.println(e);
        }
        return mensaje;
    }

    @Override
    public void delete(Integer idCategoria) {
        try {
            con = this.getConnection();
            pst = con.prepareStatement("delete from categoria where idcategoria=?");
            pst.setInt(1, idCategoria);

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
