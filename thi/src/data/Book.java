package data;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Book {
    public int Id, Edition;
    public String Title, Author;

    public Book() {
    }

    public Book(int Id, int Edition, String Title, String Author) {
        this.Id = Id;
        this.Edition = Edition;
        this.Title = Title;
        this.Author = Author;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Title: ");
            Title = sc.nextLine().trim();
            if (!Title.isBlank()) {
                break;
            } else {
                System.out.println("Title cannot blank !");
            }
        }
        while (true) {
            System.out.print("Enter Author: ");
            Author = sc.nextLine().trim();
            if (!Author.isBlank()) {
                break;
            } else {
                System.out.println("Author cannot blank !");
            }
        }
        while (true) {
            try {
                System.out.print("Enter Edition: ");
                Edition = Integer.parseInt(sc.nextLine().trim());
                if (Edition > 0) {
                    break;
                } else {
                    System.out.println("Edition must be grater than 0 !");
                }
            }catch(NumberFormatException e){
                System.out.println("Edition must be digit !");
            }
        }
    }
    @Override
    public String toString(){
        return "Id: "+Id+", Title: "+Title+", Author: "+Author+", Edition: "+Edition;
    }
//    public static void main(String[] args) {
//        Book b = new Book();
//        b.input();
//        System.out.println(b);
//    }
}
