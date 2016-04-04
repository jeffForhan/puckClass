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
        //Instantiate a player object
        Player user = new Player();
        //Instantiate a computer player object
        Player comp = new Player();
        
        //Make the computer draw more cards while his score is less than 16
        while(comp.getValue() < 16){
            comp.setValue();
        }
        
        System.out.println("Computer scored a " + comp.getValue());
        
        user.makeMove();
        
    }
    
}
