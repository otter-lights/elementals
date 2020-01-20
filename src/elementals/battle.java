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
//how the computer decides things
import java.util.Random;
import javax.swing.JOptionPane;


/**
 *
 * @author NathanFeenstra
 */
public class battle extends javax.swing.JFrame {

    player c;
    int level;
    ImageIcon ii;
    monster m;
    
    double monFire;
    double monEarth;
    double monIce;
    double monWater;
    
    /**
     * Creates new form battle
     */
    public battle(player a) {
        initComponents();
        
        c = a;
        level = c.getXP();
        
        btnEarth.setText("Earth: " + c.getEarth());
        btnFire.setText("Fire: " + c.getFire());
        btnWater.setText("Water: " + c.getWater());
        btnIce.setText("Ice: " + c.getIce());
        
        if(level < 4){
            fight("Blob-Boy");
        }else if(level < 8){
            fight("Spike");
        }else if(level < 12){
            fight("Shadow");
        }else{
            
        }
        
    }
    
    public void fight(String thing){
        try{
            
            FileReader fr = new FileReader("src//monsters//" + thing + ".txt");
            BufferedReader br = new BufferedReader(fr);
            
            String monName = br.readLine();
            
            String h = br.readLine();
            
            int monHealth = Integer.parseInt(h);
            
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
            
            lblEarth.setText("Earth: " + monEarth);
            lblFire.setText("Fire: " + monFire);
            lblWater.setText("Water: " + monWater);
            lblIce.setText("Ice: " + monIce);
            
            String x = br.readLine();
            
            int exp = Integer.parseInt(x);
            
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
    
    
    public Element monsterAttack(){
        Random ran = new Random();
        int choice = ran.nextInt(4);
        
        switch(choice){
            case 0:
                return new Earth();
            case 1:
                return new Fire();
            case 2:
                return new Water();
            case 3:
                return new Ice();
            default:
                //just in case something bad happens the game is still playable
                System.out.println("Something went very wrong here (monsterAttack randomizer)");
                return new Earth();
        }
    }
    
    private void attack(Element player, Element monster){
        double monAttack;
        double monMod;
        double playerAttack;
        double playerMod;
        
        if(player.equals(new Ice())){
            playerAttack = c.getIce();
            monMod = monster.getIM();
        }else if(player.equals(new Fire())){
            playerAttack = c.getFire();
            monMod = monster.getFM();
        }else if(player.equals(new Water())){
            playerAttack = c.getWater();
            monMod = monster.getWM();
        }else{
            playerAttack = c.getEarth();
            monMod = 1.0;
        }
        
        if(monster.equals(new Ice())){
            monAttack = m.getIce();
            playerMod = player.getIM();
        }else if(player.equals(new Fire())){
            monAttack = m.getFire();
            playerMod = player.getFM();
        }else if(player.equals(new Water())){
            monAttack = m.getWater();
            playerMod = player.getWM();
        }else{
            monAttack = m.getEarth();
            playerMod = 1.0;
        }
        
        double decider = (playerAttack * playerMod) - (monAttack * monMod);
        
        if(decider >= 0){
            //player won
        }else{
            //monster won
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
        lblPlayerName = new javax.swing.JLabel();
        lblPlayer = new javax.swing.JLabel();
        lblMonster = new javax.swing.JLabel();
        lblMonName = new javax.swing.JLabel();
        lblPlayerHealth = new javax.swing.JLabel();
        lblMonHealth = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnEarth = new javax.swing.JButton();
        btnFire = new javax.swing.JButton();
        btnWater = new javax.swing.JButton();
        btnIce = new javax.swing.JButton();
        btnFlee = new javax.swing.JButton();
        lblOpponent = new javax.swing.JLabel();
        lblEarth = new javax.swing.JLabel();
        lblFire = new javax.swing.JLabel();
        lblWater = new javax.swing.JLabel();
        lblIce = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Battle");

        lblPlayerName.setText("Player");

        lblPlayer.setBackground(new java.awt.Color(0, 0, 0));
        lblPlayer.setForeground(new java.awt.Color(255, 255, 255));
        lblPlayer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblPlayer.setBounds(new java.awt.Rectangle(100, 200, 200, 0));
        lblPlayer.setOpaque(true);

        lblMonName.setText("Monster");

        lblPlayerHealth.setForeground(new java.awt.Color(204, 0, 0));
        lblPlayerHealth.setText("❤ ❤ ❤");

        lblMonHealth.setForeground(new java.awt.Color(204, 0, 0));
        lblMonHealth.setText("❤ ❤ ❤");

        jLabel8.setText("Actions");

        btnEarth.setText("Earth");
        btnEarth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEarthActionPerformed(evt);
            }
        });

        btnFire.setText("Fire");
        btnFire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFireActionPerformed(evt);
            }
        });

        btnWater.setText("Water");
        btnWater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWaterActionPerformed(evt);
            }
        });

        btnIce.setText("Ice");
        btnIce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIceActionPerformed(evt);
            }
        });

        btnFlee.setText("Flee");
        btnFlee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFleeActionPerformed(evt);
            }
        });

        lblOpponent.setText("Opponent");

        lblEarth.setText("Earth:");

        lblFire.setText("Fire:");

        lblWater.setText("Water:");

        lblIce.setText("Ice:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPlayerHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPlayerName)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lblPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblMonName)
                            .addComponent(lblMonster, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(lblMonHealth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnWater, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(btnEarth, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnFire, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(btnIce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFlee, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblOpponent, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(lblEarth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblWater, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFlee, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlayerName)
                            .addComponent(lblMonName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMonster, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPlayerHealth)
                            .addComponent(lblMonHealth))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(lblOpponent))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnEarth)
                                    .addComponent(btnFire))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnIce)
                                    .addComponent(btnWater)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEarth)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFire)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblWater)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIce)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIceActionPerformed
        
        
        
        
    }//GEN-LAST:event_btnIceActionPerformed

    private void btnWaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWaterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnWaterActionPerformed

    private void btnEarthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEarthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEarthActionPerformed

    private void btnFireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFireActionPerformed

    private void btnFleeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFleeActionPerformed
        JOptionPane.showMessageDialog(null, "Coward");
        
         this.setVisible(false);
         new home(c).setVisible(true);
    }//GEN-LAST:event_btnFleeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEarth;
    private javax.swing.JButton btnFire;
    private javax.swing.JButton btnFlee;
    private javax.swing.JButton btnIce;
    private javax.swing.JButton btnWater;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblEarth;
    private javax.swing.JLabel lblFire;
    private javax.swing.JLabel lblIce;
    private javax.swing.JLabel lblMonHealth;
    private javax.swing.JLabel lblMonName;
    private javax.swing.JLabel lblMonster;
    private javax.swing.JLabel lblOpponent;
    private javax.swing.JLabel lblPlayer;
    private javax.swing.JLabel lblPlayerHealth;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JLabel lblWater;
    // End of variables declaration//GEN-END:variables
}
