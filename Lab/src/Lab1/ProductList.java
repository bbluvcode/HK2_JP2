/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class ProductList {

    ArrayList<Product> prList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void addProduct() {
        Product p = new Product();
        p.input();
        prList.add(p);
        System.out.println("Add new product sucessfully");
    }

    boolean isListEmpty() {
        if (prList.isEmpty()) {
            System.out.println("Cannot display because list empty!");
        }
        return prList.isEmpty();
    }

    void displayAll() {
        if (isListEmpty()) {
            return;
        }

        for (Product p : prList) {
            System.out.println("-----");
            System.out.println(p.toString());
        }
    }

    void searchByName(String name) {
        List<Product> searchList = prList.stream()
                .filter(m -> m.name.toLowerCase().contains(name))
                .collect(Collectors.toList());
        if(searchList.isEmpty()){
            System.out.println("Cannot found any product name " + name);
            return;
        }
        for(Product p : searchList){
            System.out.println("-----");
            System.out.println(p.toString());
        }
    }

}
