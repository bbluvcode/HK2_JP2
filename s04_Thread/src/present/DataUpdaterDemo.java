/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package present;

/**
 *
 * @author Admin
 */
import java.util.Random;

public class DataUpdaterDemo {
    public static void main(String[] args) {
        DataUpdater updater = new DataUpdater();
        updater.start();

        // Tạo một giao diện đơn giản để nhập dữ liệu từ người dùng
        InputHandler inputHandler = new InputHandler(updater);
        inputHandler.start();
    }
}

class DataUpdater extends Thread {
    private volatile boolean running = true;
    private int data = 0;

    @Override
    public void run() {
        Random rand = new Random();

        while (running) {
            // Cập nhật dữ liệu ngẫu nhiên
            data = rand.nextInt(100);
            System.out.println("Updated data: " + data);

            try {
                // Tạm dừng thread trong 2 giây
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopUpdating() {
        running = false;
    }

    public int getData() {
        return data;
    }
}

class InputHandler extends Thread {
    private DataUpdater updater;

    public InputHandler(DataUpdater updater) {
        this.updater = updater;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Lấy dữ liệu từ updater và hiển thị
                int currentData = updater.getData();
                System.out.println("Current data: " + currentData);

                // Tạm dừng thread trong 1 giây
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
