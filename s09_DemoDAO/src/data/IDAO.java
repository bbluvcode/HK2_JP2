/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author User
 */
public interface IDAO<T> {
    public void create(T t);           //add
    public Optional<T> read(String id);   //get - search
    public void update(T t);           //set - edit  
    public void delete(T t);           //remove
    List<T> getAll();                  //displayAll
    
    
    
    
}
