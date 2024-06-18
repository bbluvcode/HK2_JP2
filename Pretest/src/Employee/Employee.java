/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Employee {

    String id, name, email;
    boolean gender;

    public Employee() {
    }

    public Employee(String id, String name, String email, boolean gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getGenderAsString() {
        return gender ? "Male" : "Female";
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", id, name, email, getGenderAsString());
    }

    public String printInfo() {
        return String.format("ID: %s, Name: %s, Email: %s, Gender: %s", id, name, email, getGenderAsString());
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        Pattern p;
        Matcher m;

        p = Pattern.compile("E\\d{3}-\\d{2}");
        while (true) {
            System.out.print("Enter id Exxx-xx: ");
            id = sc.nextLine().trim().toUpperCase();
            m = p.matcher(id);
            if (m.matches()) {
                break;
            } else {
                System.err.println("ID format wrong, try again!");
            }
        }
        while (true) {
            System.out.print("Enter name: ");
            name = sc.nextLine();
            if (name.isBlank()) {
                System.err.println("Cannot blank!");
            } else {
                break;
            }
        }

        p = Pattern.compile("[^@]+@[^@]+\\.[^@]+");
        while (true) {
            System.out.print("Enter email: ");
            email = sc.nextLine().trim().toLowerCase();
            m = p.matcher(email);
            if (m.matches()) {
                break;
            } else {
                System.err.println("Email format invalid, try again!");
            }
        }

        while (true) {
            try {
                System.out.println("Enter gender (1-Male, 2-Female): ");
                int tmp = Integer.parseInt(sc.nextLine());
                if (tmp == 1) {
                    gender = true;
                    break;
                } else if (tmp == 2) {
                    gender = false;
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.err.println("Only enter a 1 or 2");
            }

        }
    }

}
