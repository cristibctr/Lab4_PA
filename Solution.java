/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_pa;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author crist
 */
public abstract class Solution {
    Problem pb;
    Map<Student, School> studToSchool = new HashMap<>();
    public Solution(Problem pb) {
        this.pb = pb;
    }
    abstract public void solve();
    abstract public void printSolution();
}
