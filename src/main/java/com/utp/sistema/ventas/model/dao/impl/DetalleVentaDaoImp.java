package com.utp.sistema.ventas.model.dao.impl;

import com.utp.sistema.ventas.model.DetalleVenta;
import com.utp.sistema.ventas.model.dao.DetalleVentaDao;
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
public class DetalleVentaDaoImp extends DataBase implements DetalleVentaDao {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    static String mensaje = null;

    @Override
    public String insert(DetalleVenta detalleVenta) {
        int flag = 0;
        try {
            con = this.getConnection();
            pst = con.prepareStatement("insert into detalle_venta (idventa, "
                    + "idarticulo, cantidad, precio) values(?, ?, ?, ?)");

            pst.setInt(1, detalleVenta.getIdVenta());
            pst.setInt(2, detalleVenta.getIdArticulo());
            pst.setFloat(3, detalleVenta.getCantidad());
            pst.setDouble(4, detalleVenta.getPrecio());

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
    public DetalleVenta find(Integer idDetalleVenta) {
        DetalleVenta detalleVenta = null;
        try {
            con = this.getConnection();
            pst = con.prepareStatement("select * from detalle_venta "
                    + "WHERE iddetalle_venta= " + idDetalleVenta + "");
            rs = pst.executeQuery();
            if (rs.next()) {
                detalleVenta = new DetalleVenta();
                detalleVenta.setIdDetalle_venta(rs.getInt(1));
                detalleVenta.setIdVenta(rs.getInt(2));
                detalleVenta.setIdArticulo(rs.getInt(3));
                detalleVenta.setCantidad(rs.getFloat(4));
                detalleVenta.setPrecio(rs.getDouble(5));
            } else {
                System.out.println("No se encontró DetalleVenta con el iddetalle_venta = " + idDetalleVenta);
            }
            rs.close();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO FIND - find()");
        } catch (SQLException e) {
            System.out.println("ERROR TO FIND - find()");
            System.out.println(e);
        }
        return detalleVenta;
    }

    @Override
    public List<DetalleVenta> findAll() {
        List<DetalleVenta> detalleVentas = new ArrayList<>();
        try {
            con = this.getConnection();
            pst = con.prepareStatement("select * from detalle_venta");
            rs = pst.executeQuery();

            while (rs.next()) {
                DetalleVenta detalleVenta = new DetalleVenta();
                detalleVenta.setIdDetalle_venta(rs.getInt(1));
                detalleVenta.setIdVenta(rs.getInt(2));
                detalleVenta.setIdArticulo(rs.getInt(3));
                detalleVenta.setCantidad(rs.getFloat(4));
                detalleVenta.setPrecio(rs.getDouble(5));
                detalleVentas.add(detalleVenta);
            }
            rs.close();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO FINDALL - findAll()");
        } catch (SQLException e) {
            System.out.println("ERROR TO FINDALL - findAll()");
            System.out.println(e);
        }
        return detalleVentas;
    }

    @Override
    public String update(DetalleVenta detalleVenta) {
        int flag = 0;
        try {
            con = this.getConnection();
            pst = con.prepareStatement("update detalle_venta set idventa=?, "
                    + "idarticulo=?, cantidad=?, precio=?, "
                    + "WHERE iddetalle_venta=?");

            pst.setInt(1, detalleVenta.getIdVenta());
            pst.setInt(2, detalleVenta.getIdArticulo());
            pst.setFloat(3, detalleVenta.getCantidad());
            pst.setDouble(4, detalleVenta.getPrecio());

            pst.setInt(5, detalleVenta.getIdDetalle_venta());
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
    public void delete(Integer idDetalleVenta) {
        try {
            con = this.getConnection();
            pst = con.prepareStatement("delete from detalle_venta where iddetalle_venta=?");
            pst.setInt(1, idDetalleVenta);

            pst.executeUpdate();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO DELETE - delete()");
        } catch (SQLException e) {
            System.out.println("ERROR TO DELETE - delete()");
            System.out.println(e);
        }
    }

    @Override
    public int getLastIdDetalleVenta() {
        int lastNumeroComprobante = 0;
        try {
            con = this.getConnection();
            pst = con.prepareStatement("select max(iddetalle_venta) from detalle_venta");
            rs = pst.executeQuery();

            if (rs.next()) {
                lastNumeroComprobante = Integer.parseInt(rs.getString(1));
            }

            rs.close();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO GET_LAST_DETALLE_VENTA - getLastIdDetalleVenta()");
        } catch (SQLException e) {
            System.out.println("ERROR TO GET_LAST_DETALLE_VENTA - getLastIdDetalleVenta()");
            System.out.println(e);
        }
        return lastNumeroComprobante;
    }

}
