/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_pa;

import java.util.ArrayList;
import java.util.List;
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
        Solution firstSolution = new ExamScoreSolution(firstProblem);
        firstSolution.solve();
        firstSolution.printSolution();
        
        //List of schools based on some conditions - used to check which students like all of them
        List<School> schSet = new ArrayList<> (firstProblem.getSchoolSet().stream()
                .filter(sch -> sch.getName().length() < 12 || sch.getName().contains("Academy"))
                .collect(Collectors.toList()));
        System.out.println("\nThe School list:");
        schSet.stream().forEach(sch -> System.out.println(sch.getName()));
        firstProblem.studLikeSch(schSet);

        firstProblem.schoolTopPref(firstProblem.getStudentList().get(0));
    }
}
