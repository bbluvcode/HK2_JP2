/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class MethodGeneric {

    public void display(String[] list, String title) {
        System.out.println("display 1: " + title);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public void display(Integer[] list, String title) {
        System.out.println("display 2: " + title);
        for (int n : list) {
            System.out.println(n);
        }

    }

    //generic method
    public <T> void show(T[] list, String title) {
        System.out.println("display generic: " + title);
        for (T t : list) {
            System.out.println(t);
        }
    }

}
