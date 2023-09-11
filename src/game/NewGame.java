/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Game.g;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author humam.daas
 */
////////////////////////////////////this class receives Grid and arrya of buttons 
public class NewGame {
//    private ImageIcon white  = new ImageIcon("E:\\codejava\\game\\white.JPG");
    
    public NewGame(){}
    
    public Grid grid(Grid newGrid, JButton[][] buttons){
        for(int i=0 ;i<10;i++){
            for(int j = 0;j<10;j++){
                newGrid.cells[i][j].setValue('#');
                newGrid.cells[i][j].setFlag(false);
                newGrid.cells[i][j].setVisible(false);
                buttons[i][j].setText(""); 
                buttons[i][j].setIcon(null);
                buttons[i][j].setContentAreaFilled(true);
            }
        }
        newGrid.bombInit();
        
        return newGrid;
    }
}
