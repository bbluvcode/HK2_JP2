/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab6_1;

import java.sql.*;

import java.util.Scanner;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class test {

    public static void main(String[] args) {
        test t = new test();
        t.menu();
//        System.out.println(LocalDate.now().getMonthValue());
    }

    Scanner sc = new Scanner(System.in);

    ConnectDB connect = new ConnectDB();
    Connection con = connect.getConnect();
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
    project p = new project();

    public boolean connected() {
        if (con == null) {
            System.err.println("Conect DB fail");
        }
        return con != null;
    }

    public void add() {
        if (!connected()) {
            return;
        }
        p.input();

        sql = "INSERT tbProject (projectName, startDate, value, completed) VALUES (?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, p.projectName);
            ps.setString(2, p.startDate);
            ps.setInt(3, p.value);
            ps.setBoolean(4, p.completed);

            ps.execute();
            System.out.println("Add new project successfully!");
        } catch (SQLException ex) {
            System.err.println("Fail, cannot add!");
        }

    }

    public void displayAll() {
        if (!connected()) {
            return;
        }
        sql = "select * from tbproject";
        try {
            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("-----");
                System.out.println("ID: " + rs.getInt(1));
                System.out.println("projectName : " + rs.getString(2));
                System.out.println("startDate : " + rs.getString(3));
                System.out.println("value : " + rs.getInt(4));
                System.out.println("completed : " + (rs.getBoolean(5) ? "Yes" : "No"));
            }
        } catch (SQLException ex) {
            System.err.println("Query fail");
        }

    }

    public void displayCompleted() {
        if (!connected()) {
            return;
        }

        sql = "Select * from tbproject where completed = 1";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("-----");
                System.out.println("ID: " + rs.getInt(1));
                System.out.println("projectName : " + rs.getString(2));
                System.out.println("startDate : " + rs.getString(3));
                System.out.println("value : " + rs.getInt(4));
                System.out.println("completed : " + (rs.getBoolean(5) ? "Yes" : "No"));
            }
        } catch (SQLException ex) {
            System.err.println("Query fail");

        }

    }

    public void remove(int id) {
        if (!connected()) {
            return;
        }
        sql = "DELETE tbproject where id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Cannot execute");
        }

    }

    public void edit(project p) {
        if (!connected()) {
            return;
        }
        sql = "update tbproject set projectName = ?, startDate = ?, value = ?, completed = ? where id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.projectName);
            ps.setString(2, p.startDate);
            ps.setInt(3, p.value);
            ps.setBoolean(4, p.completed);
            ps.setInt(5, p.id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Cannot execute");
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice = 998;
        do {
            System.out.println("-------MENU--------");
            System.out.println("1. Thêm 1 dự án mới");
            System.out.println("2. Liệt kê tất cả dự án");
            System.out.println("3. Liệt kê tất cả dự án đã hoàn tất");
            System.out.println("4. Xóa dự án theo mã số");
            System.out.println("5. Chỉnh sửa thông tin dự án");
            System.out.println("0. Thoát");
            System.out.print("--Hãy nhập lựa chọn: ");
            try {
                choice = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.err.println("Chỉ được nhập số");
            }
            switch (choice) {
                case 1:
                    System.out.println("1. Thêm 1 dự án mới");
                    add();
                    break;
                case 2:
                    System.out.println("2. Liệt kê tất cả dự án");
                    displayAll();
                    break;
                case 3:
                    System.out.println("3. Liệt kê tất cả dự án đã hoàn tất");
                    displayCompleted();
                    break;
                case 4:
                    System.out.println("4. Xóa dự án theo mã số");
                    int idp = 0;
                    try {
                        idp = Integer.parseInt(sc.nextLine());

                    } catch (NumberFormatException e) {
                        System.err.println("Chỉ được nhập số");
                    }
                    remove(idp);
                    break;
                case 5:
                    System.out.println("5. Chỉnh sửa thông tin dự án");
                    try {
                        p.id = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.err.println("Chỉ được nhập số");
                    }
                    p.input();
                    edit(p);
                    break;
                case 0:
                    System.out.println("Thoát!");
                    break;

                default:
                    System.err.println("Chọn sai, hãy thử lại");
            }
        } while (choice != 0);
    }

}
