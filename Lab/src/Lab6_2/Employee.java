/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab6_2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Employee {

    String id, fullname;
    boolean gender;
    int salary;

    public Employee() {
    }

    public Employee(String id, String fullname, boolean gender, int salary) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
        this.salary = salary;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        Pattern p;
        Matcher m;

        p = Pattern.compile("E\\d{2,}");
        while (true) {
            try {
                System.out.println("Enter ID (EXX[XX]): ");
                id = sc.nextLine().trim().toUpperCase();
                m = p.matcher(id);
                if (m.matches()) {
                    break;
                } else {
                    throw new Exception("Format is wrong");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Enter fullname: ");
                fullname = sc.nextLine().trim().toUpperCase();
                if (!fullname.isEmpty()) {
                    break;
                } else {
                    throw new Exception("Cannot blank");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Enter gender [male:1,female:0]");
                int tmp = Integer.parseInt(sc.nextLine());
                if (tmp == 1) {
                    gender = true;
                    break;
                } else if (tmp == 0) {
                    gender = false;
                    break;
                } else {
                    throw new Exception("Only enter 1 or 0");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Enter salary (100-10000):");
                salary = Integer.parseInt(sc.nextLine());
                if (salary >= 100 && salary <= 10000) {
                    break;
                } else {
                    throw new Exception("Must be >= 100 and <= 10000");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String toString() {
        return "ID: " + id + "\nFullname:" + fullname + "\nGender" + (gender ? "Nam" : "Nữ") + "\nSalary" + salary;

    }
}
