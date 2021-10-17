/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.player;

import za.ac.tut.nameException.NameException;

/**
 *
 * @author tresorkl
 */
public abstract class Player {
    
    private String name;
    private double basicSalary;
    
    public Player(){
        
    }
    
    public Player(String name,double basicSalary) throws NameException{
        
        setName(name);
        this.basicSalary = basicSalary;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NameException {
        
        if(isNameValid(name)){
        this.name = name;
        }else{
            throw new NameException(name + "IS INVALID");
        }
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public String toString() {
        return name + "-" + basicSalary+ "-";
    }
    
    

    private boolean isNameValid(String name) {

        boolean isValid= false;
        
        for(int i=0; i< name.length();i++){
            
            char charAtIndex = name.charAt(i);
            
            if(Character.isLetter(charAtIndex)){
                isValid= true;
            }
        }
        
        return isValid;
    }

    
    
    
    
}
