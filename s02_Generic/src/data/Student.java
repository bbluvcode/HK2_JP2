/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Admin
 */
//tao 1 lop Generic
public class Student<A, B, C> {

    public A id;
    public B name;
    public C gender;

    public Student() {
    }

    public Student(A id, B name, C gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public void output() {
        System.out.println("ID: " + id + " Name: " + name + " Gender: " + gender);
    }

}
