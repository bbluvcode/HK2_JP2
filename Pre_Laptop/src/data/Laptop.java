/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author User
 */
public class Laptop implements Serializable{
    public String code, supplier, description;

    public Laptop() {
    }

    public Laptop(String code, String supplier, String description) {
        this.code = code;
        this.supplier = supplier;
        this.description = description;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Code: ");
            code = sc.nextLine().trim();
            if (code.isBlank()) {
                System.out.println("Code cannot blank !");
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("Enter Supplier: ");
            supplier = sc.nextLine().trim();
            if (supplier.isBlank()) {
                System.out.println("Supplier cannot blank !");
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("Enter Description: ");
            description = sc.nextLine().trim();
            if (description.isBlank()) {
                System.out.println("Description cannot blank !");
            } else {
                break;
            }
        }
    }
    public void Display(){
        System.out.println("Information of Laptop");
        System.out.println("Code: " +code);
        System.out.println("Supplier: " +supplier);
        System.out.println("Description: " +description);
        System.out.println("");
    }
    public void standardize(){
        Pattern p = Pattern.compile("\\bIBM\\b", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(description);
        description = m.replaceAll("Lenovo");
        
        Pattern p1 = Pattern.compile("\\bCompaq\\b", Pattern.CASE_INSENSITIVE);
        Matcher m1 = p1.matcher(description);
        description = m1.replaceAll("HP Compaq");
    }
    @Override
    public String toString(){
        return String.format("%s, %s, %s", code, supplier, description);
    }
    
}
