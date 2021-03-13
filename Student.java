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
public class Student {
    private String name;
    private int examScore;
    public Student(String name){
        this.name = name;
        examScore = (int)(Math.random()*10);
    }

    public String getName() {
        return name;
    }

    public int getExamScore() {
        return examScore;
    }
    
    
}
