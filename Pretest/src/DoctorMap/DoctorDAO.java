/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoctorMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DoctorDAO {

    HashMap<String, Doctor> docDAO = new HashMap<>();
    String fname = "DoctorList.txt";

    public DoctorDAO() {
        readFile();
    }

    public boolean isEmtyList() {
        if (docDAO.isEmpty()) {
            System.err.println("No doctor added yet!");
        }
        return docDAO.isEmpty();
    }

    public void add() {
        Doctor d = new Doctor();
        d.input();

        docDAO.put(d.id, d);
        System.out.println("Doctor added successfully!");
    }

    public void searchDoc(String id) {
        if (isEmtyList()) {
            return;
        }
        if (!docDAO.containsKey(id)) {
            System.err.println("Cannot find any doctor id " + id);
            return;
        } else {
            System.out.println(docDAO.get(id).toString());
        }
//        Doctor searchDoc = docDAO.values().stream().filter(d -> d.id.equals(id)).findFirst().orElse(null);
//        System.out.println();

    }

    public void display() {
        if (isEmtyList()) {
            return;
        }

        for (Doctor d : docDAO.values()) {
            System.out.println(d.toString());
        }
    }

    public void saveFile() {
        if (isEmtyList()) {
            return;
        }

        try {
            PrintWriter pw = new PrintWriter(fname);

            docDAO.values().forEach(d -> pw.println(d.toString()));
            pw.close();
            System.out.println("Write list to file successfully!");
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot save file!");
        }

    }

    void readFile() {
        File f = new File(fname);
        if (!f.exists()) {
            System.out.println("File not exist");
            return;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            while (br.ready()) {
                String line = br.readLine();

                String[] arr = line.split(",");
                String id = arr[0].trim();
                String name = arr[1].trim();
                String spe = arr[2].trim();
                int hrs = Integer.parseInt(arr[3].trim());

                Doctor d = new Doctor(id, name, spe, hrs);

                docDAO.put(id, d);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice = 998;
        do {
            System.out.println("---------MENU---------------");
            System.out.println("1. Add new Doctor");
            System.out.println("2. Search Doctor");
            System.out.println("3. Save file");
            System.out.println("0. Exit");
            System.out.println("---Enter your choice");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Only enter number");
            }
            switch (choice) {
                case 1:
                    System.out.println("1. Add new Doctor");
                    add();
                    break;
                case 2:
                    System.out.println("2. Search Doctor");
                    String id = sc.nextLine().trim().toUpperCase();
                    searchDoc(id);
                    break;
                case 3:
                    System.out.println("3. Save file");
                    saveFile();
                    break;
                case 4:
                    System.out.println("4. Display all");
                    display();
                    break;

                case 0:
                    System.out.println("0. Exit");
                    break;
                default:
                    System.err.println("Wrong choice, please try again");
            }
        } while (choice != 0);
    }
}
