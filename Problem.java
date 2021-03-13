/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_pa;

import com.github.javafaker.Faker;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
public class Problem {
    Map<Student, List<School>> stdPrefMap = new LinkedHashMap<>();
    Map<School, List<Student>> schPrefMap = new TreeMap<>();
    List<Student> studentList = new LinkedList<>();
    Set<School> schoolSet = new TreeSet<>();
    
    public Problem() {
        Faker faker = new Faker();
        var students = IntStream.rangeClosed(0,3)
                        .mapToObj(i -> new Student (faker.name().fullName()))
                        .toArray(Student[]::new);
        
        var schools = IntStream.rangeClosed(0, 2)
                        .mapToObj(i -> new School (faker.university().name(), (int)(Math.random()*10)%students.length + 1))
                        .toArray(School[]::new);
        
        studentList.addAll(Arrays.asList(students));
        
        schoolSet.addAll(Stream.of(schools).collect(Collectors.toSet()));
        
        Collections.sort(studentList, Comparator.comparing(Student::getName));
        
        stdPrefMap.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[2], Arrays.asList(schools[0], schools[1]));
        stdPrefMap.put(students[3], Arrays.asList(schools[0], schools[2]));
        
        schPrefMap.put(schools[0], Arrays.asList(students[3], students[0], students[1], students[2]));
        schPrefMap.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
        schPrefMap.put(schools[2], Arrays.asList(students[0], students[1], students[3]));
        
        

    }

    public Map<Student, List<School>> getStdPrefMap() {
        return stdPrefMap;
    }

    public Map<School, List<Student>> getSchPrefMap() {
        return schPrefMap;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public Set<School> getSchoolSet() {
        return schoolSet;
    }
    public void printProblem() {
        System.out.println("Students:");
        studentList.stream().forEach(s -> {
            System.out.print(s.getName() + " (score: " + s.getExamScore() + ")" + ": ");
            stdPrefMap.get(s).stream().forEach(std -> System.out.print(std.getName() + " | "));
            System.out.println();
        });
        
        System.out.println();
        System.out.println("Schools:");
        
        schoolSet.stream().forEach(s -> {
            System.out.print(s.getName() + " (capacity: " + s.getCapacity() + ")" + ": ");
            schPrefMap.get(s).stream().forEach(sch -> System.out.print(sch.getName() + " | "));
            System.out.println();
        });
    }
    public void studLikeSch(List schools) {
        System.out.println("\nStudents who like all the schools in the list are: ");
        List<Student> result = studentList.stream().filter(std -> stdPrefMap.get(std).containsAll(schools)).collect(Collectors.toList());
        result.stream().forEach(stud -> {System.out.println(stud.getName());});
    }
    public void schoolTopPref(Student prefStud) {
        System.out.println("\nThe schools that have " + prefStud.getName() + " as their top preference are: ");
        schoolSet.stream().filter(s -> schPrefMap.get(s).stream().findFirst().get().equals(prefStud)).forEach(sch -> System.out.print(sch.getName() + " "));
    }
}
