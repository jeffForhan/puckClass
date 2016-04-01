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
     * pre: Player selects to pick a new
     * post: Adds new card to the player's hand
     */
    public void drawCard(){
        //Give value of 1-13
        cardNum = randy.nextInt(13)+1;
    }
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
     * Makes menu, and allows user to pick what to do
     * Pre: none
     * Post: creates menu for user
     */
    public void makeMove(){
        Scanner choose = new Scanner(System.in);
        
        try{
            if(choose.nextInt() == 1){
                setValue();
            }else if(choose.nextInt() == 2){
                getValue();
            }else if(choose.nextInt() == 0){
                System.out.println("You have exited.");
            }
        }catch(InputMismatchException e){
            System.out.println("Invalid input");
            System.err.println("InputMismatchException: " + e.getMessage());
        }
        choose.close();
    }
    
    public int getValue(){
        return score;
    }
    
    public int compareTo(Object c){
        Player other = (Player)c;
        if(other.getValue() > score){
            return 1;
        }else if(other.getValue() < score){
            return -1;
        }else{
            return 0;
        }
    }
}
