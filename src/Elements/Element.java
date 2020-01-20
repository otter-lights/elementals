/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elements;

/**
 *
 * @author nathan
 */
public class Element {
    protected double fireMod, waterMod, iceMod;
    
    public Element(double fm, double  wm, double im){
        fireMod = fm;
        waterMod = wm;
        iceMod = im;
        
    }
    
    public boolean equals(Element e){
        if(e.getFM() == this.getFM() && e.getWM() == this.getWM() && e.getIM() == this.getIM()){
            return true;
        }
        return false;
    }
        
    
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
}
