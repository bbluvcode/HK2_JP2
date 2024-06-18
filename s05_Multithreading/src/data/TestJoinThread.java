/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luu Bao
 */
public class TestJoinThread {

    public static void main(String[] args) {
        JoinThread thread1 = new JoinThread();
        thread1.setName("Thread of Quan");
        thread1.start(); // khoi chay thread1
//
        try {
            thread1.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        JoinThread thread2 = new JoinThread();
        thread2.setName("Thread of Thu");
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        JoinThread thread3 = new JoinThread();
        thread3.setName("Thread of Ngoc");
        thread3.start();

        try {
            thread3.join();
        } catch (InterruptedException ex) {
              System.out.println(ex.getMessage());
        }
        System.out.println("So luong dang chay: " + Thread.activeCount());
    }
}
