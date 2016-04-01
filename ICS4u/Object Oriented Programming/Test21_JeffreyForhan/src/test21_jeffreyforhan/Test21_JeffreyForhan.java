/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test21_jeffreyforhan;

/**
 *
 * @author jefor2991
 */
public class Test21_JeffreyForhan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Player user = new Player();
        Player comp = new Player();
        
        while(comp.getValue() < 16){
            comp.setValue();
        }        
        System.out.println("Computer scored a " + comp.getValue());
        
        System.out.print("(1) - ");
        user.makeMove();
        
    }
    
}
