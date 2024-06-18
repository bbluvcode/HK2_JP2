/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.*;
/**
 *
 * @author User
 */
public class ConnectDB {
    public Connection cn;
    public Connection getConnect(){
        String url = "jdbc:sqlserver://localhost:1433;databaseName=LibDB;encrypt=true;trustServerCertificate=true;";
        String username = "sa";
        String pass = "123";
        
        try {
            //load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            //connect to DB
            cn = DriverManager.getConnection(url, username, pass);
//            System.out.println("Connect successfully !");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " +ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Cannot Connect !");
            System.out.println(ex.getMessage());
        }
        return cn;
    }
        
}
