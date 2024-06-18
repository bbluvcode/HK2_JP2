/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab6_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class EmployeeDAO {

    Scanner sc = new Scanner(System.in);

    ConnectDB connect = new ConnectDB();
    Connection con = connect.getConnect();
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public boolean conected() {
        if (connect == null) {
            System.err.println("Connect db fail");
        } else {
            System.out.println("Connect db successfully");
        }
        return connect != null;
    }

    public void insert(Employee e) {
        if (!conected()) {
            return;
        }
        sql = "INSERT INTO tbEmployee(id,fullname,gender,salary) VALUES(?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, e.id);
            ps.setString(2, e.fullname);
            ps.setBoolean(3, e.gender);
            ps.setInt(4, e.salary);
            ps.execute();

            System.out.println("Add new employee successfully!");
        } catch (SQLException ex) {
            System.err.println("Fail! Cannot execute");
        }

    }

    public void update(Employee e) {
        if (!conected()) {
            return;
        }
        sql = "UPDATE tbEmployee SET id = ?, fullname = ?, gender = ?, salary = ? WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, e.id);
            ps.setString(2, e.fullname);
            ps.setBoolean(3, e.gender);
            ps.setInt(4, e.salary);
            ps.setString(5, e.id);

            ps.executeUpdate();
            System.out.println("Update successfully!");
        } catch (SQLException ex) {
            System.err.println("Cannot update, check again!");
        }

    }

    public void delete(String id) {
        if (!conected()) {
            return;
        }
        sql = "DELETE FROM tbemployee WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, id);
            ps.executeUpdate();
            System.out.println("Delete success!");
        } catch (SQLException ex) {
            System.err.println("Delete fail. Check again!");
        }
    }

    public void getList() {
        if (!conected()) {
            return;
        }

        sql = "SELECT * FROM tbemployee";

        try {
            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("-----");
                System.out.println("ID: " + rs.getString(1));
                System.out.println("Fullname: " + rs.getString(2));
                System.out.println("Gender: " + (rs.getBoolean(3) ? "Nam" : "Nữ"));
                System.out.println("Salary: " + rs.getInt(4));
            }
        } catch (SQLException ex) {
            System.err.println("Query fail");
        }

    }

    public void getList(String name) {
        if (!conected()) {
            return;
        }

        sql = "SELECT * FROM tbemployee WHERE fullname LIKE '%" + name + "%'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("-----");
                System.out.println("ID: " + rs.getString(1));
                System.out.println("Fullname: " + rs.getString(2));
                System.out.println("Gender: " + (rs.getBoolean(3) ? "Nam" : "Nữ"));
                System.out.println("Salary: " + rs.getInt(4));
            }
        } catch (SQLException ex) {
            System.err.println("Query fail");
        }

    }

}
