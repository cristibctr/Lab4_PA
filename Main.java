/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_pa;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author crist
 */
public class Main {
    public static void main(String[] args)
    {
        var students = IntStream.rangeClosed(0,3)
                        .mapToObj(i -> new Student ("S" + i))
                        .toArray(Student[]::new);
        
        var schools = IntStream.rangeClosed(0, 2)
                        .mapToObj(i -> new School ("H" + i))
                        .toArray(School[]::new);
        
        List<Student> studentList = new LinkedList<>();
        studentList.addAll(Arrays.asList(students));
        
        Set<School> schoolSet = new TreeSet<>();
        schoolSet.addAll(Stream.of(schools).collect(Collectors.toSet()));
        
        Collections.sort(studentList, Comparator.comparing(Student::getName));
        
        Map<Student, List<School>> stdPrefMap = new HashMap<>();
        
        stdPrefMap.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[2], Arrays.asList(schools[0], schools[1]));
        stdPrefMap.put(students[3], Arrays.asList(schools[0], schools[2]));
        
        Map<School, List<Student>> schPrefMap = new TreeMap<>();
        
        schPrefMap.put(schools[0], Arrays.asList(students[3], students[0], students[1], students[2]));
        schPrefMap.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
        schPrefMap.put(schools[2], Arrays.asList(students[0], students[1], students[3]));
        
        for(Student s : students)
        {
            System.out.print(s.getName() + ": ");
            schoolSet.stream().filter(sch -> schPrefMap.get(sch).contains(s))
                    .forEach(sch -> {System.out.print(sch.getName()); System.out.print(" ");});
            System.out.println();
        }
        
        for(School s : schools)
        {
            System.out.print(s.getName() + ": ");
            studentList.stream().filter(std -> stdPrefMap.get(std).contains(s)).forEach(std -> {System.out.print(std.getName()); System.out.print(" ");});
            System.out.println();
        }
        
    }
}
