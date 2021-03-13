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
    private int capacity;
    public School(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }
    @Override
    public int compareTo(School other){
        return this.name.compareTo(other.name);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
}
