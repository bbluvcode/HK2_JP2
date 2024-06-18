/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import java.util.Stack;

/**
 *
 * @author Admin
 */
public class DemoStack {
    //mảng ngăn xếp
    
    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        
        //them
        stack.add("Xuan");
        stack.push("ha");
        stack.addAll(stack);
        
        //retrieve
        System.out.println(stack);
        
        //update
        stack.set(2, "Thu");
        
        //remove:
        stack.pop(); //remove phan tu tren cung        
        System.out.println(stack);
        //có thừa kế vector nên có thể remove theo index
        
        //search
        int r1 = stack.search("Thu");
        System.out.println(r1);
        
        int r2 = stack.search("Xuan");
        System.out.println(r2);
        
        
    }
}
