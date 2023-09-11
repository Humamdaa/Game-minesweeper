/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Game.buttons;
import static game.Game.g;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author humam.daas
 */
public class loadGame {
    JFrame frame = new JFrame();
    ImageIcon imgFLAG = new ImageIcon("E:\\codejava\\FLAG.JPEG");
    private Grid gr = new Grid();
    private JButton but[][] = new JButton [10][10];
    public loadGame(){
        NewGame neGa = new NewGame();
        neGa.grid(g, buttons);
    }
    public Grid readGridFromFile(){
        try {
//              load grid :
            FileInputStream fi = new FileInputStream(new File("gridSaved.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            gr = (Grid)oi.readObject();
            for(int i = 0 ; i < 10 ; i++){
                for(int j = 0 ; j < 10 ;j++){
                    g.cells[i][j] = gr.cells[i][j];
                }
            }
            oi.close();fi.close();
        }catch (FileNotFoundException e0) {
            e0.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
        }
        return gr;
    }
    public void readSecond_Minute(){
        
    }
    
}
