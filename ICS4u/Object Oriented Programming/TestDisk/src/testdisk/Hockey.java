/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testdisk;

 
 /**
  * The Disk class is tested.
  */
 public class Hockey {

	public static void main(String[] args) {
                Puck youthPuck = new Puck(4);
                Puck adultPuck = new Puck(5.5);
                Puck megaPuck = new Puck(1000000);
                Puck duplicatePuck = new Puck(4);
                
                System.out.println(youthPuck.getDivision());
                System.out.println(adultPuck.getDivision());
                System.out.println(megaPuck.getDivision());
                
                System.out.println("The youth puck has a radius of " + youthPuck.getRadius());
                System.out.println(youthPuck.toString());
                
                if(youthPuck.equals(duplicatePuck)){
                    System.out.println("Pucks are the same.");
                }else{
                    System.out.println("Pucks are different");
                }
	}
}
