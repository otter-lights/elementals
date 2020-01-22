/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementals;

//necessary imports for file reading
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//necessary imports for changing label icons
import javax.swing.ImageIcon;
//elements from the elements package
import Elements.Element;
import Elements.Fire;
import Elements.Water;
import Elements.Ice;
import Elements.Earth;
import java.awt.Color;
//how the computer decides things
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author nathan
 */
public class battle extends javax.swing.JFrame {

    
    player c;
    int level, playerHealth, monHealth, exp;
    ImageIcon ii;
    monster m;
    
    double monFire;
    double monEarth;
    double monIce;
    double monWater;
    
    /**
     * Creates new form battleFix
     */
    public battle(player a) {
        initComponents();
        //set background color
        Color battle = new Color(255,129,106);
        this.getContentPane().setBackground(battle);
        
        c = a;
        level = c.getXP();
        playerHealth = 3;
        
        btnEarth.setText("Earth: " + c.getEarth());
        btnFire.setText("Fire: " + c.getFire());
        btnWater.setText("Water: " + c.getWater());
        btnIce.setText("Ice: " + c.getIce());
        
        if(level < 4){
            fill("Blob-Boy");
        }else if(level < 8){
            fill("Spike");
        }else{
            fill("Shadow");
        }
    }
    
    public void fill(String thing){
        try{
            
            FileReader fr = new FileReader("src//monsters//" + thing + ".txt");
            BufferedReader br = new BufferedReader(fr);
            
            String monName = br.readLine();
            
            String h = br.readLine();
            monHealth = Integer.parseInt(h);           
    
            String H = ""; 
            for(int i = 0; i < monHealth; i++){
                H += "❤ ";
            }
            lblMonHealth.setText(H);

            String f = br.readLine();
            String e = br.readLine();
            String i = br.readLine();
            String w = br.readLine();
            monFire = Double.parseDouble(f);
            monEarth = Double.parseDouble(e);
            monIce = Double.parseDouble(i);
            monWater = Double.parseDouble(w);

            lblMonStats.setText("Earth: " + monEarth + "\nFire: " + monFire + "\nWater: " + monWater + "\nIce: " + monIce);
            
            String x = br.readLine();
            exp = Integer.parseInt(x);
            
            m = new monster(thing, monFire, monEarth, monIce, monWater, monHealth);
        }catch(IOException e){
            System.out.println(e + ": Error reading monster file: " + thing);
        }
        
        //set the image of the monster - depends on what level the user is at
        ImageIcon im = new ImageIcon("src//elementals//images//" + thing + ".png");
        lblMonster.setIcon(im);
        
        //set the players box to their color
        lblPlayer.setBackground(c.getUserColor());
        
    }
    
    public int monsterAttack(){
        Random ran = new Random();
        return ran.nextInt(4);
    }
    
