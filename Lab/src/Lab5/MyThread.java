/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5;

/**
 *
 * @author Admin
 */
import java.util.Random;

public class MyThread implements Runnable {

    private int priority;

    public MyThread(int priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int randomNumber = random.nextInt(101); // Generate random number between 0 and 100
            System.out.println("Random number: " + randomNumber + " | Thread Priority: " + Thread.currentThread().getPriority());
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread1 = new MyThread(Thread.MAX_PRIORITY);
        MyThread thread2 = new MyThread(Thread.MIN_PRIORITY);

        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);

        t1.setPriority(thread1.priority);
        t2.setPriority(thread2.priority);

        t1.start();
        t2.start();
    }
}
