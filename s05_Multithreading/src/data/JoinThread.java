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
public class JoinThread extends Thread{
    @Override
    public void run(){
        super.run();
        System.out.println(Thread.currentThread().getName() + " dang chay");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
           ex.printStackTrace();
        }
        System.out.println("Ket thuc "  +  Thread.currentThread().getName());
        
    }
}