    private void attack(int player){
        int monster = monsterAttack();
        
        double monAttack;
        double monMod;
        double playerAttack;
        double playerMod;
        
        btnFire.setEnabled(true);
        btnWater.setEnabled(true);
        btnIce.setEnabled(true);
        btnEarth.setEnabled(true);
        
        Element mType;
        Element pType;
        
        switch(monster){
            case 0:
                mType = new Earth();
                break;
            case 1:
                mType = new Fire();
                break;
            case 2:
                mType = new Water();
                break;
            case 3:
                mType = new Ice();
                break;
            default:
                mType = new Earth();
                System.out.println("Something went wrong with monster attack selection - given number" + monster);
                break;
        }
        
        switch(player){
            case 0:
                pType = new Earth();
                playerAttack = c.getEarth();
                monMod = 1.0;
                btnEarth.setEnabled(false);
                break;
            case 1:
                pType = new Fire();
                playerAttack = c.getFire();
                monMod = mType.getFM();
                btnFire.setEnabled(false);
                break;
            case 2:
                pType = new Water();
                playerAttack = c.getWater();
                monMod = mType.getWM();
                btnWater.setEnabled(false);
                break;
            case 3:
                pType = new Ice();
                playerAttack = c.getIce();
                monMod = mType.getIM();
                btnIce.setEnabled(false);
                break;
            default:
                pType = new Earth();
                playerAttack = c.getEarth();
                monMod = 1.0;
                btnEarth.setEnabled(false);
                System.out.println("Something went wrong with player attack selection - given number" + player);
                break;
        }
        
        switch(monster){
            case 0:
                monAttack = m.getEarth();
                playerMod = 1.0;
                break;
            case 1:
                monAttack = m.getFire();
                playerMod = pType.getFM();
                break;
            case 2:
                monAttack = m.getWater();
                playerMod = pType.getWM();
                break;
            case 3:
                monAttack = m.getIce();
                playerMod = pType.getIM();
                break;
            default:
                System.out.println("Monster attack comparison error");
                monAttack = m.getEarth();
                playerMod = 1.0;
                break;
        }
        
        
        
        double decider = (playerAttack * playerMod) - (monAttack * monMod);
        
        if(decider > 0){
            
            monHealth--;
            String H = "";
            for(int i = 0; i < monHealth; i++){
               H += "❤ ";
            }
            lblMonHealth.setText(H);
            
            JOptionPane.showMessageDialog(null, "You hit your opponent\n"
                    + "Info:\n"
                    + "You Chose " + pType.toString() + " -> " + playerAttack + " * " + playerMod + " = " + (playerAttack*playerMod) + "\n"
                    + "Opponent chose " + mType.toString() + " -> " + monAttack + " * " + monMod + " = " + (monAttack*monMod));
            
            if(monHealth <= 0){
                JOptionPane.showMessageDialog(null, "Great work!\nYou Win!\n\nYou earned " + exp + " experience");
                
                c.setXP(c.getXP() + exp);
                
                if(c.getXP() >= 20){
                    this.setVisible(false);
                    new gameWon(c).setVisible(true);
                }else{
                    this.setVisible(false);
                    new home(c).setVisible(true);  
                }
                
            }
            
        }else if(decider < 0){
            
            playerHealth--;
            String H = "";
            for(int i = 0; i < playerHealth; i++){
               H += "❤ ";
            }
            lblPlayerHealth.setText(H);
            
            JOptionPane.showMessageDialog(null, "Ah, you've been hit\n"
                    + "Info:\n"
                    + "You Chose " + pType.toString() + " -> " + playerAttack + " * " + playerMod + " = " + (playerAttack*playerMod) + "\n"
                    + "Opponent chose " + mType.toString() + " -> " + monAttack + " * " + monMod + " = " + (monAttack*monMod));
            
            if(playerHealth <= 0){
                this.setVisible(false);
                new gameOver(c).setVisible(true);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "tie, nobody wins\n"
                    + "Info:\n"
                    + "You Chose " + pType.toString() + " -> " + playerAttack + " * " + playerMod + " = " + (playerAttack*playerMod) + "\n"
                    + "Opponent chose " + mType.toString() + " -> " + monAttack + " * " + monMod + " = " + (monAttack*monMod));
        }
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
        jLabel2 = new javax.swing.JLabel();
        lblPlayer = new javax.swing.JLabel();
        lblMonster = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnEarth = new javax.swing.JButton();
        btnFire = new javax.swing.JButton();
        btnWater = new javax.swing.JButton();
        btnIce = new javax.swing.JButton();
        lblPlayerHealth = new javax.swing.JLabel();
        lblMonHealth = new javax.swing.JLabel();
        btnFlee = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblMonStats = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Battle");
        setUndecorated(true);

        jLabel1.setText("Player");

        jLabel2.setText("Monster");

        lblPlayer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPlayer.setOpaque(true);

        lblMonster.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Actions");

        jLabel6.setText("Enemy Stats");

        btnEarth.setBackground(new java.awt.Color(136, 91, 32));
        btnEarth.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        btnEarth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elementals/images/earth-icon.png"))); // NOI18N
        btnEarth.setText("Earth");
        btnEarth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEarthActionPerformed(evt);
            }
        });

        btnFire.setBackground(new java.awt.Color(255, 51, 0));
        btnFire.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        btnFire.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elementals/images/fire-icon.png"))); // NOI18N
        btnFire.setText("Fire");
        btnFire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFireActionPerformed(evt);
            }
        });

        btnWater.setBackground(new java.awt.Color(51, 102, 255));
        btnWater.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        btnWater.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elementals/images/water-icon.png"))); // NOI18N
        btnWater.setText("Water");
        btnWater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWaterActionPerformed(evt);
            }
        });

        btnIce.setBackground(new java.awt.Color(0, 204, 255));
        btnIce.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        btnIce.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elementals/images/ice-icon.png"))); // NOI18N
        btnIce.setText("Ice");
        btnIce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIceActionPerformed(evt);
            }
        });

        lblPlayerHealth.setText("❤ ❤ ❤ ");

        lblMonHealth.setText("❤ ❤ ❤ ");

        btnFlee.setBackground(new java.awt.Color(51, 51, 51));
        btnFlee.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        btnFlee.setText("Flee");
        btnFlee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFleeActionPerformed(evt);
            }
        });

        lblMonStats.setEditable(false);
        lblMonStats.setBackground(new java.awt.Color(0, 204, 204));
        lblMonStats.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        lblMonStats.setForeground(new java.awt.Color(255, 51, 51));
        lblMonStats.setCaretColor(new java.awt.Color(0, 204, 204));
        lblMonStats.setDragEnabled(false);
        lblMonStats.setIgnoreRepaint(true);
        jScrollPane1.setViewportView(lblMonStats);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblPlayerHealth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnWater, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(lblPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEarth, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIce, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnFire, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnFlee, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMonster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(lblMonHealth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMonster, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlayerHealth)
                    .addComponent(lblMonHealth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEarth, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFire, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnWater, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIce, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFlee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFleeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFleeActionPerformed
        JOptionPane.showMessageDialog(null, "As you run away you loose some experience");
        if(c.getXP() >= 4){
            c.setXP(c.getXP() - 4);
        }else{
            c.setXP(0);
        }
        
        this.setVisible(false);
        new home(c).setVisible(true);
    }//GEN-LAST:event_btnFleeActionPerformed

    private void btnEarthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEarthActionPerformed
        attack(0);
    }//GEN-LAST:event_btnEarthActionPerformed

    private void btnFireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFireActionPerformed
        attack(1);
    }//GEN-LAST:event_btnFireActionPerformed

    private void btnWaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWaterActionPerformed
        attack(2);
    }//GEN-LAST:event_btnWaterActionPerformed

    private void btnIceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIceActionPerformed
        attack(3);
    }//GEN-LAST:event_btnIceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEarth;
    private javax.swing.JButton btnFire;
    private javax.swing.JButton btnFlee;
    private javax.swing.JButton btnIce;
    private javax.swing.JButton btnWater;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMonHealth;
    private javax.swing.JTextPane lblMonStats;
    private javax.swing.JLabel lblMonster;
    private javax.swing.JLabel lblPlayer;
    private javax.swing.JLabel lblPlayerHealth;
    // End of variables declaration//GEN-END:variables
}
