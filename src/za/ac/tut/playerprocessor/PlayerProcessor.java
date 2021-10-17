/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.playerprocessor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import za.ac.tut.defender.Defender;
import za.ac.tut.goalkeeper.GoalKeeper;
import za.ac.tut.middlefielder.Middlefielder;
import za.ac.tut.nameException.NameException;
import za.ac.tut.player.Player;
import za.ac.tut.playerdatainterface.PlayerDataInterface;
import za.ac.tut.playerinterface.PlayerInterface;
import za.ac.tut.striker.Striker;

/**
 *
 * @author tresorkl
 */
public class PlayerProcessor implements PlayerInterface, PlayerDataInterface {

    
    
    public PlayerProcessor(){
        
        
    }
    
     @Override
    public void populatePlayers(File playersFile, List<Player> players) {
       Boolean keepAdding = true;
        
       do{
        int choicePlayer = Integer.parseInt(JOptionPane.showInputDialog(null,"1 -- DEFENDER "+"\n"+
                                                                             "2 -- GOALKEEPER"+"\n"+
                                                                             "3 -- MIDDLEFIELD "+"\n"+
                                                                             "4 -- STRICKER"+"\n"
                                                                            +"5 -- STOP ADDING PLAYERS","SPECIFY THE PLAYE YOU WANT TO ADD",JOptionPane.INFORMATION_MESSAGE));
        if(choicePlayer==1){
            
            String name = JOptionPane.showInputDialog(null,"ENTER PLAYER NAME");
            double basicSalary = Double.parseDouble(JOptionPane.showInputDialog(null,"ENTER BASIC SALARY"));
            int numOfGamePlated = Integer.parseInt(JOptionPane.showInputDialog(null,"ENTER THE NUM OF GAME PLAYED"));
            
            keepAdding = true;
            
            try {
                
              Player defender = new Defender(name,basicSalary,numOfGamePlated);
              players.add(defender);
            } catch (NameException ex) {
                Logger.getLogger(PlayerProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        }if (choicePlayer==2){
            
            String name = JOptionPane.showInputDialog(null,"ENTER PLAYER NAME");
            double basicSalary = Double.parseDouble(JOptionPane.showInputDialog(null,"ENTER BASIC SALARY"));
            int numOfCleanSheet = Integer.parseInt(JOptionPane.showInputDialog(null,"ENTER THE NUM OF CLRAN SHEETS"));
            
    
            keepAdding = true;
            try {
                
              Player goalKeeper = new GoalKeeper(name,basicSalary,numOfCleanSheet);
              
              players.add(goalKeeper);
            } catch (NameException ex) {
                Logger.getLogger(PlayerProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        }if (choicePlayer==3){
            
            String name = JOptionPane.showInputDialog(null,"ENTER PLAYER NAME");
            double basicSalary = Double.parseDouble(JOptionPane.showInputDialog(null,"ENTER BASIC SALARY"));
            int numOfAssists = Integer.parseInt(JOptionPane.showInputDialog(null,"ENTER THE NUM OF ASSISTS"));
            
            keepAdding = true;
            
            try {
                
              Player middlefielder = new Middlefielder(name,basicSalary,numOfAssists);
              
              players.add(middlefielder);
            } catch (NameException ex) {
                Logger.getLogger(PlayerProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        }if (choicePlayer==4){
            
            String name = JOptionPane.showInputDialog(null,"ENTER PLAYER NAME");
            double basicSalary = Double.parseDouble(JOptionPane.showInputDialog(null,"ENTER BASIC SALARY"));
            int numOfGoalScored = Integer.parseInt(JOptionPane.showInputDialog(null,"ENTER THE NUM OF GOALS SCPRED"));
            
            keepAdding = true;
            
            try {
                
              Player striker = new Striker(name,basicSalary,numOfGoalScored);
              players.add(striker);
                
            } catch (NameException ex) {
                Logger.getLogger(PlayerProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        }if (choicePlayer==5){
            
            
            keepAdding = false;
        }
        
       }while(keepAdding);
       
       try{
           
           BufferedWriter bw = new BufferedWriter(new FileWriter(playersFile));
           
           String records ="";
           
           for(int i=0; i< players.size();i++){
              
               records = records +( players.get(i).toString()) +"\n";
             
           }
           
             bw.write(records);
             
             bw.close();
           
       }catch(IOException ex){
           System.out.print(ex.getMessage());
       }
        
    }
    
    
    
    
      @Override
    public void extractPlayers(File playersFile, List<Player> players) {
        
       
        
        try{
        String records  ="";
          BufferedReader br = new BufferedReader(new FileReader(playersFile));
           String data ="";
          //data = br.readLine();
          
         int size=0;
         
          while((data = br.readLine()) != null){
              
               data = data+ (data).concat("#");
                
               br.readLine();
          
        
          }
          String [] allPlayers   = data.split("#");
          
          for(int i=0; i<allPlayers.length;i++ ){
              
              String [] uniquePlayer = allPlayers[i].split("-");
              
              for(int j=0; j< uniquePlayer.length;j++){
                 
                  if(uniquePlayer[0].equals("Defender")){
                      
                      String name = uniquePlayer[1];
                      double basicSalary = Double.parseDouble(uniquePlayer[2]);
                      int numOfGamesPlayed = Integer.parseInt(uniquePlayer[3]);
                      
                      Player defender = new Defender(name,basicSalary,numOfGamesPlayed);
                      players.add(defender);
                      
                      
                  }else if(uniquePlayer[0].equals("GoalKeeper")){
                      String name = uniquePlayer[1];
                      double basicSalary = Double.parseDouble(uniquePlayer[2]);
                      int numCleanSheets = Integer.parseInt(uniquePlayer[3]);
                      
                      Player goalKeeper = new GoalKeeper(name,basicSalary,numCleanSheets);
                      players.add(goalKeeper);
                      
                  }else if(uniquePlayer[0].equals("Middlefielder")){
                      String name = uniquePlayer[1];
                      double basicSalary = Double.parseDouble(uniquePlayer[2]);
                      int numOfAssists = Integer.parseInt(uniquePlayer[3]);
                      
                      Player middlefielder = new Middlefielder(name,basicSalary,numOfAssists);
                      players.add(middlefielder);
                      
                  }else if(uniquePlayer[0].equals("Striker")){
                      String name = uniquePlayer[1];
                      double basicSalary = Double.parseDouble(uniquePlayer[2]);
                      int numOfGoals = Integer.parseInt(uniquePlayer[3]);
                      
                      Player striker = new Striker(name,basicSalary,numOfGoals);
                      players.add(striker);
                      
                  }
                  
              }
              
          }
          
          
          br.close();
        
        
          
        }catch(Exception ex){
             System.out.print(ex.getMessage());
        }
    }

   
    
    @Override
    public void determineTotalPayment(List<Player> players, List<Double> salaries) {
        
        for(int i=0;i<players.size();i++){
            
            Player player = players.get(i);
            
            if(player instanceof Defender){
                Double defenderTotal =0.0;
                Defender df = (Defender)player;
                
                
                defenderTotal = df.getBasicSalary() + (DEFENDER_BONUS_RATE * df.getBasicSalary() * df.getNumOfGamePlayed());
                
                 salaries.add(defenderTotal);
                 
            }else if(player instanceof GoalKeeper){
                
                Double goalKeeperTotal =0.0;
                GoalKeeper gp = (GoalKeeper)player;
                
                
                goalKeeperTotal = gp.getBasicSalary() + (DEFENDER_BONUS_RATE * gp.getBasicSalary() * gp.getNumOfCleanSheets());
                salaries.add(goalKeeperTotal);
                
            }else if(player instanceof Middlefielder){
                
                Double mdTotal =0.0;
                Middlefielder md = (Middlefielder)player;
                
                
                mdTotal = md.getBasicSalary() + (DEFENDER_BONUS_RATE * md.getBasicSalary() * md.getNumOfAssist());
                salaries.add(mdTotal);
                
            }else if(player instanceof Striker){
                
                Double strikerTotal =0.0;
                Striker strker = (Striker)player;
                
                
                strikerTotal = strker.getBasicSalary() + (DEFENDER_BONUS_RATE * strker.getBasicSalary() * strker.getNumOfGoals());
                salaries.add(strikerTotal);
                
                
                
            }
            
        }
        
              
       
        
    }

    @Override
    public double determineMonthlyCost(List<Double> salaries) {
        double monthlyCost =0.0;
        
        for(int i=0; i< salaries.size(); i++){
            
            monthlyCost += salaries.get(i);
        }
        
        return monthlyCost;
    }

    @Override
    public Striker determineBestStricker(List<Player> players) {
       
        List<Striker> strikers = new ArrayList<>();
        
        for(int i=0; i < players.size();i++){
            Player player = players.get(i);
            
            if(player instanceof Striker){
                
                Striker striker = (Striker)player;
                
                strikers.add(striker);
            }
        }
        
        
        for(int j=0; j< strikers.size(); j++){
            
            for(int t=j+1; t< strikers.size(); t++){
            
            if(strikers.get(j).getNumOfGoals()<strikers.get(t).getNumOfGoals()){
                
                strikers.set(t, strikers.get(j));
                strikers.set(j, strikers.get(t));
                
                
                
            }
        }
        }
        
        return strikers.get(0);
    }

  
}
