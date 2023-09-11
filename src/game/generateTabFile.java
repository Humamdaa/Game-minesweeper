/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author humam.daas
 */
public class generateTabFile {
    private JMenuBar bar = new JMenuBar();
    private JMenu File = new JMenu("File");
    private JMenuItem newGame = new JMenuItem("newGame");
    private JMenuItem Load = new JMenuItem("Load");
    private JMenuItem Save = new JMenuItem("Save");
    private ImageIcon imgSave = new ImageIcon("E:\\codejava\\game\\save.png");
//    small size widt = 50,  height = 30
    private ImageIcon imgNewGame = new ImageIcon("E:\\codejava\\game\\iconNew.jpg");
//    small size widt = 50,  height = 30
    private ImageIcon imgLoad = new ImageIcon("E:\\codejava\\game\\iconLoad.jpg");

    
//funtions get :
    public JMenuBar getBar (){
        return bar;
    }
    public JMenu getFile(){
        return File;
    }
    public JMenuItem getSave(){
        Save.setIcon(imgSave);
        return Save;
    }
    public JMenuItem getnewGame(){
        newGame.setIcon(imgNewGame);
        return newGame;
    }
    public JMenuItem getLoad(){
        Load.setIcon(imgLoad);
        return Load;
    }
    generateTabFile(){
//          menu
            File.add(newGame);
            File.add(Save);
            File.add(Load);
//            add menu to bar
            bar.add(File);
    }
}
