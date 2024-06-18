/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Library {
    Connection con;
    Statement st;
    PreparedStatement pst;
    ResultSet rs;

    public static void main(String[] args) {
        Library lb = new Library();
        lb.menu();
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("------------------MENU------------------");
            System.out.println("1. Create new book");
            System.out.println("2. Publish the entire list");
            System.out.println("3. Search and delete the book");
            System.out.println("4. Exit !");
            System.out.println("------------------MENU------------------");
            System.out.print("Nhap lua chon[1-4]: ");
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Error: Choice must be digit !");
            }
            switch (choice) {
                case 1:
                    System.out.println("1. Create new book");
                    Book b = new Book(); 
                    b.input();
                    addBook(b);
                    break;
                case 2:
                    System.out.println("2. Publish the entire list");
                    displayAll();
                    break;
                case 3:
                    System.out.println("3. Search and delete book");
                    System.out.print("Enter the ID: ");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    deleteBook(id);
                    break;
                case 4:
                    System.out.println("4. Exit");
                    break;
                default:
                    System.out.println("Enter wrong! Enter choice again[1-4] !");
                    break;
            }
        } while (choice != 4);
    }

    public void displayAll() {
        //ket noi
        ConnectDB connect = new ConnectDB();
        con = connect.getConnect();
        if (con == null) {
            System.out.println("Cannot connect !");
            return;
        } else {
            //viet cau lenh truy van
            String sql = "SELECT *FROM Book";

            try {
                //tao statement
                st = con.createStatement();

                //Truy van
                rs = st.executeQuery(sql);  //ket qua

                //Trich tung dong du lieu
                while (rs.next()) {
                    System.out.println("---Information of Book---");
                    System.out.println("Id: " + rs.getInt(1));
                    System.out.println("Title: " + rs.getString(2));
                    System.out.println("Author: " + rs.getString(3));
                    System.out.println("Edition: " + rs.getInt(4));
                    System.out.println("");
                }
            } catch (SQLException ex) {
                System.out.println("Cannot create statement !");
            }
        }

    }

    public void addBook(Book newBook) {
        ConnectDB connect = new ConnectDB();
        con = connect.getConnect();
        if (con == null) {
            System.out.println("Cannot connect !");
            return;
        } else {
            String sql = "INSERT INTO Book VALUES(?, ?, ?)";

            try {
                //Tao ps
                pst = con.prepareStatement(sql);

                //Tao gia tri moi cho cac field
                //Set gia tri
                pst.setString(1, newBook.Title);
                pst.setString(2, newBook.Author);
                pst.setInt(3, newBook.Edition);

                //thuc thi
                pst.execute();
                System.out.println("Add new Book success !");
            } catch (SQLException ex) {
                System.out.println("Cannot create PrepareStatement !");
            }
        }
    }

    public void deleteBook(int id) {
        ConnectDB connect = new ConnectDB();
        con = connect.getConnect();
        if (con == null) {
            System.out.println("Cannot connect !");
            return;
        } else {
            String sql = "DELETE Book WHERE Id = ?";

            try {
                //Tao ps
                pst = con.prepareStatement(sql);

                //Set gia tri
                pst.setInt(1, id);

                //thuc thi
                int check = pst.executeUpdate();
                if(check > 0){
                    System.out.println("Remove Book success !");
                }else{
                    System.out.println("Remove fail. Not found Id = " +id);
                }  
            } catch (SQLException ex) {
                System.out.println("Cannot create PrepareStatement !");
            }
        }
    }

}
