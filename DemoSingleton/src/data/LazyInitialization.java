/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author User
 */
public class LazyInitialization {   //single-thread
    private static LazyInitialization instance;
    private LazyInitialization(){
        
    }
    public static LazyInitialization getInstance(){
        if (instance == null) { //chua co thi tao moi
            instance = new LazyInitialization();
        }
        return instance;    //neu co roi thi tra ve truoc do
    }
}
