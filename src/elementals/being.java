/*
 * Holds attributes common between monsters and players
 * Nathan
 */
package elementals;

/**
 *
 * @author nathan
 */
public abstract class being {
    //every being has these attributes
    protected String name;
    protected double fire, earth, ice, water;

    public being(String n, double f, double e, double i, double w){
        //set name
        name = n;
        //set elemental powers
        fire = f;
        earth = e;
        ice = i;
        water = w;
    }
    //getter/setters for everything
    public String getName(){
        return(this.name);
    }
    public void setName(String n){
        this.name = n;
    }
    
    public double getFire(){
        return this.fire;
    }
    public void setFire(double f){
        this.fire = f;
    }
    public double getEarth(){
        return this.earth;
    }
    public void setEarth(double e){
        this.earth = e;
    }
    public double getIce(){
        return this.ice;
    }
    public void setIce(double i){
        this.ice = i;
    }
    public double getWater(){
        return this.water;
    }
    public void setWater(double w){
        this.water = w;
    }
    
    //returns all attributes in a String
    @Override
    public String toString(){
        return "Name: " + this.name 
            + "\nFire: " + this.fire 
            + "\nWater: " + this.water 
            + "\nIce: " + this.ice 
            + "\nEarth: " + this.earth;
    }
            
}
