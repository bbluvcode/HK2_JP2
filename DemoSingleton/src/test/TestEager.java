/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import data.EagerInitialization;

/**
 *
 * @author User
 */
public class TestEager {
    public static void main(String[] args) {
        EagerInitialization e1 = EagerInitialization.getInstance();
        e1.setName("e1");
        System.out.println(e1.getName());
        
        EagerInitialization e2 = EagerInitialization.getInstance();
        System.out.println(e2.getName());
        
    }
}
