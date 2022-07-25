
package Controlador;

import java.sql.*;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.Sucursal;

public class cbSucursal {
    Connection connection;
    Conexion conexion = new Conexion();
    Statement st;
    ResultSet rs;
    
    public ArrayList getListaSucursales()
    {
        ArrayList mListaSucursales = new ArrayList();
        Sucursal sucursal = null;
        String query = "SELECT idSucursal,nombreSucursal FROM sucursal;";
        try 
        {
             connection = conexion.getConnection();
             st = connection.createStatement();
             rs = st.executeQuery(query);
             while (rs.next())
             {                
                sucursal = new Sucursal();
                sucursal.setIdSucursal(rs.getInt("idSucursal"));
                sucursal.setNombreSucursal(rs.getString("nombreSucursal"));
                mListaSucursales.add(sucursal);
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
                                
        }
        return mListaSucursales;
    }
    
}
