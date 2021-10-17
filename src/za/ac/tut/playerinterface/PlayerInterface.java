/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.playerinterface;

import java.io.File;
import java.util.List;
import za.ac.tut.player.Player;
import za.ac.tut.striker.Striker;

/**
 *
 * @author tresorkl
 */
public interface PlayerInterface {
    
    public void populatePlayers(File playersFile,List<Player>players);
    public void determineTotalPayment(List<Player>players, List<Double>salaries);
    public double determineMonthlyCost(List<Double>salaries);
    public Striker determineBestStricker(List<Player>players);
    public void extractPlayers(File playersFile,List<Player>players);
}
