/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Laptop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class LaptopDAO {

    public static void main(String[] args) {
        LaptopDAO test = new LaptopDAO();
        test.menu();
    }

    TreeMap<String, Laptop> laptopList = new TreeMap<>();

    String fname = "laptop.txt";

    public LaptopDAO() {
        read();
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice = 998;
        do {
            System.out.println("---------------MENU-----------");
            System.out.println("1. Add new Laptop");
            System.out.println("2. Standardize descriptions by the code of Laptop");
            System.out.println("3. Display all Laptops");
            System.out.println("4. Write to file");
            System.out.println("0. Exit");
            System.out.println("---------------MENU-----------");
            System.out.println("Enter your choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Only enter a number");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.println("1. Add new Laptop");
                    add();
                    break;
                case 2:
                    System.out.println("2. Standardize descriptions by the code of Laptop");
                    String code = sc.nextLine();
                    standardize(code);
                    break;
                case 3:
                    System.out.println("3. Display all Laptops");
                    displayAll();
                    break;
                case 4:
                    System.out.println("4. Write to file");
                    save();
                    break;
                case 0:
                    System.out.println("0. Exit");
                    break;
                default:
                    System.err.println("Choice invalid, try again!");
            }
        } while (choice != 0);
    }

    public boolean isEmptyList() {
        if (laptopList.isEmpty()) {
            System.err.println("No laptops to display");
        }
        return laptopList.isEmpty();
    }

    public void add() {
        Laptop l = new Laptop();
        l.input();

        if (!laptopList.isEmpty()) {
            if (laptopList.containsKey(l.code)) {
                System.err.println("Cannot add, the laptop code existed!");
                return;
            }
        }

        laptopList.put(l.code, l);
        System.out.println("Add new laptop successfully!");

    }

    public void standardize(String code) {
        Laptop lapSearch = laptopList.values().stream().filter(l -> l.code.equals(code)).findFirst().orElse(null);
        if (lapSearch == null) {
            System.out.println("Not found laptop code " + code);

        } else {
            lapSearch.standardize();
            System.out.println("Information after standardadize:");
            lapSearch.display();
        }
    }

    public void displayAll() {
        for (Laptop l : laptopList.values()) {
            System.out.println("-----");
            l.display();
        }
    }

    public void save() {
        if (laptopList.isEmpty()) {
            System.err.println("Not laptop to write to file");
            return;
        }
        try {
            PrintWriter pw = new PrintWriter(fname);

            laptopList.values().forEach(l -> pw.println(l.toString()));

            pw.close();
            System.out.println("Write to file successfully");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LaptopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void read() {
        File f = new File(fname);
        if (!f.exists()) {
            System.err.println("File not exist");
            return;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            while (br.ready()) {
                String line = br.readLine();
                String[] arr = line.split(",");
                String code, supplier, descriptions;
                code = arr[0].trim().toUpperCase();
                supplier = arr[1].trim();
                descriptions = arr[2].trim();

                Laptop l = new Laptop(code, supplier, descriptions);
                laptopList.put(code, l);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LaptopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LaptopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
