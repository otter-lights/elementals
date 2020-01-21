/*
 * Elementals - Rachel
 * this is the class player that will be referenced when making and interacting with the main character
 * this is an extension of the superclass being, which represents both monsters and players
 */
package elementals;

//imports the use of colors
import java.awt.Color;

/**
 *
 * @author rachelroutly
 */
public class player extends being{
    //creates the variables used only in this class
    String username, password;
    Color color;
    int red, green, blue, exp;
    
    
    public player(String uName, String pWord, String name, int r, int g, int b, double f, double e, double i, double w, int xp){
        //calls the super for the four elements and the name
        super(name, f, e, i, w);
        //sets the username and password
        username = uName;
        password = pWord;
        //sets the colour, and the three RGb values
        color = new Color(r, g, b);
        red = r;
        green = g;
        blue = b;
        //sets the exponent
        exp = xp;
    } 
    //Getters and Setters for each variable exclusive to this class (username, password, color, RGBs, and XP)
    public String getUserName(){
        return(username);
    }
    public void setUserName(String u){
        username = u;
    }  
    public String getPassWord(){
        return(password);
    }
    public void setPassWord(String p){
        password = p;
    }
    public Color getUserColor(){
        return(color);
    }
    public void setUserColor(Color c){
        color = c;
    } 
    public int getRed(){
        return red;
    }
    public void setRed(int r){
        red = r;
    }
    public int getGreen(){
        return green;
    }
    public void setGreen(int g){
        green = g;
    }
    public int getBlue(){
        return blue;
    }
    public void setBlue(int b){
        blue = b;
    }
    public int getXP(){
        return exp;
    }
    public void setXP(int xp){
        exp = xp;
    }
    @Override
    public String toString(){
        return(username + "\n" + 
                password + "\n" + 
                name + "\n" + 
                color + "\n");
    }
}

