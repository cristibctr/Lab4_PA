/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_pa;

import com.github.javafaker.Faker;
import java.util.ArrayList;
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
    private Map<Student, List<School>> stdPrefMap = new LinkedHashMap<>();
    private Map<School, List<Student>> schPrefMap = new TreeMap<>();
    private List<Student> studentList = new LinkedList<>();
    private Set<School> schoolSet = new TreeSet<>();
    private List<Criteria> criteriaList = new ArrayList<>();
    private int ID = 0, preference[][];
    
    //Subpunct 3 Bonus
    private Map<School, List<List<Student>>> stdTiePrefMap = new HashMap<>();
    
    public Problem() {
        Faker faker = new Faker();
        var students = IntStream.rangeClosed(0,3)
                        .mapToObj(i -> new Student (faker.name().fullName(), ID++))
                        .toArray(Student[]::new);
        
        var schools = IntStream.rangeClosed(0, 3)
                        .mapToObj(i -> new School (faker.university().name(), (int)(Math.random()*10)%students.length + 1, ID++))
                        .toArray(School[]::new);
        
        //Manually set some criteria for each school
        schools[0].setCriteria(new Note(1));
        schools[1].setCriteria(new NameLength(10));
        schools[2].setCriteria(new Note(8));
        schools[3].setCriteria(new Note(7));
        studentList.addAll(Arrays.asList(students));
        
        schoolSet.addAll(Stream.of(schools).collect(Collectors.toSet()));
        
        Collections.sort(studentList, Comparator.comparing(Student::getName));
        
        stdPrefMap.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[2], Arrays.asList(schools[0], schools[1]));
        stdPrefMap.put(students[3], Arrays.asList(schools[0], schools[2]));
        
//        schPrefMap.put(schools[0], Arrays.asList(students[3], students[0], students[1], students[2]));
//        schPrefMap.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
//        schPrefMap.put(schools[2], Arrays.asList(students[0], students[1], students[3]));
        
        setSchPrefCriteria();
        
        setPref();
        
    }
    
    private void setPref(){
        int maxArr = studentList.size() > schoolSet.size() ? studentList.size() : schoolSet.size();
        preference = new int [studentList.size() + schoolSet.size()][maxArr];
        int i = 0;
        for(Map.Entry<Student, List<School>> entry : stdPrefMap.entrySet()){
            i = 0;
            for(School school : entry.getValue())
            {
                preference[entry.getKey().getId()][i++] = school.getId();
            }
            for(int j = i; j < maxArr; j++)
                preference[entry.getKey().getId()][j] = -1;
        }
        for(Map.Entry<School, List<Student>> entry : schPrefMap.entrySet()){
            i = 0;
            for(Student student : entry.getValue())
            {
                preference[entry.getKey().getId()][i++] = student.getId();
            }
            for(int j = i; j < maxArr; j++)
                preference[entry.getKey().getId()][j] = -1;
        }
    }

    public int[][] getPreference() {
        return preference;
    }

    public void setStdTiePrefMap(Map<School, List<List<Student>>> stdTiePrefMap) {
        this.stdTiePrefMap = stdTiePrefMap;
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
        System.out.println("\nStudents:");
        studentList.stream().forEach(s -> {
            System.out.print(s.getId() + " ");
            System.out.print(s.getName() + " (score: " + s.getExamScore() + ")" + ": ");
            stdPrefMap.get(s).stream().forEach(std -> System.out.print(std.getName() + " | "));
            System.out.println();
        });
        
        System.out.println();
        System.out.println("Schools:");
        
        schoolSet.stream().forEach(s -> {
            System.out.print(s.getId() + " ");
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
        System.out.println("\nThe schools that have " + prefStud.getName() + " as their top preferenceence are: ");
        schoolSet.stream().filter(s -> {if(!schPrefMap.get(s).isEmpty()) return schPrefMap.get(s).stream().findFirst().get().equals(prefStud); else return false;})
                .forEach(sch -> System.out.println(sch.getName()));
    }
    
    
    //Sets the prefered students for each School based on their Criteria
    public void setSchPrefCriteria(){
        List<School> removeSet = new ArrayList<>();
        for(School school : schoolSet)
        {
            if(school.getCriteria() == null){
                System.out.println(school.getName() + " doesn't have a criteria");
                continue;
            }
            if(school.getCriteria().getClass() == Note.class)
            {
                schPrefMap.put(school, studentList.stream()
                        .filter(s -> s.getExamScore() >= ((Note)school.getCriteria()).getMinNote())
                        .collect(Collectors.toList()));
            }
            else
            {
                schPrefMap.put(school, studentList.stream()
                        .filter(s -> s.getName().length() >= ((NameLength)school.getCriteria()).getNameLength())
                        .collect(Collectors.toList()));
            }
//            if(schPrefMap.get(school).isEmpty())
//            {
//                System.out.println("\nCouldn't find any Student to match " + school.getName() + "'s Criteria. Deleting school Object.");
//                schPrefMap.remove(school);
//                removeSet.add(school);
//            }
        }
        //schoolSet.removeAll(removeSet);
    }
}
