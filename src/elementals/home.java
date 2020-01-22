/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementals;

import elementals.battle;
import elementals.player;
import elementals.training;
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author NathanFeenstra
 */
public class home extends javax.swing.JFrame {

    player c;
    
    /**
     * Creates new form home
     */
    public home(player a) {
        initComponents();
        //set background color
        Color home = new Color(247,174,248);
        this.getContentPane().setBackground(home);
        c = a;
        
        lblName.setText("Name: " + c.getName());
        lblEarth.setText("Earth: " + c.getEarth());
        lblFire.setText("Fire: " + c.getFire());
        lblIce.setText("Ice: " + c.getIce());
        lblWater.setText("Water: " + c.getWater());
        lblXP.setText("XP: " + c.getXP());
        
        lblPlayer.setBackground(c.getUserColor());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEarth = new javax.swing.JLabel();
        lblFire = new javax.swing.JLabel();
        lblWater = new javax.swing.JLabel();
        lblIce = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblPlayer = new javax.swing.JLabel();
        btnTrain = new javax.swing.JButton();
        btnBattle = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lblXP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        lblEarth.setText("Earth:");

        lblFire.setText("Fire:");

        lblWater.setText("Water:");

        lblIce.setText("Ice:");

        lblName.setText("Name:");

        lblPlayer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblPlayer.setOpaque(true);

        btnTrain.setBackground(new java.awt.Color(255, 249, 165));
        btnTrain.setText("Train Stats");
        btnTrain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrainActionPerformed(evt);
            }
        });

        btnBattle.setBackground(new java.awt.Color(255, 129, 106));
        btnBattle.setText("To Next Battle");
        btnBattle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBattleActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(145, 145, 233));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        lblXP.setText("XP:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTrain, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblXP))
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblWater, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblEarth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBattle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEarth)
                    .addComponent(lblName))
                .addGap(18, 18, 18)
                .addComponent(lblFire)
                .addGap(20, 20, 20)
                .addComponent(lblWater)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIce)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(lblXP))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTrain)
                    .addComponent(btnBattle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrainActionPerformed
        
        this.setVisible(false);
        new training(c).setVisible(true);
    }//GEN-LAST:event_btnTrainActionPerformed

    private void btnBattleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBattleActionPerformed
        
        this.setVisible(false);
        new battle(c).setVisible(true);
        
    }//GEN-LAST:event_btnBattleActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // DONE by RACHEL
        
        try{
            //deletes the old file
            File origFile = new File("src//elementals//character_saves//" + c.getUserName() + ".txt"); 
            origFile.delete();
            //makes a new file with the same name (username.txt
            File newFile = new File("src//elementals//character_saves//" + c.getUserName() + ".txt");
            
            
            //Create the file
            if (newFile.createNewFile()){
                System.out.println("File is created!");
            } 
            else {
                System.out.println("File already exists.");
            }
            //Write Updated content to the file
            FileWriter writer = new FileWriter(newFile);
            writer.write(c.getUserName() + "\n" + 
                            c.getPassWord() + "\n" + 
                            c.getName() + "\n" + 
                            c.getRed() + "\n" + 
                            c.getGreen() + "\n" + 
                            c.getBlue() + "\n" + 
                            c.getFire() + "\n" + 
                            c.getEarth() + "\n" + 
                            c.getIce() + "\n" + 
                            c.getWater() + "\n" +
                            c.getXP());
            writer.close();
            }
        catch(IOException e){
            System.out.println(e);
        }
        
        this.setVisible(false);
        new start().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBattle;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnTrain;
    private javax.swing.JLabel lblEarth;
    private javax.swing.JLabel lblFire;
    private javax.swing.JLabel lblIce;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPlayer;
    private javax.swing.JLabel lblWater;
    private javax.swing.JLabel lblXP;
    // End of variables declaration//GEN-END:variables
}
