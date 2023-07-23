package com.utp.sistema.ventas.model.dao.impl;

import com.utp.sistema.ventas.model.Articulo;
import com.utp.sistema.ventas.model.dao.ArticuloDao;
import com.utp.sistema.ventas.model.dao.repository.DataBase;
import com.utp.sistema.ventas.model.util.Constantes;
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
public class ArticuloDaoImp extends DataBase implements ArticuloDao {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    static String mensaje = null;

    @Override
    public String insert(Articulo articulo) {
        int flag = 0;
        try {
            con = getConnection();
            pst = con.prepareStatement("insert into articulo (idcategoria,descripcion,precio_venta,stock,estado) values(?,?,?,?,?)");

            pst.setInt(1, articulo.getIdCategoria());
            pst.setString(2, articulo.getDescripcion());
            pst.setFloat(3, articulo.getPrecioVenta());
            pst.setInt(4, articulo.getStock());
            pst.setInt(5, articulo.getEstado());

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
    public Articulo find(Integer idArticulo) {

        Articulo articulo = new Articulo();

        try {
            con = getConnection();
            pst = con.prepareStatement("select * from articulo where idarticulo= " + idArticulo + "");

            rs = pst.executeQuery();

            if (rs.next()) {
                articulo.setIdArticulo(rs.getInt(1));
                articulo.setIdCategoria(rs.getInt(2));
                articulo.setDescripcion(rs.getString(3));
                articulo.setPrecioVenta(rs.getFloat(4));
                articulo.setStock(rs.getInt(5));
                articulo.setEstado(rs.getByte(6));
            } else {
                System.out.println("No se encontró Usuario con el idarticulo = " + idArticulo);
            }

            rs.close();
            pst.close();
            con.close();

            System.out.println("SUCCESS TO FIND - find()");
        } catch (SQLException e) {
            System.out.println("ERROR TO FIND - find()");
            System.out.println(e);
        }
        return articulo;
    }

    @Override
    public List<Articulo> findAll() {
        List<Articulo> articulos = new ArrayList<>();

        try {
            con = getConnection();
            pst = con.prepareStatement("select * from articulo");
            rs = pst.executeQuery();

            while (rs.next()) {
                Articulo articulo = new Articulo();

                articulo.setIdArticulo(rs.getInt(1));
                articulo.setIdCategoria(rs.getInt(2));
                articulo.setDescripcion(rs.getString(3));
                articulo.setPrecioVenta(rs.getFloat(4));
                articulo.setStock(rs.getInt(5));
                articulo.setEstado(rs.getInt(6));

                articulos.add(articulo);
            }

            rs.close();
            pst.close();
            con.close();

            System.out.println("SUCCESS TO FINDALL - findAll()");
        } catch (SQLException e) {
            System.out.println("ERROR TO FINDALL - findAll()");
            System.out.println(e);
        }
        return articulos;
    }

    @Override
    public String update(Articulo articulo) {
        int flag = 0;
        try {
            con = getConnection();
            pst = con.prepareStatement("update articulo set idcategoria=?, descripcion=?, precio_venta=?, stock=?, estado=? where idarticulo=?");

            pst.setInt(1, articulo.getIdCategoria());
            pst.setString(2, articulo.getDescripcion());
            pst.setDouble(3, articulo.getPrecioVenta());
            pst.setInt(4, articulo.getStock());
            pst.setInt(5, articulo.getEstado());

            pst.setInt(6, articulo.getIdArticulo());

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
    public void delete(Integer idArticulo) {
        try {
            con = this.getConnection();
            pst = con.prepareStatement("delete from articulo where idarticulo=?");

            pst.setInt(1, idArticulo);

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
