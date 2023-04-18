package com.utp.sistema.ventas.model.dao.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class DataBase {
/* DATOS PARA LA CONEXION */
  private final String bd = "sys_venta";
  private final String username = "root";
  private final String password = "123456";
  private final String url = "jdbc:mysql://localhost/"+bd+"?characterEncoding=utf8";
  private Connection conn = null;

    public Connection getConnection()
    {
        try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(url,username,password);
         if (conn!=null){
            System.out.println("OK base de datos "+bd+" listo");
         }
      }catch(SQLException | ClassNotFoundException e){
         System.out.println(e);
      }       
        return this.conn;
    }        
}
