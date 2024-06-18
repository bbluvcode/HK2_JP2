/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import data.Employee;
import data.EmployeeIOText;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class testEmployeeText {

    EmployeeIOText empIO = new EmployeeIOText();

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        testEmployeeText test = new testEmployeeText();
        test.menu();
    }

    void menu() {
        int choice = 0;

        do {
            System.out.println("-----MENU-----");
            System.out.println("1. Add new employee");
            System.out.println("2. Display all employees");
            System.out.println("3. Search employee by name");
            System.out.println("4. Output file (ghi file)");
            System.out.println("5. Open file");
            System.out.println("6. Exit");
            System.out.println("-----");
            System.out.println("Enter your choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("1. Add new employee");
                        add();
                        break;
                    case 2:
                        System.out.println("2. Display all employees");
                        displayAll();
                        break;
                    case 3:
                        System.out.println("3. Search employee by name");
                        if (!isEmptyList()) {
                            String name = sc.nextLine();
                            searchByName(name);
                        }
                        break;
                    case 4:
                        System.out.println("4. Output file (ghi file)");
                        writeFile();
                        break;
                    case 5:
                        System.out.println("5. Exit");
                        break;
                    default:
                        System.err.println("Only choice 1-5. Try again!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Only enter numbers");
            }

        } while (choice != 5);
    }

    boolean isEmptyList() {
        if (empIO.eList.isEmpty()) {
            System.err.println("List is empty!");
        }
        return empIO.eList.isEmpty();
    }

    public void add() {
        Employee e = new Employee();
        e.input();

        empIO.eList.add(e);
        System.out.println("Add new employee sucessfully");
    }

    public void displayAll() {
        if (isEmptyList()) {
            return;
        }

        for (Employee e : empIO.eList) {
            System.out.println(e);
        }
    }

    public void searchByName(String name) {
        List<Employee> list = empIO.eList.stream()
                .filter(e -> e.name.toLowerCase().contains(name.trim().toLowerCase())).collect(Collectors.toList());
        if (list.isEmpty()) {
            System.err.println("Cannot found any employee name " + name);
        } else {
            for (Employee e : list) {
                System.out.println(e);
            }
        }
    }

    public void writeFile() {
        empIO.writeFile();
    }
}
