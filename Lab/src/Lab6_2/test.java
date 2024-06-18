/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab6_2;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class test {

    Employee e = new Employee();
    EmployeeDAO eDAO = new EmployeeDAO();

    public static void main(String[] args) {
        test t = new test();
        t.menu();
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);

        int choice = 998;
        do {
            System.out.println("-------MENU----------");
            System.out.println("1. Add new Employee");
            System.out.println("2. Edit employee");
            System.out.println("3. Delete employee");
            System.out.println("4. Display all employee");
            System.out.println("5. Display employee by name");
            System.out.println("0. Exit");
            System.out.print("---Enter your choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Only enter number");
            }
            switch (choice) {
                case 1:
                    System.out.println("1. Add new Employee");
                    e.input();
                    eDAO.insert(e);
                    break;
                case 2:
                    System.out.println("2. Edit employee");
                    e.input();
                    eDAO.update(e);
                    break;
                case 3:
                    System.out.println("3. Delete employee");
                    String id = sc.nextLine().trim().toLowerCase();
                    eDAO.delete(id);
                    break;
                case 4:
                    System.out.println("4. Display all employee");
                    eDAO.getList();
                    break;
                case 5:
                    System.out.println("5. Display employee by name");
                    System.out.print("Enter name to search:");
                    String name = sc.nextLine().trim();
                    eDAO.getList(name);
                    break;
                case 0:
                    System.out.println("0. Exit");
                    break;
                default:
                    System.out.println("Wrong choice, try again!");
                    break;
            }

        } while (choice != 0);
    }
}
