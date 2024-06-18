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
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class LaptopDAO {
    public TreeMap<String, Laptop> lList = new TreeMap();
    public String fileName = "Laptop.txt";

    public LaptopDAO() {
        readFile();
    }
    public void readFile(){
        File f = new File(fileName);
        if(!f.exists()){
            System.out.println("File not found !");
            return;
        }
        else{
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                lList = (TreeMap<String, Laptop>) ois.readObject();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LaptopDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(LaptopDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LaptopDAO.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
        
    }
    public void writeFile(){
        try {
            ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(fileName));
            ois.writeObject(lList);
            ois.close();
            System.out.println("Write file success !");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LaptopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LaptopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void add(){
        Laptop l = new Laptop();
        l.input();
        lList.put(l.code, l);
        System.out.println("Add new Laptop success !");
    }
    
    public void displayAll(){
        if(lList.isEmpty()){
            System.out.println("List of Laptop is empty !");
            return;
        }
        System.out.println("----------List of Laptop----------");
        for(Laptop l : lList.values()){
            l.Display();
        }
    }
    public void standardizeByCode(String id){
        if(lList.isEmpty()){
            System.out.println("List of Laptop is empty !");
            return;
        }
        Laptop lSearch = lList.values().stream().filter(l->l.code.equals(id)).findFirst().orElse(null);
        if(lSearch == null){
            System.out.println("Not found laptop have Code: " +id);
        }else{
            lSearch.standardize();
            System.out.println("Information after standardize");
            lSearch.Display();
        }
    }
    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("------------------MENU------------------");
            System.out.println("1. Add New Laptop");
            System.out.println("2. Standardize the descriptions by the code of Laptop");
            System.out.println("3. Display all Laptops");
            System.out.println("4. Write to file");
            System.out.println("5. Exit !");
            System.out.println("------------------MENU------------------");
            System.out.print("Nhap lua chon[1-5]: ");
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Error: Choice must be digit !");
            }
            switch (choice) {
                case 1:
                    System.out.println("1. Add New Laptop");
                    add();
                    break;
                case 2:
                    System.out.println("2. Standardize the descriptions by the code of Laptop.");
                    System.out.print("Enter code: ");
                    String id = sc.nextLine().trim();
                    standardizeByCode(id);
                    break;
                case 3:
                    System.out.println("3. Display all Laptops");
                    displayAll();
                    break;    
                case 4:
                    System.out.println("4. Write to file");
                    writeFile();
                    break;               
                case 5:
                    System.out.println("5. Exit");
                    break;
                default:
                    System.out.println("Enter wrong! Enter choice again[1-5] !");
                    break;
            }
        } while (choice != 5);
    }
    public static void main(String[] args) {
        LaptopDAO ld = new LaptopDAO();
        ld.menu();
    }
}
