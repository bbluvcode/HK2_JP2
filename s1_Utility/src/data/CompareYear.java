/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.Comparator;

/**
 *
 * @author Admin
 */
public class CompareYear implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.year < o2.year ? -1 : o1.year > o2.year ? 1 : 0;
    }

}
