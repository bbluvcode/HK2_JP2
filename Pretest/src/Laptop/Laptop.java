/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Laptop;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Laptop implements Comparable<Laptop> {

    public String code, supplier, descriptions;

    public Laptop() {
    }

    public Laptop(String code, String supplier, String descriptions) {
        this.code = code;
        this.supplier = supplier;
        this.descriptions = descriptions;
    }

    public void standardize() {
        // Using regular expression to replace "IBM" or "Compaq" with "Lenovo" or "HP Compaq" respectively
        Pattern p1 = Pattern.compile("\\bIBM\\b", Pattern.CASE_INSENSITIVE);
        Matcher m1 = p1.matcher(descriptions);
        descriptions = m1.replaceAll("Lenovo");

        Pattern p2 = Pattern.compile("\\bCompaq\\b", Pattern.CASE_INSENSITIVE);
        Matcher m2 = p2.matcher(descriptions);
        descriptions = m2.replaceAll("HP Compaq");
    }

    public void display() {
        System.out.println("---");
        System.out.println("Code: " + code);
        System.out.println("Supplier: " + supplier);
        System.out.println("Description: " + descriptions);
        System.out.println("-----");
    }

    @Override
    public int compareTo(Laptop o) {
        return this.code.compareToIgnoreCase(o.code);
    }

    @Override
    public boolean equals(Object obj) {
        Laptop lap = (Laptop) obj;
        return this.code.equals(lap.code);
    }

    @Override
    public int hashCode() {
        return 998;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter code: ");
            code = sc.nextLine().trim().toUpperCase();
            if (code.isEmpty()) {
                System.err.println("Cannot blank");
            } else {
                break;
            }
        }
        while (true) {
            System.out.println("Enter suplier: ");
            supplier = sc.nextLine().trim();
            if (supplier.isEmpty()) {
                System.err.println("Cannot blank");
            } else {
                break;
            }
        }
        while (true) {
            System.out.println("Enter description:");
            descriptions = sc.nextLine().trim();
            if (descriptions.isEmpty()) {
                System.err.println("Cannot blank");
            } else {
                break;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", code, supplier, descriptions);
    }

}
