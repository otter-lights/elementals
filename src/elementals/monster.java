/*
 * Holds info for opponents
 * Nathan
 */
package elementals;

/**
 *
 * @author nathan
 */
public class monster extends being{
    //unique attribute
    protected int health;
    
    
    public monster(String n, double f, double e, double i, double w, int h){
        //same as being
        super(n, f, e, i, w);
        //set health
        health = h;
    }
    //getters and setters
    public int getHealth(){
        return this.health;
    }
    public void setHealth(int h){
        this.health = h;
    }
    
    //returns all the monsters stats in a String
    @Override
    public String toString(){
        return "Name: " + this.name 
            + "\nFire: " + this.fire 
            + "\nWater: " + this.water 
            + "\nIce: " + this.ice 
            + "\nEarth: " + this.earth 
            + "\nHit Points: " + this.health;
    }
}
