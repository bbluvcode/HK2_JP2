/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class EmployeeList {

    ArrayList<Employee> emList = new ArrayList<>();
    String fname = "employees.txt";

    public EmployeeList() {
        readfile();
    }

    public boolean isEmptyList() {
        if (emList.isEmpty()) {
            System.err.println("No employee added yet");
        }
        return emList.isEmpty();
    }

    public void displayEmployeeList() {
        for (Employee e : emList) {
            System.out.println("-----");
            System.out.println(e.printInfo());;
        }
    }

    public void displayEmployee(String id) {

        //id not duplicate
        Employee emp = emList.stream().filter(e -> e.id.equalsIgnoreCase(id)).findFirst().orElse(null);
        if (emp == null) {
            System.err.println("Cannot found any employee id " + id);
            return;
        }
        System.out.println("Result search:" + emp.printInfo());

        //id cho phep trung
//        List<Employee> searchList = emList.stream().filter(e -> e.id.equalsIgnoreCase(id)).collect(Collectors.toList());
//        if (searchList.isEmpty()) {
//            System.err.println("Cannot find any employee!");
//            return;
//        }
//        for (Employee e : searchList) {
//            System.out.println("-----");
//            e.printInfo();
//        }
    }

    public void addNew(Employee e) {
        Employee emp = emList.stream().filter(em -> em.id.equalsIgnoreCase(e.id)).findFirst().orElse(null);
        if (emp != null) {
            System.err.println("Employee ID exist");
            return;
        }

        emList.add(e);
        System.out.println("Add new employee successfully!");
    }

    public void save() {
        if (isEmptyList()) {
            System.err.println("Cannot save to file!");
            return;
        }

        try {
            PrintWriter pw = new PrintWriter(fname);

            emList.forEach(e -> pw.println(e.toString()));
            pw.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot save to file!");
        }

    }

    public void readfile() {
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
                String id, name, email;
                boolean gender;
                id = arr[0].trim();
                name = arr[1].trim();
                email = arr[2].trim();
                gender = "Male".equals(arr[3].trim());

                Employee e = new Employee(id, name, email, gender);
                emList.add(e);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.err.println("cannot find file");
        } catch (IOException ex) {
            System.err.println("Error ready() method");
        }

    }

    public void menu() {
        Scanner sc = new Scanner(System.in);

        Employee e = new Employee();

        int choice = 998;
        do {
            System.out.println("----------MENU-------------");
            System.out.println("1. Display employee list");
            System.out.println("2. Search employee by id");
            System.out.println("3. Add new employee");
            System.out.println("4. Save file");
            System.out.println("0. Exit");
            System.out.println("----------MENU-------------");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println("Only enter number");
            }
            switch (choice) {
                case 1:
                    System.out.println("1. Display employee list");
                    if (isEmptyList()) {
                        break;
                    }
                    displayEmployeeList();
                    break;
                case 2:
                    System.out.println("2. Search employee by id");
                    if (isEmptyList()) {
                        break;
                    }
                    String s = sc.nextLine().trim().toUpperCase();
                    displayEmployee(s);

                    break;
                case 3:
                    System.out.println("3. Add new employee");
                    e.input();
                    addNew(e);
                    break;
                case 4:
                    System.out.println("4. Save file");
                    save();
                    continue;
//                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.err.println("Choice invalid, try again!");
            }
        } while (choice != 0);

    }
}
