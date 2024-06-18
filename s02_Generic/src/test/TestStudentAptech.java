/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import data.StudentAptech;

/**
 *
 * @author Admin
 */
public class TestStudentAptech {

    public static void main(String[] args) {
        //tao doi tuong
        StudentAptech<Integer, String, String, Integer> s1 = new StudentAptech(1, "A", "Male", 70);

        s1.output();

//        StudentAptech<String, String, Boolean, Float> s2 = new StudentAptech(1, "A", "Female", 70);
//        s2.output();
//====> parameter contructor không bắt được lỗi kiểu dữ liệu

        StudentAptech<String, String, Boolean, Float> s3 = new StudentAptech();
        s3.id = "1";
        s3.name = "B";
        s3.gender = true;
        s3.mark = 50.0f;
        s3.output();
    }
}
