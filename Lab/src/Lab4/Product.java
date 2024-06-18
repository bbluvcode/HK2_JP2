/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Product implements Serializable{

    String id, name;
    int price;
    float in_qty = 0;
    float out_qty = 0;

    public Product() {
    }

    public Product(String id, String name, int price, float inqty, float outqty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.in_qty = inqty;
        this.out_qty = outqty;
    }

    void input() {
        Scanner sc = new Scanner(System.in);
        Pattern p;
        Matcher m;

        p = Pattern.compile("P\\d{3}");
        while (true) {
            try {
                System.out.print("Enter product ID [Pxxx]: ");
                id = sc.nextLine().trim().toUpperCase();
                m = p.matcher(id);
                if (m.matches()) {
                    break;
                } else {
                    throw new Exception("Wrong, id format is [Pxxx]!");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        while (true) {
            System.out.print("Enter product name: ");
            name = sc.nextLine();
            if (name.isEmpty()) {
                System.err.println("Name cannot blank");
            } else {
                break;
            }
        }

        while (true) {
            try {
                System.out.println("Enter product price: ");
                price = Integer.parseInt(sc.nextLine());
                if (price > 0) {
                    break;
                } else {
                    throw new Exception("Price must be greater than zero!");
                }
            } catch (InputMismatchException e) {
                System.err.println("Only enter numbers!");
                sc.nextLine();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    void output() {
        System.out.printf("%s, %s, %d, %.1f, %.1f", id, name, price, in_qty, out_qty);
        System.out.println("");
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d, %.1f, %.1f", id, name, price, in_qty, out_qty);
    }

}
