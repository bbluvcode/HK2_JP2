/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Movie implements Comparable<Movie> {

    public String id, name;
    public int year;
    public float rating;

    //constructor ko co tham so
    public Movie() {
    }

    //constructor co tham so, parameter constructer
    public Movie(String id, String name, int year, float rating) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rating = rating;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        //id: MXX[XX] : M01,M02,M110,M1111: Chữ cái đầu tiên là chữ M, sau đó là 2 tói 4 ký tự số
        Pattern p;
        Matcher m;

        p = Pattern.compile("M\\d{2,4}");
        while (true) {
            System.out.println("Enter id MXX[XX]: ");
            id = sc.nextLine();

            m = p.matcher(id);

            if (m.matches()) {
                break;
            } else {
                System.out.println("ID chưa đúng định dạng!");
            }
        }

        //name: bắt đầu là chữ cái viết hoa
        //tiếp theo là bất kỳ ký tự nào , kể cả khoảng trống, không bao gồm ký tự đặc biệt
        p = Pattern.compile("[A-Z][\\w\\s]{2,}");
        while (true) {
            System.out.println("Enter name: ");
            name = sc.nextLine();

            m = p.matcher(name);

            if (m.matches()) {
                break;
            } else {
                System.out.println("Name không đúng định dạng!");
            }

        }

        while (true) {
            try {
                System.out.println("Nhap year tu 1970 den nay: ");
                year = Integer.parseInt(sc.nextLine().trim());

                if (year > 1970 && year < LocalDate.now().getYear()) {
                    break;
                } else {
                    throw new Exception("Year phải từ 1970 đến nay!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Year phải là số!");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

        while (true) {
            try {
                System.out.println("Nhập rating: ");
                rating = Float.parseFloat(sc.nextLine().trim());

                if (rating > 0 && rating <= 10) {
                    break;
                } else {
                    System.out.println("Rating [0-10]!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Rating phải nhập số");
            }
        }
    }

    public void output() {
        System.out.println("ID: " + id);
        System.out.println("Name : " + name);
        System.out.println("Year : " + year);
        System.out.println("Rating : " + rating);
    }

    @Override
    public int compareTo(Movie o) {
        return this.id.compareTo(o.id);
    }

    //muon so sanh 2 Movie có trùng nhau hay không thi phai thuc thi lai equals() va hashCode()
    @Override
    public boolean equals(Object obj) {
        Movie mo = (Movie) obj;
        return this.id.equals(mo.id);
    }

    @Override
    public int hashCode() {
        return 998; //trả 
    }

}
