/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jdbcpizzeria_sanchezangel;

/**
 *
 * @author pausa
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductosDAO implements IProductosDAO {
    private IConexionDB conexionDB;

    // Constructor que recibe una implementación de IConexionDB
    public ProductosDAO(IConexionDB conexionDB) {
        this.conexionDB = conexionDB;
    }

    @Override
    public void insertarProducto(Producto producto) throws SQLException {
        String query = "INSERT INTO productos (nombre, precio, descripcion) VALUES (?, ?, ?)";
        
        try (Connection con = conexionDB.getConnection(); 
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setString(3, producto.getDescripcion());
            ps.executeUpdate();
        }
    }

    @Override
    public Producto obtenerProductoPorId(int idProducto) throws SQLException {
        String query = "SELECT * FROM productos WHERE idProducto = ?";
        Producto producto = null;
        
        try (Connection con = conexionDB.getConnection(); 
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                producto = new Producto(
                    rs.getInt("idProducto"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getString("descripcion")
                );
            }
        }
        return producto;
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() throws SQLException {
        String query = "SELECT * FROM productos";
        List<Producto> productos = new ArrayList<>();
        
        try (Connection con = conexionDB.getConnection(); 
             Statement st = con.createStatement(); 
             ResultSet rs = st.executeQuery(query)) {
            
            while (rs.next()) {
                Producto producto = new Producto(
                    rs.getInt("idProducto"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getString("descripcion")
                );
                productos.add(producto);
            }
        }
        return productos;
    }

    @Override
    public void actualizarProducto(Producto producto) throws SQLException {
        String query = "UPDATE productos SET nombre = ?, precio = ?, descripcion = ? WHERE idProducto = ?";
        
        try (Connection con = conexionDB.getConnection(); 
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setString(3, producto.getDescripcion());
            ps.setInt(4, producto.getIdProducto());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminarProducto(int idProducto) throws SQLException {
        String query = "DELETE FROM productos WHERE idProducto = ?";
        
        try (Connection con = conexionDB.getConnection(); 
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idProducto);
            ps.executeUpdate();
        }
    }
}

