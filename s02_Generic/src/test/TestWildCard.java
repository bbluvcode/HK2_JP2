/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TestWildCard {
    public static void main(String[] args) {
        List<Number> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(10,20,30);
        List<Float> list3 = Arrays.asList(1.1f,2.2f,3.2f);
        List<String> list4 = Arrays.asList("Dong", "Tay", "Nam", "Bac");
        
        
        print1(list1);
        print1(list2);
        print1(list3);
//        print1(list4); String ko the thua ke number

        print2(list1);
        print2(list2);
//        print2(list3);

        print3(list1);
        print3(list2);
        print3(list3);
        print3(list4);
        
    }
    
    public static void print1(List<? extends Number> list)
    {
        System.out.println("print1");
        System.out.println(list);
    }
    
    public static void print2(List<? super Integer> list)
    {
        System.out.println("prin2");
        System.out.println(list);
    }
    
    public static void print3(List<?> list)
    {
        System.out.println("prin3");
        System.out.println(list);
    }
}
