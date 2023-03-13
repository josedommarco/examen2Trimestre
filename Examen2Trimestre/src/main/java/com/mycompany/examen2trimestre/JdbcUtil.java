/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen2trimestre;

/**
 *
 * @author josel
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcUtil {

    static private Connection con = null;

    static {
        String url = "jdbc:mysql://localhost:3306/examen?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String password = "admin";
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion Satisfactoria");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    static Connection getConnection() {
        return con;
    }
}
