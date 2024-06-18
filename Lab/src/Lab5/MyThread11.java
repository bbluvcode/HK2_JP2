/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5;

/**
 *
 * @author Admin
 */
public class MyThread11 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) { // Printing even numbers from 1 to 10
                System.out.println("Thread 1: " + i);
                try {
                    Thread.sleep(500); // Sleep for 500ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 10; i += 2) { // Printing odd numbers from 1 to 10
                System.out.println("Thread 2: " + i);
                try {
                    Thread.sleep(500); // Sleep for 500ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        
        try {
            thread1.join(); // Waits for thread1 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
    }
}
