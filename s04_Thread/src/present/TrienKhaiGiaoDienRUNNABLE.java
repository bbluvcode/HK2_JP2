/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package present;

/**
 *
 * @author Admin
 */
public class TrienKhaiGiaoDienRUNNABLE implements Runnable {
        public void run() {
        // code thực thi của thread
    }
        public static void main(String[] args) {
        // Khởi tạo và khởi động thread
Thread thread = new Thread(new MyRunnable());
thread.start();
    }
}
