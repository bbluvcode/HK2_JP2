/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author User
 */
public class TestDAO {
    public static void main(String[] args) {
        List<User> uList = List.of(
                new User("1", "A", "a@a"),
                new User("2", "B", "b@b"),
                new User("3", "C", "c@c")
        );
        UserDAO uD = new UserDAO();
        
        //addList
        uD.users.addAll(uList);
        
        //addUser
        User t = new User("4", "D", "d@d"); 
        uD.create(t);
        //displayAll
        System.out.println("List of Users");
        uD.getAll().forEach(System.out::println);
        
        ////Search 
        System.out.println("Search");
        Optional<User> user = uD.read("1");
        if (user.isPresent()) {
            System.out.println(user.get());
            System.out.println(user.get().getName());
            System.out.println(user.get().getEmail());
        } else {
            System.out.println("User not found! ");
        }
        
        //edit
//        System.out.println("Edit");
//        Optional<User> u = uD.read(2);
//        if (u.isPresent()) {
//            u.get().setName("BBB");
//            uD.update(u.get());
//            System.out.println("List of Users after update");
//            uD.getAll().forEach(System.out::println);
//            
//        } else {
//            System.out.println("User not found. Update fail !");
//        }
        

        //Delete
//        System.out.println("Delete");
//        Optional<User> u = uD.read(5);
//        if (u.isPresent()) {
//            uD.delete(u.get());
//            System.out.println("List of Users after delete");
//            uD.getAll().forEach(System.out::println);
//        } else {
//            System.out.println("User not found. Remove fail !");
//        }        
    }
}
