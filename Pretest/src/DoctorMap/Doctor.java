/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoctorMap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Doctor {

    public String id, name, speciality;
    public int hourExam;

    public Doctor() {
    }

    public Doctor(String id, String name, String speciality, int hourExam) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.hourExam = hourExam;
    }
    
    

    public void input() {
        Scanner sc = new Scanner(System.in);
        Pattern p;
        Matcher m;

        p = Pattern.compile("B\\d{4}");
        while (true) {
            try {
                System.out.println("Enter doctor id:");
                id = sc.nextLine().trim().toUpperCase();
                m = p.matcher(id);
                if (!m.matches()) {
                    throw new Exception("ID must be B[XXXX]");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println("Enter doctor name:");
            name = sc.nextLine();
            if (name.isEmpty()) {
                System.err.println("Cannot blank!");
            } else {
                break;
            }
        }
        while (true) {
            System.out.println("Enter doctor speciality:");
            speciality = sc.nextLine();
            if (speciality.isEmpty()) {
                System.err.println("Cannot blank!");
            } else {
                break;
            }
        }
        while (true) {
            try {
                System.out.println("Enter hourExam:");
                hourExam = Integer.parseInt(sc.nextLine());
                if (hourExam > 0) {
                    break;
                } else {
                    System.err.println("hourExam must be greater than 0");
                }
            } catch (NumberFormatException e) {
                System.err.println("Only enter number");
            }
        }

    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %d", id, name, speciality, hourExam);
    }

}
