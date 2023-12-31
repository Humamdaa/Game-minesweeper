/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Game.buttons;
import static game.Game.fixGridAfterLoadGame;
import static game.Game.g;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import javax.swing.ImageIcon;

/**
 *
 * @author humam.daas
 */
public class startGame extends javax.swing.JFrame {

    private String youtube = "https://www.youtube.com/watch?v=7B85WbEiYf4&pp=ygUaaG93IGkgcGxheSBtaW5zd2VlcGVyIGdhbXM%3D";
    private ImageIcon imgStart = new ImageIcon("E:\\codejava\\game\\SmileW.JPG");
    private Image imgForStart = imgStart.getImage();
    public startGame() {
        initComponents();
        setIconImage(imgForStart);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bntStartGame = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("let's Start");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bntStartGame.setBackground(new java.awt.Color(204, 204, 255));
        bntStartGame.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bntStartGame.setForeground(new java.awt.Color(102, 153, 255));
        bntStartGame.setText("ٍStart Game");
        bntStartGame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntStartGame.setFocusable(false);
        bntStartGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntStartGameMouseClicked(evt);
            }
        });
        bntStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntStartGameActionPerformed(evt);
            }
        });
        getContentPane().add(bntStartGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        btnHelp.setBackground(new java.awt.Color(204, 204, 255));
        btnHelp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHelp.setForeground(new java.awt.Color(102, 153, 255));
        btnHelp.setText("Help");
        btnHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHelp.setFocusable(false);
        btnHelp.setPreferredSize(new java.awt.Dimension(111, 25));
        btnHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHelpMouseClicked(evt);
            }
        });
        getContentPane().add(btnHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/minesweeper.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bntStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntStartGameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntStartGameActionPerformed

    private void bntStartGameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntStartGameMouseClicked
        generateFrame frame  = new generateFrame();
        NewGame ng = new NewGame();
        ng.grid(g, buttons);
//            define object to display tab File in Frame
        generateTabFile tabFile = new generateTabFile();
//          add menu bar to frame
        frame.setJMenuBar(tabFile.getBar());
//            show frame
        frame.setVisible(true);
//            load  ,save and new game
       
        tabFile.getSave().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(ae.getSource() == tabFile.getSave()){                        
                   SaveGame save = new SaveGame();
                   save.recieveGridTosaveInFile(g);
                   startCounter start = new startCounter();
                   save.receiveSecond_Minute(start.get_second(), start.get_minute());
                   System.out.println("second " + start.get_second() + "  minute " + start.get_minute());
                }
            }
        });
        // laod Game 
//        is OK
         tabFile.getLoad().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == tabFile.getLoad()){
                    loadGame load = new loadGame();
                    g = load.readGridFromFile();
                    fixGridAfterLoadGame();
                }
            }
        });
         // new Game
        tabFile.getnewGame().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ac){
                if(ac.getSource() == tabFile.getnewGame()){
                    NewGame ng = new NewGame();
                    ng.grid(g,buttons);
                    
//                    mouseClicking mo = new mouseClicking();
//                    mo.set_count(0);
                }
            }
        });
        
        dispose();
    }//GEN-LAST:event_bntStartGameMouseClicked

    private void btnHelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHelpMouseClicked
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection str = new StringSelection(youtube);
        clip.setContents(str, str);
//        JOptionPane.showMessageDialog(null, "email address is copied");
        isCopied copy = new isCopied("link to learn how do you play is copied... ");
        copy.setVisible(true);
    }//GEN-LAST:event_btnHelpMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(startGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(startGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(startGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(startGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new startGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntStartGame;
    private javax.swing.JButton btnHelp;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
