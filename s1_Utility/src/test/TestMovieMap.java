/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import data.CompareName;
//import data.CompareRating;
import data.CompareYear;
import data.Movie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author User
 */
public class TestMovieMap {
    
    HashMap<String, Movie> movieMap = new HashMap();
    Scanner sc = new Scanner(System.in);
    void menu() {
        int choice = 0;
        do {
            System.out.println("--------------------MENU--------------------");
            System.out.println("1. Them phim");
            System.out.println("2. Liet ke tat ca cac phim");
            System.out.println("3. Tim kiem phim theo ten");
            System.out.println("4. Xoa phim theo ID");
            System.out.println("5. Tim kiem theo year");
            System.out.println("6. Sap xep theo ID");
            System.out.println("7. Sap xep theo name");
            System.out.println("8. Sap xep theo year");
            System.out.println("9. Sap xep theo rating");
            System.out.println("10. Thoat chuong trinh");
            System.out.println("--------------------MENU--------------------");
            System.out.print("Nhap lua chon: ");
            try {
                choice = Integer.parseInt(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println("Choice must be digit !");
            }
            switch (choice) {
                case 1:
                    System.out.println("1. Them phim");
                    addMovie();
                    break;
                case 2:
                    System.out.println("2. Liet ke tat ca cac phim");
                    displayAll();
                    break;
                case 3:
                    System.out.println("3. Tim kiem phim theo ten");
                    System.out.print("Nhap ten phim can tim: ");
                    String nameM = sc.nextLine().trim();
                    searchByName(nameM);
                    break;
                case 4:
                    System.out.println("4. Xoa phim theo ID");
                    System.out.print("Nhap ID can xoa: ");
                    String mid = sc.nextLine().trim();
                    removeByID(mid);
                    break;
                case 5:
                    System.out.println("5. Tim kiem theo year");
                    System.out.print("Nhap Year: ");
                    int yearM = 0;
                    try {
                        yearM = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Year must be digit !");
                    }
                    searchByYear(yearM);
                    break;
                case 6:
                    System.out.println("6. Sap xep theo ID");
                    sortByID();
                    break;
                case 7:
                    System.out.println("7. Sap xep theo name");
                    sortByName();
                    break;
                case 8:
                    System.out.println("8. Sap xep theo year");
                    sortByYear();
                    break;
                case 9:
                    System.out.println("9. Sap xep theo Rating");
                    sortByRating();
                    break;
                case 10:
                    System.out.println("10. Thoat chuong trinh !");
                    break;
                default:
                    System.out.println("Choice [1-10]: Nhap lai");
                    break;
            }
        } while (choice != 10);
    }
    public void addMovie() {
        Movie m = new Movie();
        m.input();
        movieMap.put(m.id, m);
        System.out.println("Add movie success !");       
    }

    public void displayAll() {
        if (movieMap.isEmpty()) {
            System.out.println("List movie is empty !");
            return;
        }
        System.out.println("------------------List of Movie------------------");
        for (Movie m : movieMap.values()) {
            m.output();
        }
    }

    public void searchByYear(int yearM) {
        if (movieMap.isEmpty()) {
            System.out.println("List movie is empty !");
            return;
        }
        //khong co tham so thi lam het trong phan try{.......}
        List<Movie> searchList = movieMap.values().stream().filter(m -> m.year == yearM).collect(Collectors.toList());
        if (searchList.isEmpty()) {
            System.out.println("Not found movie have Year: " + yearM);
        } else {
            for (Movie m : searchList) {
                m.output();
            }
        }
    }

    public void searchByName(String nameM) {
        if (movieMap.isEmpty()) {
            System.out.println("List movie is empty !");
            return;
        }
        List<Movie> searchList = movieMap.values().stream().filter(m -> m.name.toLowerCase().contains(nameM.toLowerCase()))
                .collect(Collectors.toList());
        if (searchList.isEmpty()) {
            System.out.println("Not found movie contains Name: " + nameM);
        } else {
            for (Movie m : searchList) {
                m.output();
            }
        }
    }

    public void removeByID(String mid) {
        if (movieMap.isEmpty()) {
            System.out.println("List movie is empty !");
            return;
        }
        Movie mo = movieMap.values().stream().filter(m -> m.id.equals(mid)).findFirst().orElse(null);
        if (mo == null) {
            System.out.println("Not found movie have ID: " + mid);
        } else {
            movieMap.remove(mo.id);
            System.out.println("Remove movie success !");
        }
    }

    public void sortByID() {
        if (movieMap.isEmpty()) {
            System.out.println("List movie is empty !");
            return;
        }
//        TreeSet<Movie> tree = new TreeSet<>(movieMap);
        List<Movie> list = new ArrayList(movieMap.values());
        Collections.sort(list);
        System.out.println("------------------List of Movie------------------");
        for (Movie m : list) {
            m.output();
        }
    }

    public void sortByName() {
        if (movieMap.isEmpty()) {
            System.out.println("List movie is empty !");
            return;
        }
        List<Movie> list = new ArrayList(movieMap.values());
        Collections.sort(list, new CompareName());
        System.out.println("------------------List of Movie------------------");
        for (Movie m : list) {
            m.output();
        }        
    }

    public void sortByYear() {
        if (movieMap.isEmpty()) {
            System.out.println("List movie is empty !");
            return;
        }
        ArrayList<Movie> list = new ArrayList(movieMap.values());
        Collections.sort(list, new CompareYear());
        System.out.println("------------------List of Movie------------------");
        for (Movie m : list) {
            m.output();
        }
    }

    public void sortByRating() {
//        if (movieMap.isEmpty()) {
//            System.out.println("List movie is empty !");
//            return;
//        }
//        List<Movie> list = new ArrayList(movieMap.values());
//        Collections.sort(list, new CompareRating());
//        System.out.println("------------------List of Movie------------------");
//        for (Movie m : list) {
//            m.output();
//        }
    }
    public static void main(String[] args) {
        TestMovieMap t = new TestMovieMap();
        t.menu();
    }
}
