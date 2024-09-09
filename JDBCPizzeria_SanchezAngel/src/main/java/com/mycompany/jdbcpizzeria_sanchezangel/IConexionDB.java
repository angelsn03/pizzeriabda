/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jdbcpizzeria_sanchezangel;

/**
 *
 * @author angelsn
 */
import java.sql.Connection;
import java.sql.SQLException;

public interface IConexionDB {
    Connection getConnection() throws SQLException;
}

