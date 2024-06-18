/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Student;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Student {

    public String name, address, email;

    public Student() {
    }

    public Student(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public void input() {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter name: ");
            name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.err.println("Cannot empty, try again!");
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Enter address: ");
            address = sc.nextLine().trim();
            if (address.isEmpty()) {
                System.err.println("Cannot empty, try again!");
            } else {
                break;
            }
        }

        Pattern p;
        Matcher m;

        p = Pattern.compile("[^@]+@[^@]+\\.[^@]+");
        while (true) {
            System.out.println("Enter email: ");
            email = sc.nextLine().trim().toLowerCase();
            m = p.matcher(email);
            if (email.isEmpty()) {
                System.err.println("Cannot empty, try again!");
            } else if (!m.matches()) {
                System.err.println("Email format wrong!");
            } else {
                break;
            }
        }
    }
}
