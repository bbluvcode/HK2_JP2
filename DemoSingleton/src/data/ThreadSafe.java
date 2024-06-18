/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author User
 */
public class ThreadSafe {
    private static volatile ThreadSafe instance;
    //volatile đảm bảo rằng thay đổi được thực hiện trên biến instance sẽ được
    //nhìn thấy ngay lập tức bởi các luồng khác
    private ThreadSafe(){
        
    }
    private static synchronized ThreadSafe getInstance(){
        if (instance == null) {
            instance = new ThreadSafe();
        }
        return instance;
    }
}
