/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jdbcpizzeria_sanchezangel;

/**
 *
 * @author pausa
 */
import java.sql.SQLException;
import java.util.List;

public interface IProductosDAO {
    void insertarProducto(Producto producto) throws SQLException;
    Producto obtenerProductoPorId(int idProducto) throws SQLException;
    List<Producto> obtenerTodosLosProductos() throws SQLException;
    void actualizarProducto(Producto producto) throws SQLException;
    void eliminarProducto(int idProducto) throws SQLException;
}

