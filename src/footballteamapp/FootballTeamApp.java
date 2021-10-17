/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballteamapp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import za.ac.tut.player.Player;
import za.ac.tut.playerprocessor.PlayerProcessor;
import za.ac.tut.striker.Striker;

/**
 *
 * @author tresorkl
 */
public class FootballTeamApp {

    /**
     * @param args the command line arguments
     */
    public static int MenuOpt(){
        int option =0;
        boolean isValid = true;
        
        do{
        
        option = Integer.parseInt(JOptionPane.showInputDialog(null, "1 --- ADD PLAYERS"+"\n"+"2 --- DISPLAY BEST STRIKER"+"\n"
                                                                        +"3 --- DISPLAY SALARIES"+"\n"+"4 --- DISPLAY MONTHLY COST"+"\n"+
                                                                            "5 --- EXIT"));
        
        if(option>= 1 && option<=5 ){
            isValid = true;
        }else{
            
            isValid = false;
            JOptionPane.showMessageDialog(null, option+  "IS INVALID CHOOSE BETWEEN 1 AND 5");
            
        }
        }while(!isValid);
        return option;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        File playersFile = new File("./playersFile.txt");
        List<Player>players = new ArrayList<>();
        List<Double>salaries = new ArrayList<>();
        int manuOpt = MenuOpt();
        
        while(manuOpt != 5){
            
            PlayerProcessor pp = new PlayerProcessor();
            
            
            if(manuOpt == 1){
                
                pp.populatePlayers(playersFile, players);
                
                JOptionPane.showMessageDialog(null, "PLAYERS SUCCESSFULLY ADDED");
                
            }if(manuOpt == 2){
                
               Striker striker = new Striker();
               
              players.clear();
               
               pp.extractPlayers(playersFile, players);
               
               
               striker = pp.determineBestStricker(players);
               
               JOptionPane.showMessageDialog(null, "STRIKER NAME: "+striker.getName()+"\n"+
                                                   "NUM OF GOALS: "+striker.getNumOfGoals());
                
            }if(manuOpt == 3){
                
               players.clear();
               
               pp.extractPlayers(playersFile, players);
                pp.determineTotalPayment(players, salaries);
                String data ="";
                for(int i=0; i< salaries.size();i++){
                    
                    
                    data = data + ("PLAYER "+(i+1)+salaries.get(i)).concat("\n\n");
                }
                
                JOptionPane.showMessageDialog(null, data);
            }if(manuOpt == 4){
                
               players.clear();
               
               pp.extractPlayers(playersFile, players);
                pp.determineTotalPayment(players, salaries);
                double monthlyCost =0.0;
                
                
                JOptionPane.showMessageDialog(null, monthlyCost);
            }
            
            manuOpt = MenuOpt();
            
            
        }
        
         JOptionPane.showMessageDialog(null, "GOOD BYE");
        
    }
    
}
