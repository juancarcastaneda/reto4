/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author juanc
 */
public class Conexion 
{
  Connection connection; 
  String driver = "com.mysql.cj.jdbc.Driver";
  String cadenaConeccion = "jdbc:mysql://localhost:3306/retomintic"; 
  String usuario = "root";
  String contraseña = "";
  public Conexion()
  {
      try 
      {
       Class.forName(driver);
       //get conection (cadena coneccion , usuario , contraseña)
       connection = DriverManager.getConnection(cadenaConeccion,usuario,contraseña);
       if(connection != null)
       {
           System.out.println("Conexion existosa");
       }
      }
      catch ( ClassNotFoundException | SQLException e)
      {
          System.out.println("Conexion fallida");
      }
      
  }
  public Connection getConnection()
  {
      return connection;
  }

  
}
