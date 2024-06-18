/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author User
 */
public class Patient implements Serializable{
    String id, name ,gender, examDate;

    public Patient() {
    }

    public Patient(String id, String name, String gender, String examDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.examDate = examDate;
    }

    public void accept(){
        Scanner sc = new Scanner(System.in);
        Pattern p;
        Matcher m;
        while(true){
            System.out.print("Enter ID: ");
            id = sc.nextLine().trim();
            if(id.isEmpty()){
                System.out.println("ID cannot empty !");
            }
            else{
                break;
            }
        }
        while(true){
            System.out.print("Enter Name: ");
            name = sc.nextLine().trim();
            if(name.isEmpty()){
                System.out.println("Name cannot empty !");
            }
            else{
                break;
            }
        }
        p = Pattern.compile("Male|Female", Pattern.CASE_INSENSITIVE);
        while(true){
           System.out.print("Enter Gender(Male or Female): ");
            gender = sc.nextLine().trim();
            m = p.matcher(gender);
            if(!m.matches()){
                System.out.println("Gender must be Male or Female !");
            }
            else{
                break;
            } 
        }
        p = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}");
        while (true) {
            System.out.print("Enter examDate(yyyy-mm-dd): ");
            examDate = sc.nextLine().trim();
            m = p.matcher(examDate);
            if (m.matches()) {
                break;
            } else {
                System.out.println("examDate format is wrong !");
            }
        }
    }
    @Override
    public String toString(){
       return String.format("%s, %s, %s, %s", id, name, gender, examDate);
    }
//    public static void main(String[] args) {
//        Patient p = new Patient();
//        p.accept();
//        System.out.println(p);
//    }
}
