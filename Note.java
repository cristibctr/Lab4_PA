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
public final class Note extends Criteria {
    private int minNote;
    
    public Note(int minNote) {
        System.out.println("Note");
        this.minNote = minNote;
    }

    public int getMinNote() {
        return minNote;
    }
    
    
    
}
