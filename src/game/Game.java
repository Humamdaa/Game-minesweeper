/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/*import javafx.scene.paint.Color;*/
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


 
public class Game implements ActionListener{
    public static Grid g = new Grid();
    public static JButton buttons[][] = new JButton[10][10];
    public static JPanel arrPan[] = new JPanel[10];
    static int dx[] = {1,1,1,0,0,-1,-1,-1};
    static int dy[] = {1,0,-1,1,-1,1,0,-1};
   
    
    
    public static void play_On_Console(){
        Scanner in = new Scanner(System.in);
        g.bombInit(); // in class grid
        g.print();    // in class grid
// to play on the consle:
            while(true) {
                System.out.println("Enter Row and Col");
                int x = in.nextInt();
                int y = in.nextInt();
                System.out.println("Enter 1 for flag \n 2 for normal :");
                int z = in.nextInt();
                if(z == 1)
                {
                    g.cells[x][y].setFlag(g.cells[x][y].isFlag()?false:true);
                    g.print();
                    continue;
                }
                if(g.cells[x][y].getValue() == 'B')
                {
                    g.visibleAll();
                    g.print();
                    System.out.println("Game over!");
                    break;
                }
                if(!g.cells[x][y].isFlag())
                    g.floodFill(x, y);
                g.print();
                if(g.unCheckedCells() == 10)
                {
                    System.out.println("you Wins!");
                    break;
                }
            }
        }
    
    public static void fixGridAfterLoadGame(){
        ImageIcon imgFLAG = new ImageIcon("E:\\codejava\\game\\FLAG.JPEG");
        for(int i = 0 ; i < 10; i++){
            for(int j = 0 ; j < 10;j++){
                if(g.cells[i][j].isVisible()){
                    char ch = g.cells[i][j].getValue();
                    String str = "";
                    str += ch;
                    buttons[i][j].setContentAreaFilled(false);

                /////////////////////////////////////////////                               
                    if(ch != '0'){
                        //buttons[i][j].setBackground(Color.black);
                        buttons[i][j].setText(str);
                        buttons[i][j].setIcon(null);
                        g.cells[i][j].setVisible(true);
                        buttons[i][j].setContentAreaFilled(false);
                        buttons[i][j].setFocusable(false);
                        if(g.cells[i][j].getValue() == '1'){
                            buttons[i][j].setForeground(Color.BLUE);
                        }
                        else if(g.cells[i][j].getValue() == '2') { 
                            buttons[i][j].setForeground(Color.YELLOW);          
                        }
                        else if(g.cells[i][j].getValue() == '3') {
                            buttons[i][j].setForeground(Color.ORANGE);
                        } 
                        else if(g.cells[i][j].getValue() == '4') {
                            buttons[i][j].setForeground(Color.RED);
                        }
                        else if(g.cells[i][j].getValue() == '5') {
                            buttons[i][j].setForeground(Color.CYAN);
                        }
                        else if(g.cells[i][j].getValue() == '6') {
                            buttons[i][j].setForeground(Color.PINK);
                        }
                        else if(g.cells[i][j].getValue() == '7') {
                            buttons[i][j].setForeground(Color.BLACK);
                        }
                        else if(g.cells[i][j].getValue() == '8') {
                            buttons[i][j].setForeground(Color.DARK_GRAY);
                        }
                    }
                    else if(ch == '0'){
                        g.floodFill(i, j);
                        for(int x = 0;x<10;x++){
                            for(int y=0;y<10;y++){
                                char ch1 = g.cells[x][y].getValue();
                                String str1 = String.valueOf(ch1);
                                if(g.cells[x][y].isVisible()){
                                    buttons[i][j].setFocusable(false); 
                                    buttons[x][y].setContentAreaFilled(false);
                                    if(ch1 != '0'){
                                        buttons[x][y].setText(str1);
                                    }
                                    if(g.cells[x][y].getValue() == '1'){
                                        buttons[x][y].setForeground(Color.BLUE);
                                    }
                                    else if(g.cells[x][y].getValue() == '2') { 
                                       buttons[x][y].setForeground(Color.YELLOW);          
                                    }
                                    else if(g.cells[x][y].getValue() == '3') {
                                        buttons[x][y].setForeground(Color.ORANGE);
                                    } 
                                    else if(g.cells[x][y].getValue() == '4') {
                                        buttons[x][y].setForeground(Color.RED);
                                    }
                                    else if(g.cells[x][y].getValue() == '5') {
                                        buttons[x][y].setForeground(Color.CYAN);
                                    }
                                    else if(g.cells[x][y].getValue() == '6') {
                                        buttons[x][y].setForeground(Color.PINK);
                                    }
                                    else if(g.cells[x][y].getValue() == '7') {
                                        buttons[x][y].setForeground(Color.BLACK);
                                    }
                                    else if(g.cells[x][y].getValue() == '8') {
                                        buttons[x][y].setForeground(Color.DARK_GRAY);
                                    }

                                }
                            }
                        }
                    }
                /////////////////////////////////////////////////////
                }
                else if(g.cells[i][j].isFlag())
                    buttons[i][j].setIcon(imgFLAG);
            }
        }
    }
////main
    public static void main(String[] args) {
//        play_On_Console();
//      play on frame :
//
        startGame sG = new startGame();
        sG.setVisible(true);
        
    }
        
    @Override
        public void actionPerformed(ActionEvent e) {
        }

   /// send Grid and send buttons to create new game if you lose or win:
    public Grid sendGrid(){
        return g;
    }
    public JButton[][] sendButtons(){
        return buttons;
    }
   
   
}

    


