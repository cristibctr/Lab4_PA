/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_pa;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author crist
 */
public class SimplestSolution extends Solution{

    public SimplestSolution(Problem pb) {
        super(pb);
    }
    
    public void solve(){
        pb.getStudentList().stream().forEach(std -> {
            for(School sch : pb.getSchoolSet())
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
        System.out.println("The students are assigned to these schools without taking into account their exam note:");
        entries.stream().forEach(entry -> {
            System.out.println(entry.getKey().getName() + ":" + entry.getValue().getName());
        });
    }
    
}
