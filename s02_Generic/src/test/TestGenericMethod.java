/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import data.MethodGeneric;

/**
 *
 * @author Admin
 */
public class TestGenericMethod {

    public static void main(String[] args) {
        MethodGeneric m = new MethodGeneric();

        String[] seasons ={"Xuan","Ha", "Thu","Dong"};
        m.display(seasons, "Cac mua trong nam");
        
        
        Integer[] numbers = {10, 20, 30, 40};
        m.display(numbers, "Cac so tu nhien");
        
        
        m.show(seasons, "Cac mua trong nam");
        m.show(numbers, "Cac so tu nhien");

    }
}
