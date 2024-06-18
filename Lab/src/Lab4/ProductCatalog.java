/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ProductCatalog {

    HashMap<String, Product> pList = new HashMap<>();
    String fname = "TONKHO.DAT";
    String fname2 = "TONKHOobject.DAT";

    public ProductCatalog() {
        readFileO();
    }

    void add() {
        Product p = new Product();
        p.input();

        pList.put(p.id, p);
        System.out.println("Add product successfully!");
    }

    void set(String sID, float sQty, boolean isReceive) {
        Product p = pList.get(sID);
//        float qty = isReceive ? p.in_qty : p.out_qty;
        if (!isReceive && p.out_qty < sQty || !isReceive && p.out_qty == 0) {
            System.err.println("Thất bại. Không thể xuất");
            return;
        }
        if (isReceive) {
            p.in_qty += sQty;
        } else {
            p.out_qty -= sQty;
        }
        pList.replace(sID, p);
        System.out.println((isReceive ? "Nhập kho " : "Xuất kho ") + "thành công!");
        System.out.println("Số lượng hiện tại :" + p.in_qty);

    }

    void display() {
        if (pList.isEmpty()) {
            System.err.println("Product list is empty!");
            return;
        }

        for (Product p : pList.values()) {
            System.out.println("---");
            p.output();
        }
    }

    void readFile() {
        //1. kiem tra xem co file chua
        File f = new File(fname);
        if (!f.exists()) {
            System.out.println("File not exist");
            return;
        }

        try {
            //2. mo luong file de doc
            BufferedReader br = new BufferedReader(new FileReader(f));

            //3. doc file
            while (br.ready()) {
                //đọc từng dòng dữ liệu
                String line = br.readLine();
                //cat chuoi thanh mang
                String[] arr = line.split(",");

                String id = arr[0].trim();
                String name = arr[1].trim();
                int price = Integer.parseInt(arr[2].trim());
                float in_qty = Float.parseFloat(arr[3].trim());
                float out_qty = Float.parseFloat(arr[4].trim());
                //tao doi tuong Emp co thong so dua vao mang
                Product p = new Product(id, name, price, in_qty, out_qty);

                //thêm nhân viên vào ds
                pList.put(p.id, p);
            }
            //4. dong luong
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductCatalog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void readFileO() {
        //1. Mở file
        File f = new File(fname2);

        if (!f.exists()) {
            System.out.println("File is not exist");
            return;
        }
        try {
            //2. Mở luồng để đọc
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));

            //3. Đọc 
            pList = (HashMap<String, Product>) ois.readObject();

            //4. đóng luồng
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductCatalog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ProductCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void saveFile() {

        if (pList.isEmpty()) {
            System.out.println("Ds chưa có dữ liệu để ghi vào file");
            return;
        }

        try {
//            
            //1. tao stream output file, nếu file name đã tồn tại thì sẽ ghi đè
            PrintWriter pw = new PrintWriter(fname);

            //2. ghi ds vao file
            pList.values().forEach(e -> pw.println(e.toString()));

            //3. dong file
            pw.close();

            System.out.println("Write list to file sucessfully!");

            //4. open file by notepad
            Runtime r = Runtime.getRuntime();

            r.exec("notepad " + fname);
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot create stream");
        } catch (IOException ex) {
            Logger.getLogger(ProductCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void saveFileO() {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname2));
            //2. ghi
//                oos.writeObject(pList);

            //List<Product> temp = new ArrayList(pList.values());
            oos.writeObject(pList);

            //3. dong luong
            oos.close();
            System.out.println("Write list to file sucessfully!");
        } catch (FileNotFoundException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    void menu() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("---------------------MENU---------------");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Nhập kho");
            System.out.println("3. Xuất kho");
            System.out.println("4. Báo cáo tồn kho");
            System.out.println("5. Lưu file");
            System.out.println("6. Thoát");
            System.out.println("---------------------MENU---------------");
            System.out.print("Enter your choice: ");
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Chỉ được nhập số");
                sc.nextLine();
            }
            switch (choice) {
                case 1:
                    System.out.println("1. Thêm sản phẩm mới");
                    add();
                    break;
                case 2:
                    System.out.println("2. Nhập kho");
                    sc.nextLine();
                    System.out.print("Nhập ID sản phẩm: ");
                    String idn = sc.nextLine().trim().toUpperCase();
                    if (!pList.containsKey(idn)) {
                        System.err.println("ID không tồn tại, hãy thử lại!");
                        break;
                    }
                    System.out.print("Nhập số lượng: ");
                    float sln = 0;
                    try {
                        sln = Float.parseFloat(sc.nextLine());

                    } catch (NumberFormatException e) {
                        System.err.println("Chỉ được nhập số");
                        sc.nextLine();
                    }
                    if (sln < 0) {
                        System.err.println("Không hợp lệ. Hãy thử lại!");
                        break;
                    }
                    set(idn, sln, true);
                    break;
                case 3:
                    System.out.println("3. Xuất kho");
                    sc.nextLine();
                    System.out.print("Nhập ID sản phẩm: ");
                    String idx = sc.nextLine().trim().toUpperCase();
                    if (!pList.containsKey(idx)) {
                        System.err.println("ID không tồn tại, hãy thử lại!");
                        break;
                    }
                    System.out.print("Nhập số lượng: ");
                    float slx = 0;
                    try {
                        slx = Float.parseFloat(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.err.println("Chỉ được nhập số");
                        sc.nextLine();
                    }
                    if (slx < 0) {
                        System.err.println("Không hợp lệ. Hãy thử lại!");
                        break;
                    }
                    set(idx, slx, false);
                    break;
                case 4:
                    System.out.println("4. Báo cáo tồn kho");
                    display();
                    break;
                case 5:
                    System.out.println("5. Lưu file");
                    saveFileO();
                    break;
                case 6:
                    System.out.println("6. Thoát");
                    break;
                default:
                    System.err.println("Lựa chọn sai, hãy thử lại");
                    break;
            }

        } while (choice != 6);
    }
}
