/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Game.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author humam.daas
 */
public class SaveGame {
    private static boolean click = false;
    public SaveGame(){}
    public void recieveGridTosaveInFile(Grid g){
         try {
//                            save grid 
            FileOutputStream f = new FileOutputStream(new File("gridSaved.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f) ;
            o.writeObject(g);
            o.close();f.close();
        } catch (FileNotFoundException ex) {}
         catch(IOException e){}
        click = true;
    }
    public void receiveSecond_Minute(int s, int m){
        startCounter start = new startCounter();
        System.out.println("second : " + start.get_second());
        System.out.println("miunute : " + start.get_minute());
         try {
            FileWriter writer = new FileWriter("second.txt");
            writer.write(Integer.toString(start.get_second()));
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
          try {
            FileWriter writer = new FileWriter("minute.txt");
            writer.write(Integer.toString(start.get_minute()));
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
         
    }
    public boolean get_clickOnSave(){
        return click;
    }
    public void set_clickOnSave(boolean c){
        click = c;
    }
}
