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
public final class NameLength extends Criteria{
    int nameLength;

    public NameLength(int nameLength) {
        System.out.println("Name length");
        this.nameLength = nameLength;
    }

    public int getNameLength() {
        return nameLength;
    }

}
