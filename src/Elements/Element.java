/*
 * general for all elements
 * Nathan
 */
package Elements;

/**
 *
 * @author nathan
 */
public abstract class Element {
    //all elements have these attributes
    protected double fireMod, waterMod, iceMod;
    
    public Element(double fm, double  wm, double im){
        //set stats
        fireMod = fm;
        waterMod = wm;
        iceMod = im;
        
    }
    //checks if Elements are the same
    public boolean equals(Element e){
        if(e.getFM() == this.getFM() && e.getWM() == this.getWM() && e.getIM() == this.getIM()){
            return true;
        }
        return false;
    }
        
    //getters/setters
    public double getFM(){
        return fireMod;
    }public void setFM(double fm){
        fireMod = fm;
    }
    
    public double getWM(){
        return waterMod;
    }public void setWM(double wm){
        waterMod = wm;
    }
    
    public double getIM(){
        return iceMod;
    }public void setIM(double im){
        iceMod = im;
    }
    
    //returns only the name of the element
    public String toString(){
        if(this.equals(new Earth())){
            return "Earth";
        }else if(this.equals(new Fire())){
            return "Fire";
        }else if(this.equals(new Water())){
            return "Water";
        }else if(this.equals(new Ice())){
            return "Ice";
        }else{
            return "Unknown";
        }
    }
        
}
