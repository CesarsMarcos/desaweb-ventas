package com.utp.sistema.ventas.model.dao.impl;

import com.utp.sistema.ventas.model.Entrega;
import com.utp.sistema.ventas.model.dao.EntregaDao;
import com.utp.sistema.ventas.model.dao.repository.DataBase;
import com.utp.sistema.ventas.model.util.Constantes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author
 */
public class EntregaDaoImpl extends DataBase implements EntregaDao {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    static String mensaje = null;

    @Override
    public String insert(Entrega entrega) {
        int flag = 0;
        try {
            con = this.getConnection();
            pst = con.prepareStatement("insert into entrega_producto (idventa, fecha_hora, estado) values (?, ?, ?)");

            pst.setInt(1, entrega.getIdVenta());
            pst.setString(2, entrega.getFecha());
            pst.setInt(3, entrega.getEstado());

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
    public Entrega find(Integer idRol) {
        return null;
    }

    @Override
    public List<Entrega> findAll() {
        List<Entrega> listaEntrega = new ArrayList<>();
        try {
            con = this.getConnection();
            pst = con.prepareStatement("select * from entrega_producto");
            rs = pst.executeQuery();

            while (rs.next()) {
                Entrega entrega = new Entrega();

                entrega.setIdEntrega(rs.getInt(1));
                entrega.setIdVenta(Integer.parseInt(rs.getString(2)));
                entrega.setFecha(rs.getString(3));
                entrega.setEstado(rs.getByte(4));

                listaEntrega.add(entrega);
            }
            rs.close();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO FINDALL - findAll()");
        } catch (SQLException e) {
            System.out.println("ERROR TO FINDALL - findAll()");
            System.out.println(e);
        }
        return listaEntrega;
    }

    @Override
    public String update(Entrega entrega) {
        int flag = 0;
        try {
            con = this.getConnection();
            pst = con.prepareStatement("update entrega_producto set estado= ? where identrega=?");

            pst.setInt(1, entrega.getEstado());

            pst.setInt(2, entrega.getIdEntrega());

            flag = pst.executeUpdate();
            if (flag != 0) {
                mensaje = "Updated  SuccessFully";
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
    public void delete(Integer idRol) {
        //        
    }

    @Override
    public List<Map<String, String>> findAllEntregaPending() {
        List<Map<String, String>> listaEntrega = new ArrayList<>();
        try {
            con = this.getConnection();
            pst = con.prepareStatement("select entrega_producto.identrega, venta.idventa, cliente.nombres as Cliente, venta.estado as Estado\n"
                    + "from entrega_producto \n"
                    + "	inner join venta\n"
                    + "on entrega_producto.idventa = venta.idventa\n"
                    + "	inner join cliente\n"
                    + "on venta.idcliente = cliente.idcliente\n"
                    + " where venta.estado = 0\n"
                    + "order by identrega DESC;");
            rs = pst.executeQuery();

            while (rs.next()) {
                Map<String, String> entregaMap = new HashMap<>();
                entregaMap.put("idEntrega", rs.getString(1));
                entregaMap.put("idVenta", rs.getString(2));
                entregaMap.put("Cliente", rs.getString(3));
                entregaMap.put("Estado", rs.getString(4));
                listaEntrega.add(entregaMap);
            }
            rs.close();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO FINDALL - findAll()");
        } catch (SQLException e) {
            System.out.println("ERROR TO FINDALL - findAll()");
            System.out.println(e);
        }
        return listaEntrega;
    }

    @Override
    public List<Map<String, String>> findAllEntregaComplete() {
        List<Map<String, String>> listaEntrega = new ArrayList<>();
        try {
            con = this.getConnection();
            pst = con.prepareStatement("select entrega_producto.identrega, "
                    + "venta.idventa, cliente.nombres as Cliente, venta.estado as Estado\n"
                    + "from entrega_producto \n"
                    + "	inner join venta\n"
                    + "on entrega_producto.idventa = venta.idventa\n"
                    + "	inner join cliente\n"
                    + "on venta.idcliente = cliente.idcliente\n"
                    + " where venta.estado = 1\n"
                    + "order by identrega DESC");
            rs = pst.executeQuery();

            while (rs.next()) {
                Map<String, String> entregaMap = new HashMap<>();
                entregaMap.put("idEntrega", rs.getString(1));
                entregaMap.put("idVenta", rs.getString(2));
                entregaMap.put("Cliente", rs.getString(3));
                entregaMap.put("Estado", rs.getString(4));
                listaEntrega.add(entregaMap);
            }
            rs.close();
            pst.close();
            con.close();
            System.out.println("SUCCESS TO FINDALL - findAll()");
        } catch (SQLException e) {
            System.out.println("ERROR TO FINDALL - findAll()");
            System.out.println(e);
        }
        return listaEntrega;
    }
}
