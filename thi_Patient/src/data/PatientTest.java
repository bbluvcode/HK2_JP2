/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class PatientTest {
    public static void main(String[] args) {
        PatientManage pm = new PatientManage();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("------------------MENU------------------");
            System.out.println("1. Add new patient");
            System.out.println("2. Find one patient");
            System.out.println("3. Save patient list");
            System.out.println("4. Exit !");
            System.out.println("------------------MENU------------------");
            System.out.print("Enter your choice[1-4]: ");
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Error: Choice must be digit !");
            }
            switch (choice) {
                case 1:
                    System.out.println("1. Add new patient");
                    Patient p = new Patient();
                    p.accept();
                    pm.addPatient(p);
                    break;
                case 2:
                    System.out.println("2. Find one patient");
                    System.out.print("Enter id: ");
                    String id = sc.nextLine().trim();
                    pm.findOne(id);
                    break;
                case 3:
                    System.out.println("3. Save patient list");
                    pm.saveFile();
                    break;              
                case 4:
                    System.out.println("4. Exit");
                    pm.openFile();
                    break;
                default:
                    System.out.println("Enter wrong! Enter choice again[1-4] !");
                    break;
            }
        } while (choice != 4);      
    }
}
