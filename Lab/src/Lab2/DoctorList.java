/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class DoctorList {

    HashMap<String, Doctor> drList = new HashMap<>();

    boolean isEmptyList() {
        if (drList.isEmpty()) {
            System.out.println("List is Empty!");
        }
        return drList.isEmpty();
    }

    void add() {
        Doctor dr = new Doctor();
        dr.input();

        if (drList.isEmpty() | !drList.containsKey(dr.id)) {
            drList.put(dr.id, dr);
            System.out.println("Add new doctor successfully!");
            return;
        }
        System.out.println("ID already exist, cannot add!");
    }

    void remove(String drID) {
        if (isEmptyList()) {
            return;
        }
        if (drList.containsKey(drID)) {
            drList.remove(drID);
            System.out.println("Remove drID:" + drID + "successfully!");
        }
    }

    void display() {
        if (isEmptyList()) {
            return;
        }

        List<Doctor> drLevel2s = drList.values().stream().filter(m -> m.level.contains("2")).collect(Collectors.toList());

        if (drLevel2s.isEmpty()) {
            System.out.println("Cannot find any doctor level 2");
            return;
        }

        for (Doctor d : drLevel2s) {
            System.out.println("-----");
            d.toString();
        }
    }

    void display(String drName) {
        if (isEmptyList()) {
            return;
        }

        List<Doctor> drLevel2s = drList.values().stream().filter(m -> m.name.trim().toLowerCase().contains(drName.trim().toLowerCase())).collect(Collectors.toList());

        if (drLevel2s.isEmpty()) {
            System.out.println("Cannot find any doctor name " + drName);
            return;
        }

        for (Doctor d : drLevel2s) {
            System.out.println("-----");
            d.toString();
        }
    }
}
