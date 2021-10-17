/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.defender;

import za.ac.tut.nameException.NameException;
import za.ac.tut.player.Player;

/**
 *
 * @author tresorkl
 */
public class Defender  extends Player{
    
    private int numOfGamePlayed ;
    
    public Defender(){
        
    }
    
    public Defender(String name, double basicSalary, int numOfGamePlayed ) throws NameException{
        super(name, basicSalary);
        this.numOfGamePlayed = numOfGamePlayed;
        
    }

    public int getNumOfGamePlayed() {
        return numOfGamePlayed;
    }

    public void setNumOfGamePlayed(int numOfGamePlayed) {
        this.numOfGamePlayed = numOfGamePlayed;
    }

    @Override
    public String toString() {
        return "Defender-"+super.toString() + numOfGamePlayed ;
    }
    
    
    
    
}
