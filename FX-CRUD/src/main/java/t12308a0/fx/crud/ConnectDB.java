/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t12308a0.fx.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ConnectDB {
//oke oke
    public Connection cn;

    public Connection getConnect() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=qlsanbong;encrypt=true;trustServerCertificate=true;";
        String username = "sa";
        String pass = "123";

        try {
            //load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //connect to db
            cn = DriverManager.getConnection(url, username, pass);
            System.out.println("Connect successfully");
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Cannot connect");
            System.out.println(ex.getMessage());
        }
        return cn;
    }
}
