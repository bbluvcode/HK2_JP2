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
public class DemoJoin implements Runnable {

    String name;
    Thread objTh;

    public DemoJoin(String str) {
        this.name = str;
        this.objTh = new Thread(this, name);
        System.out.println("New Threads are starting : " + objTh);
        objTh.start();
    }

    @Override
    public void run() {

        System.out.println("Hello: " + name);
        objTh.interrupt();
        System.out.println(name + " existing");

    }

    public static void main(String[] args) {
        DemoJoin objNew1 = new DemoJoin("one");
        DemoJoin objNew2 = new DemoJoin("two");
        DemoJoin objNew3 = new DemoJoin("three");
        System.out.println("First thread is alive: " + objNew1.objTh.isAlive());
        System.out.println("Second thread is alive: " + objNew2.objTh.isAlive());
        System.out.println("Third thread is alive: " + objNew1.objTh.isAlive());

        try {
            System.out.println("In the main method, wating for the threads ");
            objNew1.objTh.join();
            objNew2.objTh.join();
            objNew3.objTh.join();
        } catch (InterruptedException ex) {
            System.out.println("Main thread is interrupted");
            System.out.println("First thread is alive: " + objNew1.objTh.isAlive());
            System.out.println("Second thread is alive: " + objNew2.objTh.isAlive());
            System.out.println("Third thread is alive: " + objNew3.objTh.isAlive());
            System.out.println("Main thread is over and existing");

        }

    }
}
