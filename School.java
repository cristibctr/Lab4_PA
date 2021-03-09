/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_pa;

/**
 *
 * @author crist
 */
public class School implements Comparable<School> {
    private String name;
    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public int compareTo(School other){
        return this.name.compareTo(other.name);
    }
    
}
