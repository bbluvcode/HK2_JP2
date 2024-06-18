/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 *
 * @author Admin
 */
public class DemoSet {

    //Set thì không cho phép các phần tử giống nhau
    public static void main(String[] args) {
        //tạo 1 đối tượng có kiểu HashSet
        HashSet<String> hash1 = new HashSet();

        hash1.add("Đông");
        hash1.add("Tây");
        hash1.add("Nam");
        hash1.add("Bắc");
        System.out.println("hash1: " + hash1);
        hash1.addAll(hash1);
        System.out.println("hash1: " + hash1);

        //retrieve
        System.out.println("**--RETRIVE--**");
        for (String s : hash1) {
            System.out.println(s);
        }

        //update: không có
        //delete
        System.out.println("**--DELETE--**");
        hash1.remove("Bắc");
        System.out.println("hash1: " + hash1);

        //search
        System.out.println("**--SEARCH--**");
        boolean r = hash1.contains("Đông");
        System.out.println("r is " + r);

        //treeSet: thứ tự lưu theo A-Z
        System.out.println("--**--TreeSet--**--");
        System.out.println("giống Set, hashmap, chỉ khác là theo thứ tự");
        TreeSet<String> tree = new TreeSet();
        tree.add("Đông");
        tree.add("Tây");
        tree.add("Nam");
        tree.add("Bắc");
        System.out.println("tree: " + tree);

        //LinkedHashSet: giữ nguyên thứ tự thêm vào
        System.out.println("--**--LinkedHashSet--**--");
        System.out.println("giữ nguyên thứ tự thêm vào");
        LinkedList<String> link = new LinkedList();
        link.add("Đông");
        link.add("Tây");
        link.add("Nam");
        link.add("Bắc");
        System.out.println("link: " + link);

    }
}
