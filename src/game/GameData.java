/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author humam.daas
 */
public class GameData implements java.io.Serializable{
    
    public ArrayList<Player>players;
    Player currentPlayer;
    public int numOfplayer;
    
    public Cell[][]cells;
    public int gridCol;
    public int gridRow;
     
    
    
}
