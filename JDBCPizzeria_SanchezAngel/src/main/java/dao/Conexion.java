/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import interfaces.IConexionDB;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author pausa
 */
public class Conexion implements IConexionDB{

    private String cadena = "jdbc:mysql://localhost:3306/pizzeriabda";
    private String usuario = "root";
    private String pwd = "itson";
    
    @Override
    public Connection crearConexion() {
        try {
            Connection c = DriverManager.getConnection(cadena, usuario, pwd);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
