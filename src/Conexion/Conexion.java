/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alex12
 */
public class Conexion {
    
    static String db = "empresa";
    static String login = "root";
    static String password = "";
    String url = "jdbc:mysql://localhost/"+db;
    Connection conn = null;
    
    public Conexion(){
        try {
            //Driver para la conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Realizamos la conexión
            conn = DriverManager.getConnection(url, login, password);
            
            if (conn != null)
                System.out.println("Conexión a base de datos "+db+" OK");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public void Desconectar(){
        conn = null;
    }
}
