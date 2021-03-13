/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_pa;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author crist
 */
public class ExamScoreSolution extends Solution{

    List<Student> scoreSortedStud; 
    public ExamScoreSolution(Problem pb) {
        super(pb);
        this.scoreSortedStud = pb.getStudentList();
        Collections.sort(this.scoreSortedStud);
    }
    
    public void solve(){
        scoreSortedStud.stream().forEach(std -> {
            for(School sch : pb.getStdPrefMap().get(std))
                if(sch.getCapacity() != 0)
                {
                    sch.setCapacity(sch.getCapacity()-1);
                    studToSchool.put(std, sch);
                    break;
                }
        });
    }
    
    public void printSolution()
    {
        Set<Map.Entry<Student, School>> entries = studToSchool.entrySet();
        System.out.println();
        System.out.println("The students are assigned to these schools based on their exam score:");
        entries.stream().forEach(entry -> {
            System.out.println(entry.getKey().getName() + " : " + entry.getValue().getName());
        });
    }
}
