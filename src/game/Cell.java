/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.JButton;

/**
 *
 * @author humam.daas
 */
public class Cell extends JButton {
 
    //each cell has coordiates , value and visul or not 
    // on cell flag or not
   private int x;
   private int y;
   private char value;
   private boolean isVisible;
   private boolean isFlag;

    public boolean isFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }


    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.value = ' ';
        this.isVisible=false;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
}


