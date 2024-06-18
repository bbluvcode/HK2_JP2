/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Doctor {

    String id, name, level;
    int exp_years;

    public Doctor() {
    }

    public Doctor(String id, String name, String level, int exp_years) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.exp_years = exp_years;
    }

    void input() {
        Scanner sc = new Scanner(System.in);
        Pattern p;
        Matcher m;

        p = Pattern.compile("D\\d{2,4}");
        while (true) {
            try {
                System.out.println("Enter id : Dxx[xx]: ");
                id = sc.nextLine();
                m = p.matcher(id);
                if (m.matches()) {
                    break;
                } else {
                    throw new Exception("Format is wrong, try again!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        p = Pattern.compile("[a-z\\s]{2,}");
        while (true) {
            try {
                System.out.println("Enter name : ");
                name = sc.nextLine();
                m = p.matcher(name);
                if (m.matches()) {
                    break;
                } else {
                    throw new Exception("Format is wrong, try again!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Enter level : ");
                String levelnum = sc.nextLine();
                switch (levelnum) {
                    case "1":
                        level = "Level 1";
                        break;
                    case "2":
                        level = "Level 2";
                        break;
                    case "3":
                        level = "Level 3";
                        break;
                    case "\n":
                        break;
                    default:
                        throw new Exception("Level 1-3 or null");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        sc.nextLine();
        while (true) {
            try {
                System.out.println("Enter experience year: ");
                exp_years = sc.nextInt();
                if (exp_years > 0 && exp_years <= 60) {
                    break;
                } else {
                    throw new Exception("Exp_year from 1 to 60!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }       

    }
    @Override
    public String toString(){
        return "id : " + id +
        "\nname : " + name +
        "\nlevel : " + level +
        "\nexp_years : " + exp_years;
    }
}
