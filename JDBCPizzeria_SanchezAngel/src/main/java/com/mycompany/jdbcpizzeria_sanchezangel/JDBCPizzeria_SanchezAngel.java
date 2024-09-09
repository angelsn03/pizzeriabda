/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jdbcpizzeria_sanchezangel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pausa
 */
public class JDBCPizzeria_SanchezAngel {

    public static void main(String[] args) throws SQLException {
        String cadenaConexion = "jdbc:mysql://127.0.0.1:3306/pizzeriabda";
        String user = "root";
        String pwd = "itson";
        String i = "INSERT INTO productos (nombre, precio, descripcion) VALUES (?,?,?)";
        String buscarProducto = "SELECT * FROM productos WHERE precio < ?";
        
        try {
            Connection c = DriverManager.getConnection(cadenaConexion, user, pwd);
//            PreparedStatement insert = c.prepareStatement(i, Statement.RETURN_GENERATED_KEYS);
//            insert.setString(1, "Pizza de pepperoni");
//            insert.setFloat(2, (float) 89.00);
//            insert.setString(3, "Pizza sencilla con base de tomate y queso, con topping de pepperoni");
//          
//            insert.setString(1, "Pizza de queso");
//            insert.setFloat(2, (float) 80.00);
//            insert.setString(3, "Pizza sencilla con base de tomate y queso");
            
//            insert.setString(1, "Pizza de champiñones");
//            insert.setFloat(2, (float) 100.00);
//            insert.setString(3, "Pizza sencilla con base de tomate y queso, con topping de champiñones");
            
            
//          insert.executeUpdate();
            
            
            PreparedStatement busqueda = c.prepareStatement(buscarProducto);
            busqueda.setFloat(1, 100);
            
            ResultSet resultados = busqueda.executeQuery();
            
            if (resultados.next()) {
                String nombre= resultados.getString("nombre");
                float precio = resultados.getFloat("precio");
                String descripcion = resultados.getString("descripcion");
                
                System.out.println(nombre+", $"+precio);
                System.out.println(descripcion);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
}
