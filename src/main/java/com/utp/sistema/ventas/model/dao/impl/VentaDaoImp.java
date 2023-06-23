package com.utp.sistema.ventas.model.dao.impl;

import com.utp.sistema.ventas.model.Venta;
import com.utp.sistema.ventas.model.dao.VentaDao;
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
public class VentaDaoImp extends DataBase implements VentaDao {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    static String mensaje = null;

    @Override
    public String insert(Venta venta) {
        int flag = 0;
        try {
            con = this.getConnection();
            pst = con.prepareStatement("INSERT INTO venta (ruc, tipo_comprobante, num_comprobante, idcliente, "
                    + "fecha_hora, impuesto, descuento, total, estado, idusuario)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            pst.setString(1, venta.getRuc());
            pst.setString(2, venta.getTipo_comprobante());
            pst.setString(3, venta.getNum_comprobante());
            pst.setInt(4, venta.getIdCliente());
            pst.setString(5, String.valueOf(venta.getFecha_hora()));
            pst.setDouble(6, venta.getImpuesto());
            pst.setDouble(7, venta.getDescuento());
            pst.setDouble(8, venta.getTotal());
            pst.setInt(9, venta.getEstado());
            pst.setInt(10, venta.getIdUsuario());

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
    public Venta find(Integer idVenta) {
        Venta venta = null;
        try {
            con = this.getConnection();
            pst = con.prepareStatement("select * from venta where idventa= " + idVenta + "");
            rs = pst.executeQuery();
            if (rs.next()) {
                venta = new Venta();
                venta.setIdVenta(rs.getInt(1));
                venta.setRuc(rs.getString(2));
                venta.setTipo_comprobante(rs.getString(3));
                venta.setNum_comprobante(rs.getString(4));
                venta.setIdCliente(rs.getInt(5));
                venta.setFecha_hora(rs.getString(6));
                venta.setImpuesto(rs.getDouble(7));
                venta.setDescuento(rs.getDouble(8));
                venta.setTotal(rs.getDouble(9));
                venta.setEstado(rs.getByte(10));
                venta.setIdUsuario(rs.getInt(11));
            } else {
                System.out.println("No se encontró Venta con el idventa  = " + idVenta);
            }
            rs.close();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO FIND - find()");
        } catch (SQLException e) {
            System.out.println("ERROR TO FIND - find()");
            System.out.println(e);
        }
        return venta;
    }

    @Override
    public List<Venta> findAll() {
        List<Venta> ventas = new ArrayList<>();
        try {
            con = this.getConnection();
            pst = con.prepareStatement("select * from venta");
            rs = pst.executeQuery();

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(rs.getInt(1));
                venta.setRuc(rs.getString(2));
                venta.setTipo_comprobante(rs.getString(3));
                venta.setNum_comprobante(rs.getString(4));
                venta.setIdCliente(rs.getInt(5));
                venta.setFecha_hora(rs.getString(6));
                venta.setImpuesto(rs.getDouble(7));
                venta.setDescuento(rs.getDouble(8));
                venta.setTotal(rs.getDouble(9));
                venta.setEstado(rs.getByte(10));
                venta.setIdUsuario(rs.getInt(11));
                ventas.add(venta);
            }
            rs.close();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO FINDALL - findAll()");
        } catch (SQLException e) {
            System.out.println("ERROR TO FINDALL - findAll()");
            System.out.println(e);
        }
        return ventas;
    }

    @Override
    public String update(Venta venta) {
        int flag = 0;
        try {
            con = this.getConnection();
            pst = con.prepareStatement("UPDATE venta SET ruc=?, tipo_comprobante=?, "
                    + "num_comprobante=?, idcliente=?, fecha_hora=?, impuesto=?, "
                    + "descuento=?, total=?, estado=?, idusuario=? "
                    + "WHERE idventa=?");
            pst.setString(1, venta.getRuc());
            pst.setString(2, venta.getTipo_comprobante());
            pst.setString(3, venta.getNum_comprobante());
            pst.setInt(4, venta.getIdCliente());
            pst.setString(5, String.valueOf(venta.getFecha_hora()));
            pst.setDouble(6, venta.getImpuesto());
            pst.setDouble(7, venta.getDescuento());
            pst.setDouble(8, venta.getTotal());
            pst.setInt(9, venta.getEstado());
            pst.setInt(10, venta.getIdUsuario());

            pst.setInt(11, venta.getIdVenta());
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
    public void delete(Integer idVenta) {
        try {
            con = this.getConnection();
            pst = con.prepareStatement("delete from venta where idventa=?");
            pst.setInt(1, idVenta);

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
    public String findLastSerieComprobante() {
        String lastSerieComprobante = "";
        try {
            con = this.getConnection();
            pst = con.prepareStatement("select max(serie_comprobante) from venta");
            rs = pst.executeQuery();

            if (rs.next()) {
                lastSerieComprobante = rs.getString(1);
            }

            rs.close();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO FIND_LAST_SERIE_COMPROBANTE - findLastSerieComprobante()");
        } catch (SQLException e) {
            System.out.println("ERROR TO FIND_LAST_SERIE_COMPROBANTE - findLastSerieComprobante()");
            System.out.println(e);
        }
        return lastSerieComprobante;
    }

    @Override
    public int findLastNumeroComprobante() {
        int lastNumeroComprobante = 0;
        try {
            con = this.getConnection();
            pst = con.prepareStatement("select max(num_comprobante) from venta");
            rs = pst.executeQuery();

            if (rs.next()) {
                lastNumeroComprobante = Integer.parseInt(rs.getString(1));
            }

            rs.close();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO FIND_LAST_NUMERO_COMPROBANTE - findLastNumeroComprobante()");
        } catch (SQLException e) {
            System.out.println("ERROR TO FIND_LAST_NUMERO_COMPROBANTE - findLastNumeroComprobante()");
            System.out.println(e);
        }
        return lastNumeroComprobante;
    }

    @Override
    public int getLastIdVenta() {
        int lastNumeroComprobante = 0;
        try {
            con = this.getConnection();
            pst = con.prepareStatement("select max(idventa) from venta");
            rs = pst.executeQuery();

            if (rs.next()) {
                lastNumeroComprobante = Integer.parseInt(rs.getString(1));
            }

            rs.close();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO GET_LAST_ID_VENTA - getLastIdVenta()");
        } catch (SQLException e) {
            System.out.println("ERROR TO GET_LAST_ID_VENTA - getLastIdVenta()");
            System.out.println(e);
        }
        return lastNumeroComprobante;
    }

    @Override
    public void updateEstadoVenta(Integer idVenta) {
        try {
            con = this.getConnection();
            pst = con.prepareStatement("UPDATE venta SET estado=? WHERE idventa=?");

            pst.setInt(1, 1);

            pst.setInt(2, idVenta);

            pst.executeUpdate();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO UPDATE - updateEstadoVenta()");
        } catch (SQLException e) {
            System.out.println("ERROR TO UPDATE - updateEstadoVenta()");
            System.out.println(e);
        }
    }
}
