/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Student;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class StudentList {

    public static void main(String[] args) {
        StudentList test = new StudentList();
        test.menu();
    }

    Scanner sc = new Scanner(System.in);

    ConnectDB connect = new ConnectDB();

    Connection con = connect.getConnect();
    Statement st;
    PreparedStatement ps;
    ResultSet rs;

    String sql;

    public void displayAll() {
        if (con == null) {
            System.err.println("Cannot connect db");
            return;
        }
        sql = "SELECT * FROM student";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("-----");
                System.out.println("ID: " + rs.getInt(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("Address: " + rs.getString(3));
                System.out.println("Email: " + rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void add() {
        if (con == null) {
            System.err.println("Cannot connect db");
            return;
        }

        sql = "INSERT INTO student(name, address, email) VALUES (?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            Student s = new Student();
            s.input();

            ps.setString(1, s.name);
            ps.setString(2, s.address);
            ps.setString(3, s.email);

            ps.execute();
        } catch (SQLException ex) {
            System.err.println("Cannot add new student");
        }
    }

    public void delete(int id) {
        if (con == null) {
            System.err.println("Cannot connect DB");
            return;
        }
        try {

            sql = "SELECT COUNT(id) FROM student WHERE id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next(); //truy cập vô dòng của kết quả trả về
            int count = rs.getInt(1); // Lấy giá trị đếm từ cột đầu tiên của ResultSet
            if (count == 0) {
                System.err.println("Cannot delete id " + id + ". It doesn't exist!");
                return;
            }
            sql = "DELETE FROM student WHERE id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Deleted student id " + id);
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Cannot delete student id " + id);
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice = 998;
        do {
            System.out.println("---------MENU----------");
            System.out.println("1. Create a new student");
            System.out.println("2. Show All");
            System.out.println("3. Delete student by id");
            System.out.println("0. Exit");
            System.out.print("----Enter your choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("1. Create a new student");
                        add();
                        break;
                    case 2:
                        System.out.println("2. Show All");
                        displayAll();
                        break;
                    case 3:
                        System.out.println("3. Delete student by id");
                        int id = Integer.parseInt(sc.nextLine());
                        delete(id);
                        break;
                    case 0:
                        System.out.println("0. Exit");
                        break;
                    default:
                        System.err.println("Wrong choice , try again!");
                }
            } catch (NumberFormatException e) {
                System.err.println("Only enter number");
            }
        } while (choice != 0);
    }

}
