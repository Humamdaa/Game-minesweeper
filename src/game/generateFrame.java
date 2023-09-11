/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Game.buttons;
import static game.Game.g;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author humam.daas
 */
public class generateFrame extends JFrame {
    private ImageIcon back  = new ImageIcon("E:\\codejava\\game\\back.JPG");
    private ImageIcon clock = new ImageIcon("E:\\codejava\\game\\clock.JPG");
    private ImageIcon imgBOOMB = new ImageIcon("E:\\codejava\\game\\BOOMB.JPEG");
    private ImageIcon imgPause = new ImageIcon("E:\\codejava\\game\\Pause.JPG");
    private ImageIcon imgSave = new ImageIcon("E:\\codejava\\game\\save.png");
    private Image imgico = imgBOOMB.getImage();
    private JLabel labB;
    private JLabel labC;
    private JLabel labPause_Play;
    private generateTabFile table  = new generateTabFile();
        
        
    public generateFrame(){
        
        setLayout(new GridLayout(11,10));//4
        setSize(600,600);//1
        System.out.println(imgSave.getIconWidth());
        System.out.println(imgSave.getIconHeight());
//        add panels to frame :
        for(int i = 0 ; i < 10; i++){
            add(Game.arrPan[i] = new JPanel());
            Game.arrPan[i].setBackground(new java.awt.Color(204,204,255));
        }
        
        //        add buttons to frame :
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                add(buttons[i][j] = new JButton());//,3   
            }
        }
//        define label
        labB = new JLabel();
        labC = new JLabel();
        labPause_Play = new JLabel();
        
//        add icon to label
        labB.setIcon(back);
        labC.setIcon(clock);
        labPause_Play.setIcon(imgPause);
//        from simpel cursor to hand cursor :
        labB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labPause_Play.setCursor(new Cursor(Cursor.HAND_CURSOR));

//      put icon on panels :  
        Game.arrPan[0].add(labB);
        Game.arrPan[9].add(labC);
        Game.arrPan[4].add(labPause_Play);

//      cancle zoom
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        title of frame
        setTitle("Minesweeper");
//        icon of frame
        setIconImage(imgico);
        new mouseClicking();
        
//      add mouse listener(click) for label (labB) :   
        labB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labBMouseClicked(evt);
            }
        });
        labPause_Play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labPause_PlayMouseClicked(evt);
            }
        });

    }
    private void labBMouseClicked(java.awt.event.MouseEvent evt) {
        dispose();
        startGame start = new startGame();
        start.setVisible(true);
    }
    private void labPause_PlayMouseClicked(java.awt.event.MouseEvent evt) {
       pauseGameFrame pgf = new pauseGameFrame();
       pgf.setVisible(true);
       pgf.set_vis(true);
    }

}

