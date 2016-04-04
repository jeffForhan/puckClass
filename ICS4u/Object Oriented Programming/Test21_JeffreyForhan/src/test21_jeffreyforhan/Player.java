/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test21_jeffreyforhan;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jefor2991
 */
public class Player {
    private Random randy = new Random();
    private int cardNum;
    private int score;
    
    /**
     * Constructor
     * Pre: none
     * Post: Initializes the player's score
     */
    Player(){
        //Give value of 1-13
        drawCard();
    }
    /**
     * description:
     * pre: Player selects to pick a new
     * post: Adds new card to the player's hand
     */
    public void drawCard(){
        //Give value of 1-13
        cardNum = randy.nextInt(13)+1;
    }
    /**
     * description:
     * pre:
     * post:
     */
    public void setValue(){
        
        drawCard();
        
        if(cardNum == 1){
            if(score <= 10){
                score += 11;
            }else{
                score += 1;
            }
        }else if(cardNum < 10){
            score += cardNum;
        }else{
            score += 10;
        }
    }    
    /**
     * description: Makes menu, and allows user to pick what to do
     * pre: none
     * post: creates menu for user
     */
    public void makeMove(){
        Scanner choose = new Scanner(System.in);
        
        System.out.print("(1) - Draw a new card\n(2) - Show current card value\n(0) - Exit program\nSelect option: ");
        
        try{
            if(choose.nextInt() == 1){
                setValue();
            }else if(choose.nextInt() == 2){
                getValue();
            }else if(choose.nextInt() == 0){
                System.out.println("You have exited.");
                choose.close();
            }
        }catch(InputMismatchException e){
            System.out.println("Invalid input");
            System.err.println("InputMismatchException: " + e.getMessage());
        }
    }
    /**
     * description:
     * pre:
     * post:
     * @return the player's current score
     */
    public int getValue(){
        return score;
    }
    /**
     * description: 
     * pre:
     * post:
     * @param obj the object that this object is being compared to
     * @return 1(this player has a higher score), -1(other player has a higher score), 0(both scores are the same)
     */
    public int compareTo(Object obj){
        Player other = (Player)obj;
        if(score > other.getValue()){
            return 1;
        }else if(score < other.getValue() ){
            return -1;
        }else{
            return 0;
        }
    }
}
