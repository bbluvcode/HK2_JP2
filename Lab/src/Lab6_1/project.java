/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab6_1;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class project {

    public int id, value;
    public String projectName, startDate;
    public boolean completed = false;

    public project() {
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter project name: ");
                projectName = sc.nextLine();
                if (projectName.isEmpty()) {
                    throw new Exception("Cannot blank");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        int y, m, d;
        System.out.println("Startdate:");
        while (true) {
            try {
                System.out.println("Enter year:");
                y = Integer.parseInt(sc.nextLine());
                if (y > 1900 && y < LocalDate.now().getYear()) {
                    break;
                } else {
                    System.err.println("Year must be 1900 - now");
                }
            } catch (NumberFormatException e) {
                System.err.println("Only enter number!");
            }
        }
        while (true) {
            try {
                System.out.println("Enter month:");
                m = Integer.parseInt(sc.nextLine());

                if (y == LocalDate.now().getYear() && m <= LocalDate.now().getMonthValue()) {

                    break;
                } else if (y < LocalDate.now().getYear() && m >= 1 && m <= 12) {
                    break;
                } else {
                    System.err.println("Month must be 1 - 12");
                }
            } catch (NumberFormatException e) {
                System.err.println("Only enter number!");
            }
        }
        while (true) {
            try {
                System.out.println("Enter day:");
                d = Integer.parseInt(sc.nextLine());
                if (y == LocalDate.now().getYear() && m == LocalDate.now().getMonthValue() && d >= 1 && d <= LocalDate.now().getDayOfMonth()) {
                    break;
                } else if ((y < LocalDate.now().getYear() | m < LocalDate.now().getMonthValue()) && d >= 1 && d <= LocalDate.now().getDayOfMonth()) {
                    break;
                } else {
                    System.err.println("Day invalid");
                }
            } catch (NumberFormatException e) {
                System.err.println("Only enter number!");
            }
        }

        startDate = y + "-" + m + "-" + d;
        while (true) {
            try {
                System.out.println("Enter value:");
                value = Integer.parseInt(sc.nextLine());
                if (value > 0) {
                    break;
                } else {
                    System.err.println("Cannot blank and must be greater than 0");
                }
            } catch (NumberFormatException e) {
                System.err.println("Only enter Number!");
            }
        }

        while (true) {
            try {
                int tmp;
                System.out.println("Enter complete 1-true, 0-false:");
                tmp = Integer.parseInt(sc.nextLine());
                if (tmp == 1) {
                    completed = true;
                    break;
                } else if (tmp == 0) {
                    completed = false;
                    break;
                } else {
                    System.err.println("Must be enter 1 or 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Must be enter 1 or 0");
            }
        }

    }

}
