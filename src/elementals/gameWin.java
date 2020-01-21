/*
 * Elementals - Rachel
 * this is the form that will show if the player defeatsthe final boss
 */
package elementals;

import java.io.File;

/**
 *
 * @author rachelroutly
 */
public class gameWin extends javax.swing.JPanel {
    start starter;
    player character;
    /**
     * Creates new form gameWin
     */
    public gameWin(player c) {
        initComponents();
        character = c;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        exitBttn = new javax.swing.JButton();
        restartBttn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel1.setText("You Win!");

        exitBttn.setBackground(new java.awt.Color(145, 145, 233));
        exitBttn.setText("Exit Game");
        exitBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBttnActionPerformed(evt);
            }
        });

        restartBttn.setBackground(new java.awt.Color(145, 145, 233));
        restartBttn.setText("Back to Start");
        restartBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartBttnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exitBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(restartBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(restartBttn, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(exitBttn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exitBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBttnActionPerformed
        //if they choose to exit, the current save file will be deleted, and the system will exit
        File origFile = new File("src//elementals//character_saves//" + character.getUserName() + ".txt"); 
        origFile.delete();
        
        System.exit(0);
    }//GEN-LAST:event_exitBttnActionPerformed

    private void restartBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartBttnActionPerformed
        //if the user chooses to end the program, their file is still deleted, but they are returned to the start menu
        File origFile = new File("src//elementals//character_saves//" + character.getUserName() + ".txt"); 
        origFile.delete();
        
        this.setVisible(false);
        
        start starter = new start();
        starter.setVisible(true); 
    }//GEN-LAST:event_restartBttnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitBttn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton restartBttn;
    // End of variables declaration//GEN-END:variables
}
