/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class EmployeeIOText {

    //khai bao 1 danh sach chua cac Employee kieu ArrayList
    public ArrayList<Employee> eList = new ArrayList();

    //khaibao 1 ten file
    public String fileName = "employee.txt";

    //1. tao stream output file, nếu file name đã tồn tại thì sẽ ghi đè
//    PrintWriter pw;

    public EmployeeIOText() {
        readFile();
    }

    //doc file
    public void readFile() {

        //1. kiem tra xem co file chua
        File f = new File(fileName);
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
                //tao doi tuong Emp co thong so dua vao mang
                Employee e = new Employee(arr[0], arr[1], arr[2], (Float.parseFloat(arr[3])));
                
                //thêm nhân viên vào ds
                eList.add(e);      
            }
            //4. dong luong
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmployeeIOText.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmployeeIOText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ghi file
    public void writeFile() {
        if (eList.isEmpty()) {
            System.out.println("Ds chưa có dữ liệu để ghi vào file");
            return;
        }

        try {
//            
            //1. tao stream output file, nếu file name đã tồn tại thì sẽ ghi đè
            PrintWriter pw = new PrintWriter(fileName);

            //2. ghi ds vao file
            eList.forEach(e -> pw.println(e.toString()));

            //3. dong file
            pw.close();

            System.out.println("Write list to file sucessfully!");

            //4. open file by notepad
            Runtime r = Runtime.getRuntime();

            r.exec("notepad " + fileName);
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot create stream");
        } catch (IOException ex) {
            Logger.getLogger(EmployeeIOText.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
