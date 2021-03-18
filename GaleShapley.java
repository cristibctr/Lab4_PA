/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_pa;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author crist
 */
public class GaleShapley extends Solution {
    int matrixSize = pb.getSchoolSet().size();  
    private int preference[][], schMatch[];

    public GaleShapley(Problem pb) {
        super(pb);
        this.preference = pb.getPreference();
    }
    
    boolean schPrefStud(int preference[][], int school, int student, int student2)  
    {
        for (int i = 0; i < matrixSize; i++)  
        {  
            if (preference[school][i] == student2)  
                return true;  
            if (preference[school][i] == student)  
                return false;  
        } 
        return false; 
    }  
    
    @Override
    public void solve()  
    {  
        int schMatch[] = new int[matrixSize];
        boolean studNotChosen[] = new boolean[matrixSize];  
        Arrays.fill(schMatch, -1);  
        int matchCount = matrixSize;  
        int iterator = 0;
        while (matchCount > 0){
            if(iterator > 50) break;
            iterator++;
            int student;  
            for (student = 0; student < matrixSize; student++)  
                if (studNotChosen[student] == false)  
                    break;  
            for (int i = 0; i < matrixSize && studNotChosen[student] == false; i++)  
            {  
                int school = preference[student][i];   
                if(school == -1) 
                {
                    matchCount--;
                    break;
                }
                if (schMatch[school - matrixSize] == -1)  
                {  
                    schMatch[school - matrixSize] = student;  
                    studNotChosen[student] = true;  
                    matchCount--;  
                }  

                else 
                {
                    int student2 = schMatch[school - matrixSize];  
                    if (schPrefStud(preference, school, student, student2) == false)  
                    {  
                        schMatch[school - matrixSize] = student;  
                        studNotChosen[student] = true;  
                        studNotChosen[student2] = false;  
                    }  
                }
            }
        }
        this.schMatch = schMatch;
    }
    
    @Override
    public void printSolution(){
        System.out.println("\nUsing Gale Shapely algorithm:");
        for (int i = 0; i < matrixSize; i++)  
        { 
            System.out.print("\n");  
            boolean ok = true;
            for(School s : pb.getSchoolSet())
            {
                if(s.getId() == i+matrixSize){
                    System.out.print(s.getName() + "     ");
                    ok = false;
                    break;
                }
            }
            ok = true;
            for(Student s : pb.getStudentList())
            {
                if(s.getId() == schMatch[i])
                {
                    ok = false;
                    System.out.println(s.getName());
                    break;
                }
            }
            if(ok) System.out.println("-> Can't find a matching partner");
        }
        System.out.println();
    }

}
