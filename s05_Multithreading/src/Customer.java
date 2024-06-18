/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Luu Bao
 */
public class Customer {

    private int balance = 10000; // so du tai khoan

    public Customer() {
        System.out.println("Tai khoan hien co: " + balance);
    }

    // phuong thuc rut tien
    private synchronized void withDraw(int money) {
        System.out.println("Giao dich rut tien dang duoc thuc hien voi so tien = " + money + "...");
        if (balance <=  money) {
            System.out.println("So tien trong tai khoan khong du!");
            try {                
                wait(); // phuong thuc wait se dua Thread vao trang thai sleeping
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
        balance -= money;
        System.out.println("Rut tien thanh cong. So tien hien co trong tai khoan = " + balance);
    }

    // phuong thuc nap tien
    private synchronized void deposit(int money) {
        System.out.println("Giao dich nop tien dang duoc thuc hien voi so tien nop = " + money + "...");
        balance += money;
        System.out.println("Nop tien thanh cong. So tien hien co trong tai khoan = " + balance);
        notify();
    }

    public static void main(String[] args) {
        final Customer cs = new Customer();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                cs.withDraw(30000);
            }
        };
        t1.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                cs.deposit(20000);
            }
        };
        t2.start();
    }
}
