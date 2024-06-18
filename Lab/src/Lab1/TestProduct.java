/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class TestProduct {

    public static void main(String[] args) {
        ProductList t = new ProductList();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("-----Menu-----");
            System.out.println("1. Add new product");
            System.out.println("2. Display all product");
            System.out.println("3. Search product by name");
            System.out.println("4. Exit");
            System.out.println("-----Menu-----");
            System.out.println("Enter your choice: ");
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("1. Add new product");
                        t.addProduct();
                        break;
                    case 2:
                        System.out.println("2. Display all product");
                        t.displayAll();
                        break;
                    case 3:
                        System.out.println("3. Search product by name");
                        if (!t.isListEmpty()) {
                            System.out.println("Enter name search: ");
                            sc.nextLine();
                            String name = sc.nextLine().trim().toLowerCase();
                            t.searchByName(name);
                        }
                        break;
                    case 4:
                        System.out.println("4. Exit");
                        break;

                    default:
                        System.out.println("Wrong choice, do again!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Chỉ được nhập số");
                sc.nextLine();
            }
        } while (choice != 4);
    }
}
