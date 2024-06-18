/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import java.util.PriorityQueue;

/**
 *
 * @author Admin
 */
public class DemoQueue {

    public static void main(String[] args) {
        
        //mảng hàng đợi
        PriorityQueue<String> q = new PriorityQueue();

        q.offer("Thu");
        q.add("Ha");
        q.offer("Dong");
        q.add("Xuan");

        System.out.println(q);

        //get: R
        String item = q.peek();
        System.out.println("item: " + item);
        System.out.println(q);
        
        //Delete
        String e = q.poll();
        System.out.println("e is: " + e);
        System.out.println(q);

    }
}
