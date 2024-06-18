/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Product {

    String id, name, mfg;
    int unitPrice, qoh;
    Scanner sc = new Scanner(System.in);

    HashMap<String, String> mfgList = new HashMap();

    public Product() {
        mfgList.put("US", "United State");
        mfgList.put("VN", "Vietnam");
        mfgList.put("TL", "ThaiLand");
    }

    public Product(String id, String name, String mfg, int unitPrice, int qoh) {
        this.id = id;
        this.name = name;
        this.mfg = mfg;
        this.unitPrice = unitPrice;
        this.qoh = qoh;
        mfgList.put("US", "United State");
        mfgList.put("VN", "Vietnam");
        mfgList.put("TL", "ThaiLand");
    }

    void input() {

        Pattern p1, p2;
        Matcher m1, m2;

        p1 = Pattern.compile("F\\d{4}");
        p2 = Pattern.compile("B\\d{4}");

        while (true) {
            try {
                System.out.println("Enter id Fxxxx of Bxxxx: ");
                id = sc.nextLine();

                m1 = p1.matcher(id);
                m2 = p2.matcher(id);

                if (m1.matches() || m2.matches()) {
                    break;
                } else {
                    throw new InvalidException("Sai định dạng. hãy thử lại");
                }
            } catch (InvalidException e) {
                System.out.println(e.getMessage());
            }
        }

        p1 = Pattern.compile("[a-zA-Z]{1}\\w{1,}");
        while (true) {
            try {
                System.out.println("Enter name:");
                name = sc.nextLine();

                m1 = p1.matcher(name);
                if (m1.matches()) {
                    break;
                } else {
                    throw new InvalidException(("Name phải có ít nhất 2 ký tự!"));
                }

            } catch (InvalidException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Enter unit Price: ");
                unitPrice = sc.nextInt();
                if (unitPrice > 0) {
                    break;
                } else {
                    throw new Exception("Unit price must be greater than 0!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Chỉ được nhập số");
                sc.nextLine();
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Enter qoh: ");
                qoh = sc.nextInt();
                if (qoh > 0) {
                    break;
                } else {
                    throw new Exception("QOH must be greater than 0!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Chỉ được nhập số");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        sc.nextLine();
        while (true) {
            try {
                System.out.println("Enter mfg: ");
                mfg = sc.nextLine().toUpperCase();

                if (mfgList.containsKey(mfg)) {
                    break;
                } else {
                    throw new Exception("mfg: US => United State, VN => Vietnam, TL => Thailand");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    String standardlizeMFG() {
        return mfgList.get(mfg);
    }

    @Override
    public String toString() {
        return "id: " + id
                + "\nName: " + name
                + "\nMfg: " + standardlizeMFG()
                + "\nUnitPrice: " + unitPrice
                + "\nQOH: " + qoh;
    }

}
