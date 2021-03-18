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
    private int capacity, id;
    private Criteria criteria;
    
    public School(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
    
    public School(String name, int capacity, int id) {
        this.name = name;
        this.capacity = capacity;
        this.id = id;
    }
    
    public School(String name, int capacity, Criteria criteria) {
        this.name = name;
        this.capacity = capacity;
        this.criteria = criteria;
    }

    public int getId() {
        return id;
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

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public Criteria getCriteria() {
        return criteria;
    }
    
    
}
