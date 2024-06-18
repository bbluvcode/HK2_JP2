/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luu Bao
 */
public class DemoIsAlive implements  Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
    
    public static void main(String[] args) {
        DemoIsAlive obj = new DemoIsAlive();
        Thread demoObjThread = new Thread(obj);
        // bat dau 1 luong 
        demoObjThread.start(); 
        // dat ten luong 
        demoObjThread.setName("Thread1");
        // hien thi luong hien tai co alive hay khong
     
        System.out.println("The thread is alive: " + demoObjThread.isAlive());
        
        // cham dut luong chay 
        demoObjThread.interrupt();
        
        // hien thi luong hien tai co alive hay khong
        System.out.println("The thread is alive: " + demoObjThread.isAlive());
    }

    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    /**
     *
     * @author Luu Bao
     */
}
