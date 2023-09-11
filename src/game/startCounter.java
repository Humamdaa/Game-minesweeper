/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import static game.Game.buttons;
import static game.Game.g;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author humam.daas
 */
public class startCounter {
    private static boolean addedCounterLabel = true;
    JLabel counterLabel;
    Timer timer;	
    private static int  second = 0, minute = 0;
    String ddSecond, ddMinute;	
    DecimalFormat dFormat = new DecimalFormat("00");
    private pauseGameFrame  pause = new pauseGameFrame();
    public startCounter(){
        counterLabel = new JLabel("");
        Font font = new Font("SansSerif", Font.BOLD, 20);
        counterLabel.setFont(font);
//                counterLabel.setBounds(300, 230, 250, 150);
//		counterLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		counterLabel.setVerticalAlignment(SwingConstants.CENTER);
		

//// Enable this to use Normal Timer
//		counterLabel.setText("00:00");
        Game.arrPan[8].removeAll();
        if(addedCounterLabel){
            Game.arrPan[8].add(counterLabel);
            addedCounterLabel = false;
        }                
        normalTimer();
        timer.start();
    }
    public int get_second(){
        return second;
    }
    public void get_second(int s){
        second = s;
    }
    public void set_second(int m){
        minute = m;
    }
    public int get_minute(){
        return minute;
    }
    public void normalTimer() {
        timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
//            System.out.println("pause " + pause.get_vis());
//            System.out.println("cells " + g.unCheckedCells());
            if(g.unCheckedCells() <= 99 && g.unCheckedCells() > 10 && pause.get_vis() == false){
                startTimer();
            }
            if(g.unCheckedCells() == 100)
                pauseTimer();
            else if(g.unCheckedCells() == 10 || g.unCheckedCells() == 0){
                pauseTimer();
               
            }

        }
    });
    }
    private void startTimer(){
        second++;
        ddSecond = dFormat.format(second);
        ddMinute = dFormat.format(minute);
//        Game.arrPan[8].add(counterLabel);
        counterLabel.setText(ddMinute + ":" + ddSecond);
        if(second == 60) {
            second = 0;
            minute++;

            ddSecond = dFormat.format(second);
            ddMinute = dFormat.format(minute);
//                                        
            counterLabel.setText(ddMinute + ":" + ddSecond);
//            Game.arrPan[8].add(counterLabel);
            
        }
        System.out.println("second in start : " + second);
    }
    private void pauseTimer(){
        timer.stop();
        addedCounterLabel = true;
        second = 0 ; minute = 0;
        ddSecond = dFormat.format(second);
        ddMinute = dFormat.format(minute);
//        counterLabel.setText(ddSecond + ":" + ddMinute);
    }
}
