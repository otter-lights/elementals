/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementals;

import java.awt.Color;

/**
 *
 * @author rachelroutly
 */
public class player {
    double fireStat, earthStat, iceStat, waterStat;
    String charName, username, password;
    Color color;
    
    
    public player(String uName, String pWord, String name, int red, int green, int blue, double f, double e, double i, double w){
        username = uName;
        password = pWord;
        charName = name;
        color = new Color(red, green, blue);
        
        fireStat = f;
        earthStat = e;
        iceStat = i;
        waterStat = w;
    } 
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
    public String getCharName(){
        return(charName);
    }
    public void setCharName(String n){
        charName = n;
    }
    public Color getUserColor(){
        return(color);
    }
    public void setUserColor(Color c){
        color = c;
    }
    public double getFire(){
        return(fireStat);
    }
    public void setFire(double f){
        fireStat = f;
    }
    public double getEarth(){
        return(earthStat);
    }
    public void setEarth(double e){
        earthStat = e;
    }       
    public double getIce(){
        return(iceStat);
    }
    public void setIce(double i){
        iceStat = i;
    }   
    public double getWater(){
        return(waterStat);
    }
    public void setWater(double w){
        waterStat = w;
    }   
    @Override
    public String toString(){
        return(username + "\n" + 
                password + "\n" + 
                charName + "\n" + 
                color + "\n" + 
                fireStat + "\n" + 
                earthStat + "\n" + 
                iceStat + "\n" + 
                waterStat);
    }
}

