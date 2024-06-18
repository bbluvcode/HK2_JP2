/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Admin
 */
public class DemoMap {
    
    
    //Tinh chat: 
    //lưu dữ liệu dưới dạng key:value
//    khong thuoc collection nen khong the sap xep giong list
//            dung TreeMap de sap xep

    public static void main(String[] args) {
        //tao 1 doi tuong kieu hashMap
        
        

        HashMap<Integer, String> hash = new HashMap();

        //them
        hash.put(1, "Xuân");
        hash.put(2, "Hạ");
        hash.put(3, "Thu");
        hash.put(4, "Đông");

        //xuat
        System.out.println(hash.keySet());
        Set<Integer> keys = hash.keySet();
        System.out.println("keys: " + keys);

        Collection<String> vals = hash.values();
        System.out.println("vals: " + vals);

        System.out.println(hash);

        for (Integer k : keys) {
            System.out.println(k + ":" + hash.get(k));
        }

        //
        hash.replace(1, "Nắng");
        System.out.println("hash.replace(1, \"Nắng\"): " + hash);

        //delete
        hash.remove(1);
        System.out.println("hash.remove(1): " + hash);

        //search
        boolean r = hash.containsValue("Đông");
        System.out.println("r is " + r);

        //TreeMap: sap xep theo key theo thu tu tang dan
        TreeMap<Integer, String> tree = new TreeMap();

        tree.put(1, "Xuân");
        tree.put(4, "Đông");
        tree.put(3, "Thu");
        tree.put(2, "Hạ");

        System.out.println("treeMap: " + tree);

    }
}
