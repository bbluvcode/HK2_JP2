/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Admin
 */
public class StudentAptech<X, Y, Z, W> extends Student<X, Y, Z> {

   public  W mark;

    public StudentAptech() {
    }

    public StudentAptech(X id, Y name, Z gender, W mark) {
        super(id, name, gender);
        this.mark = mark;
    }

    @Override
    public void output()
    {
        super.output();
        System.out.println("Mark: " + mark);
    }
    
    
}
