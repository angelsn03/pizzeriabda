/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import interfaces.IConexionDB;
import interfaces.IProductoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import objetos.Producto;

/**
 *
 * @author angelsn
 */
public class ProductoDAO implements IProductoDAO{

    private IConexionDB conexion;
    
    @Override
    public boolean agregar(Producto producto) {
        try {
            Connection bd = conexion.crearConexion();
            String insertar = "INSERT INTO productos (nombre, descripcion, precio) VALUES (?, ?, ?)";
            PreparedStatement i = bd.prepareStatement(insertar);

            i.setString(1, producto.getNombre());
            i.setString(2, producto.getDescripcion());
            i.setFloat(3, producto.getPrecio());
            
            i.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean actualizar(Producto producto) {
        try {
            Connection bd = conexion.crearConexion();
            String actualizar = "UPDATE producto SET nombre = ?, descripcion = ?, precio = ? WHERE idProducto = ?";
            PreparedStatement u = bd.prepareStatement(actualizar);

            u.setString(1, producto.getNombre());
            u.setString(2, producto.getDescripcion());
            u.setFloat(3, producto.getPrecio());
            u.setInt(4, producto.getId());

            u.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;  
    }

    @Override
    public boolean eliminar(int id) {
        try {
            Connection bd = conexion.crearConexion();
            String eliminar = "DELETE FROM productos WHERE id = ?";
            PreparedStatement e = bd.prepareStatement(eliminar);
            
            e.setInt(1, id);
            
            e.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Producto consultar(int id) {
        Producto producto = null;
        try {
            Connection bd = conexion.crearConexion();
            String consultar = "SELECT * FROM productos WHERE id = ?";
            PreparedStatement c = bd.prepareStatement(consultar);

            c.setInt(1, id);
            ResultSet rs = c.executeQuery();

            if (rs.next()) {
                producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getFloat("precio"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public List<Producto> consultar() {
        List<Producto> productos = new ArrayList<>();
        try {
            Connection bd = conexion.crearConexion();
            String consultarTodos = "SELECT * FROM productos";
            PreparedStatement c = bd.prepareStatement(consultarTodos);

            ResultSet rs = c.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getFloat("precio"));

                productos.add(producto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return productos;
    }
    
}
