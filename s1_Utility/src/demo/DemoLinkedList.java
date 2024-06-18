/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import java.util.LinkedList;

/**
 *
 * @author Admin
 */
public class DemoLinkedList {
    // có các chức năng giống Arraylist, tương đối giống Arraylist, chỉ khác cách lưu giữ liệu, 
    //ưu điểm nhanh khi thêm xóa dữ liệu hơn Array list, search thì lâu hơn
    public static void main(String[] args) {
        //tao 1 doi tuong kieu LinkedList
        LinkedList<String> list = new LinkedList();
        
        //them
        System.out.println("**--CREATE--**");
        list.add("Monday");
        list.add("Tuesday");
        list.addAll(list);
        
        System.out.println(list);
    }
}
