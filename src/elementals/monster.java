/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementals;

/**
 *
 * @author nathan
 */
public class monster extends being{
    
    protected int health;
    
    
    public monster(String n, double f, double e, double i, double w, int h){
        
        super(n, f, e, i, w);
        
        health = h;
    }
    
    public int getHealth(){
        return this.health;
    }
    public void setHealth(int h){
        this.health = h;
    }
    
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
