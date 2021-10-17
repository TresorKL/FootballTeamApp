/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.striker;

import za.ac.tut.nameException.NameException;
import za.ac.tut.player.Player;

/**
 *
 * @author tresorkl
 */
public class Striker extends Player{
    
    private int numOfGoals;
    
      public Striker(){
        
    }
    
    public Striker(String name, double basicSalary, int numOfGoals ) throws NameException {
        super(name, basicSalary);
        this.numOfGoals = numOfGoals;
        
    }

    public int getNumOfGoals() {
        return numOfGoals;
    }

    public void setNumOfGoals(int numOfGoals) {
        this.numOfGoals = numOfGoals;
    }
    
    

    @Override
    public String toString() {
        return "Striker-" +super.toString() + numOfGoals;
    }
    
    
    
}
