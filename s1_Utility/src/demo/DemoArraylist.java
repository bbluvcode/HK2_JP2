/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author Admin
 */
public class DemoArraylist {

    public static void main(String[] args) {

        //tao 1 doi tuong co kieu ArrayList
        ArrayList<String> list1 = new ArrayList();

        //them du lieu
        list1.add("Monday");
        list1.add("Tuesday");
        System.out.println(list1);

        list1.add(1, "Wednesday");
        System.out.println("list1.add(1, \"Wednesday\"): " + list1);

        list1.addFirst("Sunday");
        System.out.println("list1.addFirst(\"Sunday\")" + list1);

        list1.addLast("Saturday");
        System.out.println("list1.addLast(\"Saturday\")" + list1);

        //tao 1 doi tuong co kieu ArrayList co 1 tham so kieu Collections
        ArrayList<String> list2 = new ArrayList(list1);

        System.out.println("list2: " + list2);

        //them 1 danh sach vao list 1
        list1.addAll(list2);

        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);

        //retrive
        System.out.println("**---RETRIVE---**");
        //for-each
        System.out.println("---For-each");
        for (String s : list2) {
            System.out.println(s);
        }

        //for thuong
        System.out.println("---For:");
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(i + 1 + ". " + list2.get(i));
        }

        System.out.println("---Iterator: ");
        Iterator iter = list2.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        //up
        System.out.println("**---UPDATE---**");
        list2.set(3, "Friday");
        System.out.println("list2.set(3, \"Friday\")" + list2);

        //delete
        System.out.println("**---DELETE---**");
        list2.remove("Sunday");
        System.out.println(" list2.remove(\"Sunday\"): " + list2);

        list2.remove(3);
        System.out.println("list2.remove(3);" + list2);

        //search
        System.out.println("**---SEARCH---**");
        boolean r = list2.contains("Monday");
        System.out.println("r is " + r);

        //replace - thay the
        System.out.println("**---REPLACE---**");
        System.out.println("---ArrayList.replaceAll: thay đổi kiểu String");
        list2.replaceAll(e -> e.toUpperCase());
        System.out.println("list2.replaceAll(e -> e.toUpperCase()): " + list2);
        
        System.out.println("Collections.replaceAll: thay đổi giá trị");
        Collections.replaceAll(list2, "MONDAY", "friday");
        System.out.println("Collections.replaceAll(list2, \"MONDAY\", \"friday\"): " + list2);

        //sort
        System.out.println("**---SORT---**");
        System.out.println("---Sort a-z:");
        Collections.sort(list1);
        System.out.println("Collections.sort(list1): " + list1);
        
        //reverse
        System.out.println("---Reverse:");
        Collections.reverse(list1);
        System.out.println("Collections.reverse(list1): " + list1);
        
        
        
    }

}
