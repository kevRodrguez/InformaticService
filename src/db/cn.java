/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author kevrodriguez
 */

public class cn {
    Connection conexion;
    
    public Connection getConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conexion=(Connection) DriverManager.getConnection("jdbc:mysql://34.118.206.73/db_informatic_service","admin","admin");            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        return conexion;
    }

    
}

