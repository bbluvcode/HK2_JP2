/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author User
 */
public class DoubleCheckLocking {
    private static volatile DoubleCheckLocking instance;
    private DoubleCheckLocking(){
        
    }
    public static DoubleCheckLocking getInstance(){
        if (instance == null) {
            synchronized (DoubleCheckLocking.class) {
                if (instance == null) {
                    instance = new DoubleCheckLocking();
                }
            }
        }        
        return instance;
    }
}

//
