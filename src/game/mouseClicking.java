/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Game.buttons;
import static game.Game.g;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author humam.daas
 */
public class mouseClicking {
    private static int count = 0;
//      definition of pictures
    private ImageIcon imgFLAG = new ImageIcon("E:\\codejava\\game\\FLAG.JPEG");
    private ImageIcon imgBOOMB = new ImageIcon("E:\\codejava\\game\\BOOMB.JPEG");
    private ImageIcon smileWin = new ImageIcon("E:\\codejava\\game\\smileWin.JPG");
    private ImageIcon smileGameOver = new ImageIcon("E:\\codejava\\game\\smileGameOver.JPG");
    private ImageIcon error1 = new ImageIcon("E:\\codejava\\game\\error.PNG");
//      obj Game over and win
    private frameGameOver GameOver = new frameGameOver();
    private frameWin win = new frameWin();
    SaveGame save = new SaveGame();
    public void set_count(int cnt){
        this.count = cnt;
    }
    //code mouse clicked starts :
    public mouseClicking (){  
//           
//        
        MouseListener mouselistener = new MouseListener() {            
           
            @Override
            public void mouseClicked(MouseEvent e) {
//                System.out.println("count " + count + "  cells " + g.unCheckedCells());
                System.out.println(save.get_clickOnSave());
                if(g.unCheckedCells() == 100 || save.get_clickOnSave()){
                    new startCounter();
                    save.set_clickOnSave(false);
                }
                if(SwingUtilities.isRightMouseButton(e)){
//                    count++;    
                    for(int i=0;i<10;i++){
                        for(int j=0;j<10;j++){
//                                put flag :
                            if (e.getSource() == buttons[i][j]){
                                if(!g.cells[i][j].isFlag() && !g.cells[i][j].isVisible()){
                                    g.cells[i][j].setFlag(true);
                                    buttons[i][j].setIcon(imgFLAG);
                                }
                                else if(g.cells[i][j].isFlag() && !g.cells[i][j].isVisible() && g.unCheckedCells() != 10){
                                    g.cells[i][j].setFlag(false);
                                    buttons[i][j].setIcon(null);
                                }
                            }
                        }
                    }
                } 
                if(SwingUtilities.isLeftMouseButton(e) ){
//                    count++;    
                    for(int i=0;i<10;i++){
                        for(int j=0;j<10;j++){
                            if (e.getSource() == buttons[i][j]) {
                                char cha = g.cells[i][j].getValue();
                                if(cha == 'B' && g.unCheckedCells() != 10)
                                {
                                    count = 0;
                                    for( i=0;i<10;i++){
                                        for(j = 0;j<10;j++){
                                            if(g.cells[i][j].isFlag() && g.cells[i][j].getValue() != 'B'){
                                               buttons[i][j].setIcon(error1);
                                               g.cells[i][j].setVisible(true);
                                            }
                                            else{
                                                buttons[i][j].setContentAreaFilled(false);
                                                g.cells[i][j].setVisible(true);
                                                buttons[i][j].setFocusable(false);
                                                char charboomb = g.cells[i][j].getValue();
                                                if(charboomb == 'B' && !g.cells[i][j].isFlag()){
                                                    buttons[i][j].setIcon(imgBOOMB);
                                                }
                                            }
                                        }
                                    }
                                    break;
                                }
                                if(!g.cells[i][j].isVisible() && cha != 'B'){
//                                        convert char to string and send to under button
                                    char ch = g.cells[i][j].getValue();
                                    String str = String.valueOf(ch);
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
                                            buttons[i][j].setForeground(new java.awt.Color(153, 0, 153));          
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
                                            buttons[i][j].setForeground(new java.awt.Color(0, 153, 153));
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
                                                        buttons[x][y].setForeground(new java.awt.Color(153, 0, 153));          
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
                                                        buttons[x][y].setForeground(new java.awt.Color(0, 153, 153));
                                                    }

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                winOrLose();
            }
            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
            public void winOrLose(){
                if(g.AllIsVisible()){
                    GameOver.setTitle("GameOver...");
                    Image imgiconGameOver = error1.getImage();
                    GameOver.setIconImage(imgiconGameOver);
                    GameOver.setVisible(true);

                } 

                if(g.unCheckedCells() == 10)
                {
                    count = 0;
                    for(int k=0;k<10;k++){
                        for(int k1=0;k1<10;k1++){
                           buttons[k][k1].setContentAreaFilled(false);
                       }
                   }
                   win.setTitle("Congratulation");
                   Image imgIconWin = smileWin.getImage();
                   win.setIconImage(imgIconWin);
                   win.setVisible(true);
                   }
            }
            
            
        };
        
    //        to add mous listener to all buttons 
        for(int i= 0;i<10;i++)
                for(int j=0;j<10;j++)
                    buttons[i][j].addMouseListener(mouselistener);
        
   }
    
    private void text1MouseClicked(java.awt.event.MouseEvent evt) {                                   
        evt.consume();
    }                                  
    private void text1MousePressed(java.awt.event.MouseEvent evt) {                                   
        evt.consume();
    } 
    private void text1KeyPressed(java.awt.event.KeyEvent evt) {                                 
        evt.consume();
    }                                

    private void text1KeyTyped(java.awt.event.KeyEvent evt) {                               
       evt.consume();
    }
    //////////////////////////////////////////////
}
