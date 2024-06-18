/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.Scanner;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class StudentManagement {

    Scanner sc = new Scanner(System.in);

    ConnectDB connect = new ConnectDB(); //tao thông tin ket noi db

    Connection con; //connect.getconnect - ket noi
    Statement st; //con.getconnect : read, display - R
    PreparedStatement ps; //add, edit, delete - CUD
    ResultSet rs; //(st/ps) statement query

    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        sm.menu();

    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("-----MENU-----");
            System.out.println("1. Liệt kê sv");
            System.out.println("2. Thêm sv");
            System.out.println("3. Thay đổi thông tin sv");
            System.out.println("4. Xóa sv theo id");
            System.out.println("5. Search by name");
            System.out.println("6. Thoat chuong trinh");
            System.out.println("-----MENU-----");
            System.out.println("Enter your choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Chỉ được nhập số!");
            }
            switch (choice) {
                case 1:
                    System.out.println("1. Liệt kê sv");
                    displayAll();
                    break;
                case 2:
                    System.out.println("2. Thêm sv");
                    add();
                    break;
                case 3:
                    System.out.println("3. Thay đổi thông tin sv");
                    edit();
                    break;
                case 4:
                    System.out.println("4. Xóa sv theo id");
                    delete();
                    break;
                case 5:
                    System.out.println("5. Search by name");
                    searchByName();
                    break;
                case 6:
                    System.out.println("6. Thoat chuong trinh");
                    break;

                default:
                    System.out.println("Lựa chọn sai, hãy chọn lại nhé");
            }
        } while (choice != 5);
    }

    public void displayAll() {
        //1. Tạo kết nối

        con = connect.getConnect();

        if (con == null) {
            System.out.println("Không kết nối được db");
            return;
        } else {
            //2. Viết câu lệnh truy vấn
            String sql = "SELECT * FROM Student";

            try {
                //3. tạo statement
                st = con.createStatement();

                //4. truy vấn
                rs = st.executeQuery(sql);

                //5. trích từng dòng dữ liệu
                while (rs.next()) {
                    System.out.println("-----");
                    System.out.println("ID: " + rs.getString(1));
                    System.out.println("Name: " + rs.getString(2));
                    System.out.println("DoB: " + rs.getString(3));
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void add() {
        con = connect.getConnect();

        String sql = "INSERT INTO Student(id,name,dob) VALUES(?,?,?)";
        //String sql = "INSERT INTO Student VALUES(?,?,?)";
        try {
            //3. tạo ps
            ps = con.prepareStatement(sql);

            //4. set giá trị cho các field
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap id: ");
            String pId = sc.nextLine().trim();

            System.out.println("Nhap name: ");
            String pname = sc.nextLine().trim();

            System.out.println("Nhap dob(YYYY-MM-dd)");
            String pdob = sc.nextLine().trim();

            ps.setString(1, pId); //số cột ở đây không phải thứ tự cột, mà là dấu chấm hỏi trong câu lệnh SQL
            ps.setString(2, pname);
            ps.setDate(3, Date.valueOf(pdob));

            //5. thực thi
            ps.execute();

            System.out.println("Thêm học sinh thành công");
        } catch (SQLException ex) {
            System.err.println("Không tạo được statement");
        }

    }

    public void edit() {

        con = connect.getConnect();
        String sql = "UPDATE student SET name=? WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            //4. set giá trị cho các field
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap id: ");
            String pId = sc.nextLine().trim();

            System.out.println("Nhap name: ");
            String pname = sc.nextLine().trim();

            ps.setString(1, pname);
            ps.setString(2, pId); //số cột ở đây không phải thứ tự cột, mà là dấu chấm hỏi trong câu lệnh SQL

            //5. thực thi chổ này khác excecute add
            ps.executeUpdate();

            System.out.println("Cập nhật tên học sinh thành công");
        } catch (SQLException ex) {
            System.out.println("Cannot create prepareStatement");
        }
    }

    public void delete() {

        con = connect.getConnect();

        String sql = "DELETE FROM student where id = ?";

        try {
            ps = con.prepareStatement(sql);

            Scanner sc = new Scanner(System.in);

            System.out.println("Nhap id: ");
            String pId = sc.nextLine().trim();
            ps.setString(1, pId); //số cột ở đây không phải thứ tự cột, mà là dấu chấm hỏi trong câu lệnh SQL
            ps.executeUpdate();
            System.out.println("Delete student success");

        } catch (SQLException ex) {
            Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void searchByName() {

        con = connect.getConnect();
        System.out.println("Nhap name: ");
        String pname = sc.nextLine().trim();

        String sql = "SELECT * FROM student WHERE name LIKE '%" + pname + "%'";
        try {
            //3. tạo statement
            st = con.createStatement();

            //4. truy vấn
            rs = st.executeQuery(sql);

            //5. trích từng dòng dữ liệu
            while (rs.next()) {
                System.out.println("-----");
                System.out.println("ID: " + rs.getString(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("DoB: " + rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("Query fail");
        }

    }

}
