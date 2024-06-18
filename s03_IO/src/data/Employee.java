/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Employee implements Serializable { //implements Serializable để có thể ghi Object vô file

    public String id, name, position;
    public float salary;

    public Employee() {

    }

    public Employee(String id, String name, String position, float salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        Pattern p;
        Matcher m;
//id
        //id: EXX: bat dau la chu E, tiep theo la 2 so
        p = Pattern.compile("E\\d{2}");
        while (true) {
            System.out.println("Enter id (EXX):");
            id = sc.nextLine().trim().toUpperCase();
            m = p.matcher(id);
            if (m.matches()) {
                break;
            } else {
                System.out.println("Wrong ID format!");
            }
        }
//name
        p = Pattern.compile("[A-Z][a-z]{0,}\\s[A-Z][a-z]{0,}");
        while (true) {
            System.out.println("Enter name: ");
            name = sc.nextLine().trim();
            m = p.matcher(name);
            if (m.matches()) {
                break;
            } else {
                System.out.println("Wrong name format, chữ cái đầu in hoa, ít nhất 3 ký tự, không chứa ký tự đặc biệt");
            }
        }
//position
        p = Pattern.compile("CEO|CTO|Dev|Tester", Pattern.CASE_INSENSITIVE);
        while (true) {
            System.out.println("Enter position: ");
            position = sc.nextLine().trim().toUpperCase();
            m = p.matcher(position);
            if (m.matches()) {
                break;
            } else {
                System.out.println("Position only is CEO|CTO|Dev|Tester");
            }
        }
//salary
//sc.nextLine();
        while (true) {
            try {
                System.out.println("Enter salary: ");
                salary = Float.parseFloat(sc.nextLine().trim());
                if (salary > 0) {
                    break;
                } else {
                    System.out.println("Salary must be greater than zero!");
                }

            } catch (NumberFormatException e) {
                System.err.println("Error: Only enter number");
            }
        }
    }

//    @Override
//    public String toString() {
////        return "id: " + id
////                + "\nname: " + name
////                + "\nposition: " + position
////                + "\nsalary: " + salary;
////        System.out.println("-----");
//        return String.format("%s, %s, %s, %.2f", id, name, position, salary);
//    }
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %.2f", id, name, position, salary);
    }
}
