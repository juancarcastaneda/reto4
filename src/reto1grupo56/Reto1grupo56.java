/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto1grupo56;
import modelo.*;
import vista.Login;
import vista.*;
/**
 *
 * @author juanc
 */
public class Reto1grupo56 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Conexion conexionDB = new Conexion();
        Login login = new Login();
        login.setVisible(true);
    }
    
}
