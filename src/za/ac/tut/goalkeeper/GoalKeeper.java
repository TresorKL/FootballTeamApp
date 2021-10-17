/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.goalkeeper;

import za.ac.tut.nameException.NameException;
import za.ac.tut.player.Player;

/**
 *
 * @author tresorkl
 */
public class GoalKeeper extends Player {
    
    private int numOfCleanSheets;
    
    
    public GoalKeeper(){
        
    }
    
    public GoalKeeper(String name, double basicSalary, int numOfCleanSheets ) throws NameException{
        super(name, basicSalary);
        this.numOfCleanSheets = numOfCleanSheets;
        
    }

    public int getNumOfCleanSheets() {
        return numOfCleanSheets;
    }

    public void setNumOfCleanSheets(int numOfCleanSheets) {
        this.numOfCleanSheets = numOfCleanSheets;
    }

    @Override
    public String toString() {
        return "GoalKeeper-"+super.toString()  + numOfCleanSheets;
    }
    
    
    
}
