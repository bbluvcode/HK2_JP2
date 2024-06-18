/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class EmployeeIO_Object {

    //để có thể ghi Object employee thì Employee class phải implements Serializable
    public ArrayList<Employee> empList = new ArrayList<>();

    String fileName = "employee.txt";

    public EmployeeIO_Object() {
        readObject();
    }

    public void readObject() {
        //1. Mở file
        File f = new File(fileName);

        if (!f.exists()) {
            System.out.println("File is not exist");
            return;
        }
        try {
            //2. Mở luồng để đọc
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));

            //3. Đọc 
            empList = (ArrayList<Employee>) ois.readObject();

            //4. đóng luồng
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmployeeIO_Object.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(EmployeeIO_Object.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeFileObject() {
        try {
            //2. ghi
            try ( //1. mở luồng để ghi
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                //2. ghi
                oos.writeObject(empList);
                //3. dong luong
                oos.close();
                System.out.println("Write list to file sucessfully!");

            }
                //4. open file by notepad
                Runtime r = Runtime.getRuntime();
                r.exec("notepad " + fileName);
        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        } catch (IOException ex) {
            System.err.println("Cannot create stream, không thể tạo luồng");
        }
    }
    public void openFileObject(){
        Runtime r = Runtime.getRuntime();
        try {
            r.exec("notepad " + fileName);
        } catch (IOException ex) {
            Logger.getLogger(EmployeeIO_Object.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
