/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.middlefielder;

import za.ac.tut.nameException.NameException;
import za.ac.tut.player.Player;

/**
 *
 * @author tresorkl
 */
public class Middlefielder extends Player {
    
   private int numOfAssist;
   
    public Middlefielder(){
        
    }
    
    public Middlefielder(String name, double basicSalary, int numOfCleanSheets ) throws NameException {
        super(name, basicSalary);
        this.numOfAssist = numOfAssist;
        
    }

    public int getNumOfAssist() {
        return numOfAssist;
    }

    public void setNumOfAssist(int numOfAssist) {
        this.numOfAssist = numOfAssist;
    }

    @Override
    public String toString() {
        return "Middlefielder-"+super.toString()  + numOfAssist;
    }
    
    
    
    
    
}
