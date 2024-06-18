/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import data.Movie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class TestMovieHashSet {

    Scanner sc = new Scanner(System.in);

    //khai bao 1 ds chua nhieu Movie kieu Hashset
    HashSet<Movie> movieHashsetList = new HashSet();

    public static void main(String[] args) {
        TestMovieHashSet test = new TestMovieHashSet();
        test.menu();
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
                        add();
                        break;
                    case 2:
                        System.out.println("2. Liệt kê tất cả phim");
                        displayAll();
                        break;
                    case 3:
                        System.out.println("3. Tìm phim theo tên");
                        searchByName();
                        break;
                    case 4:
                        System.out.println("4. Xóa phim theo id");
                        removeByID();
                        break;
                    case 5:
                        System.out.println("5. Tìm kiếm theo year");
                        searchByYear();
                        break;
                    case 6:
                        System.out.println("6. Sắp xếp theo id");
                        sortByID();
                        break;
                    case 7:
                        System.out.println("7. Sắp xếp theo year");
                        sortByYear();
                        break;
                    case 8:
                        System.out.println("8. Sắp xếp theo name");
                        sortByName();
                        break;
                    case 9:
                        System.out.println("9. Sắp xếp theo rating");
                        sortByRating();
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

    public boolean isEmptyList() {
        if (movieHashsetList.isEmpty()) {
            System.out.println("Danh sách chưa có dữ liệu");
            return true;
        }
        return false;
    }

    public void add() {
        Movie mv = new Movie();
        mv.input();
        boolean r = movieHashsetList.add(mv);
        if (r) {
            System.out.println("Thêm phim thành công");
        } else {
            System.out.println("Trùng ID, ko thể thêm phim!");
        }
    }

    public void displayAll() {
        if (isEmptyList()) {
            return;
        }
        for (Movie m : movieHashsetList) {
            System.out.println("-----");
            m.output();
        }
    }

    public void searchByName() {
        if (isEmptyList()) {
            return;
        }

        System.out.println("Nhập tên phim cần tìm: ");
        String pname = sc.nextLine().trim();

        List<Movie> searchList = movieHashsetList.stream()
                .filter(m -> m.name.toLowerCase().contains(pname))
                .collect(Collectors.toList());

        if (searchList.isEmpty()) {
            System.out.println("Không tìm thấy phim có tên " + pname);
        } else {
            for (Movie m : searchList) {
                System.out.println("-----");
                m.output();
            }
        }
    }

    public void removeByID() {
        if (isEmptyList()) {
            return;
        }
        System.out.println("Nhập id cần xóa: ");
        String pID = sc.nextLine().trim();

        Movie mo;
        mo = movieHashsetList.stream().filter(m -> m.id.equals(pID)).findFirst().orElse(null);

        if (mo == null) {
            System.out.println("không tìm thấy film có id là : " + pID);
        } else {
            movieHashsetList.remove(mo);
            System.out.println("Đã xóa phim thành công!");
        }
    }

    public void searchByYear() {
        if (isEmptyList()) {
            return;
        }

        while (true) {
            try {
                System.out.println("Nhập năm cần tìm: ");
                int pyear = Integer.parseInt(sc.nextLine().trim());
                List<Movie> searchList = movieHashsetList.stream().filter(m -> m.year == pyear).collect(Collectors.toList());
                if (searchList.isEmpty()) {
                    System.out.println("không tìm thấy phim năm " + pyear);
                } else {
                    for (Movie m : movieHashsetList) {
                        System.out.println("-----");
                        m.output();
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Year phải là số!");
            }
        }

    }

    public void sortByID() {
        if (isEmptyList()) {
            return;
        }
//Cach 1:
        ArrayList<Movie> sortList = new ArrayList(movieHashsetList);
        Collections.sort(sortList);
//Cach 2:
//        TreeSet<Movie> tree = new TreeSet(movieHashsetList); //vi da co compareTo, nếu ko có thì phải tạo

        displayAll();

    }

    public void sortByName() {
        if (isEmptyList()) {
            return;
        }

//        Collections.sort(movieHashsetList, new Comparator<Movie>() {
//            @Override
//            public int compare(Movie o1, Movie o2) {
//                return o1.name.compareTo(o2.name);
//            }
//        });
        displayAll();
    }

    public void sortByYear() {
        if (isEmptyList()) {
            return;
        }

//        CompareYear c = new CompareYear();
//        Collections.sort(movieHashsetList, c);
        displayAll();
    }

    public void sortByRating() {
        if (isEmptyList()) {
            return;
        }

//        Collections.sort(movieHashsetList, new Comparator<Movie>() {
//            @Override
//            public int compare(Movie o1, Movie o2) {
//                return o1.rating < o2.rating ? -1 : o1.rating > o2.rating ? 1 : 0;
//            }
//        });
        displayAll();
    }

}
