/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class PatientManage {
    public ArrayList<Patient> patientsList = new ArrayList();
    public String fileName = "Patients.txt";

    public PatientManage() {
        readFile();
    }
    public void readFile(){
        File f = new File(fileName);
        if(!f.exists()){
            System.out.println("File not exists !");
            return;
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            patientsList = (ArrayList<Patient>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PatientManage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PatientManage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PatientManage.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void saveFile(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(patientsList);
            oos.close();
            System.out.println("Save file success !");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PatientManage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PatientManage.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void openFile(){
        Runtime r = Runtime.getRuntime();
        try {
            r.exec("notepad " + fileName);
        } catch (IOException ex) {
            Logger.getLogger(PatientManage.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    public void findOne(String id){
        if(patientsList.isEmpty()){
            System.out.println("List of Patients is empty !");
            return;
        }
        Patient e = patientsList.stream().filter(m->m.id.equals(id)).findFirst().orElse(null);
        if(e == null){
            System.out.println("Not found Patient have ID: " +id);
        }
        else{
            System.out.println("Information of Patient have ID: " +id);
            System.out.println(e);
        }
    }
    public void addPatient(Patient newPatient){
        patientsList.add(newPatient);
        System.out.println("Add new Patient success !");
    }
}
