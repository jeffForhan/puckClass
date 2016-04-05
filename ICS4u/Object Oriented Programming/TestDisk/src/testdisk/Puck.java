
package testdisk;

/**
 *
 * @author Jeffrey Forhan
 */
public class Puck extends Disk{
    private double weight;
    private boolean youth;
    private boolean standard;
    /**
     * Description: The Puck class constructor
     * Pre: None 
     * Post: Creates a new puck object
     * @param w The weight of the puck
     */
    Puck(double w){
        super(1.5,1);
        weight = w;
        setDivision();
    }
    /**
     * Description: Gets the puck's weight
     * Pre: None
     * Post: Gets the value of the weight variable
     * @return the weight of the puck
     */
    public double getWeight(){
        return(weight);
    }
    /**
     * Description: Sets the classification of the puck
     * Pre: None
     * Post: Sets the classification for the puck
     * @return the division classification of the puck
     */
    public String getDivision(){
        if(youth == true){
            return "Youth";
        }else if(standard == true){
            return "Standard";
        }else{
            return "Unofficial";
        }
    }
    /**
     * Description: Determines the class division of the puck
     * pre: None
     * post: Returns the puck's division classification
     */
    public void setDivision(){
        if(4 > weight && weight < 4.5){
            youth = true;
            standard = false;
        }else if(5 < weight && weight < 5.5){
            youth = false;
            standard = true;
        }else{
            youth = false;
            standard = false;
        }
    }
    /**
     * description: Determines if two pucks are equal
     * Pre: None
     * Post: Compares two pucks
     * @param obj the object to compare to
     * @return If the pucks are the same
     */
    public boolean equals(Object obj){
        Puck otherPuck = (Puck)obj;
        if(otherPuck.getWeight() == getWeight()){
            return(true);
        }else{
            return(false);
        }
    }
    /**
     * description: Gives information about a puck object
     * Pre: None
     * Post: Returns the radius, thickness, and the weight of the puck
     * @return A String holding a description of the puck
     */
    public String toString(){
        String puckString;
        
        puckString = "This puck has a radius of 1.5 inches, a thickness of 1 inch, and a weight of " + getWeight();
        
        return puckString;
    }
}
