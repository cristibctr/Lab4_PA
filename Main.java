/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_pa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author crist
 */
public class Main {
    public static void main(String[] args)
    {
        Problem firstProblem = new Problem();
        firstProblem.printProblem();
        Solution firstSolution = new Solution(firstProblem);
        firstSolution.solve();
        firstSolution.printSolution();
        
        List<School> schSet = new ArrayList<> (firstProblem.getSchoolSet().stream()
                .filter(sch -> sch.getName().contains("H2") || sch.getName().contains("H1"))
                .collect(Collectors.toList()));
        System.out.println("The School list:");
        schSet.stream().forEach(sch -> System.out.println(sch.getName()));
        firstProblem.studLikeSch(schSet);
        
        
        firstProblem.schoolTopPref(firstProblem.getStudentList().get(0));
    }
}
