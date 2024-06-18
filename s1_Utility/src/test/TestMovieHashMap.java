/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import data.CompareName;
import data.Movie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class TestMovieHashMap {

    Scanner sc = new Scanner(System.in);
    HashMap<String, Movie> movieMap = new HashMap();

    public static void main(String[] args) {
        TestMovieHashMap t = new TestMovieHashMap();

        t.menu();
    }

    void menu() {
        int choice = 0;

        do {
            System.out.println("-----MENU-----");
            System.out.println("1. Thêm phim");
            System.out.println("2. Liệt kê tất cả phim");
            System.out.println("3. Tìm phim theo tên");
            System.out.println("4. Xóa phim theo id");
            System.out.println("5. Tìm kiếm theo year");
            System.out.println("6. Sắp xếp theo id");
            System.out.println("7. Sắp xếp theo year");
            System.out.println("8. Sắp xếp theo name");
            System.out.println("9. Sắp xếp theo rating");
            System.out.println("10. Thoát chương trình");
            System.out.println("-----MENU-----");
            System.out.println("Nhập lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
//                continue;
            } finally {
                switch (choice) {
                    case 1:
                        System.out.println("1. Thêm phim");
//                        add();
                        break;
                    case 2:
                        System.out.println("2. Liệt kê tất cả phim");
//                        displayAll();
                        break;
                    case 3:
                        System.out.println("3. Tìm phim theo tên");
//                        searchByName();
                        break;
                    case 4:
                        System.out.println("4. Xóa phim theo id");
//                        removeByID();
                        break;
                    case 5:
                        System.out.println("5. Tìm kiếm theo year");
//                        searchByYear();
                        break;
                    case 6:
                        System.out.println("6. Sắp xếp theo id");
//                        sortByID();
                        break;
                    case 7:
                        System.out.println("7. Sắp xếp theo year");
//                        sortByYear();
                        break;
                    case 8:
                        System.out.println("8. Sắp xếp theo name");
                        sortByName();
                        break;
                    case 9:
                        System.out.println("9. Sắp xếp theo rating");
//                        sortByRating();
                        break;
                    case 10:
                        System.out.println("10. Thoát chương trình");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ, hãy thử lại!");
                        break;
                }
            }
        } while (choice != 10);
    }

    void addMovie() {
        Movie m = new Movie();

        m.input();

        //them vao ds
        movieMap.put(m.id, m);
        System.out.println("Da them phim thanh cong");
    }

    void displayAll() {
        if (movieMap.isEmpty()) {
            System.out.println("Ds chua co du lieu");
            return;
        }
        for (Movie m : movieMap.values()) {
            m.output();
        }
    }

    void searchByName() {
        if (movieMap.isEmpty()) {
            System.out.println("Ds chua co du lieu");
            return;
        }

        System.out.println("Nhap ten phim can tim: ");
        String pName = sc.nextLine().trim();

        List<Movie> searchList = movieMap.values().stream()
                .filter(m -> m.name.toLowerCase().contains(pName.toLowerCase())).collect(Collectors.toList());
        if (searchList.isEmpty()) {
            System.out.println("Ko tim thay phim co ten: " + pName);
        } else {
            for (Movie m : searchList) {
                m.output();
            }
        }
    }

    void removeById() {
        if (movieMap.isEmpty()) {
            System.out.println("Ds chua co du lieu");
            return;
        }

        System.out.println("Nhap ma id can xoa: ");
        String pId = sc.nextLine();

        Movie mo = movieMap.values().stream().filter(m -> m.id.equals(pId)).findFirst().orElse(null);

        if (mo == null) {
            System.out.println("Ko tim thay ma " + pId + "de xoa");

        } else {
            movieMap.remove(mo.id);
        }
    }

    void searByYear() {

        if (movieMap.isEmpty()) {
            System.out.println("Ds chua co du lieu");
            return;
        }

        try {
            System.out.println("Nhap nam can tim: ");
            int pYear = Integer.parseInt(sc.nextLine().trim());

            List<Movie> searchList = movieMap.values().stream().filter(m -> m.year == pYear).collect(Collectors.toList());
            if (searchList.isEmpty()) {
                System.out.println("Ko tim thay phim year " + pYear);
            } else {
                for (Movie m : searchList) {
                    m.output();
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Nam phai nhap so");
        }
    }

    void sortById() {
        TreeMap<String, Movie> tree = new TreeMap(movieMap);

        for (Movie m : tree.values()) {
            m.output();
        }
    }

    void sortByName() {
        ArrayList<Movie> list = new ArrayList(movieMap.values());

        CompareName c = new CompareName();
        Collections.sort(list, c);
    }
}
