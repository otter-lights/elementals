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
    
    //creates new form battle
    public battle(player a) {
        
        initComponents();
        
        c = a;
        level = c.getXP();
        playerHealth = 3;
        
        btnEarth.setText("Earth: " + c.getEarth());
        btnFire.setText("Fire: " + c.getFire());
        btnWater.setText("Water: " + c.getWater());
        btnIce.setText("Ice: " + c.getIce());
        
        if(level < 4){
            paint("Blob-Boy");
        }else if(level < 8){
            paint("Spike");
        }else if(level < 12){
            paint("Shadow");
        }else{
            
        }
    }
    
    public void paint(String thing){
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
            monHealth--;
            
            String H = "";
            for(int i = 0; i < monHealth; i++){
               H += "❤ ";
            }
            lblMonHealth.setText(H);
            
            if(monHealth <= 0){
                JOptionPane.showMessageDialog(null, "Great work!\nYou Win!\n\nYou earned " + exp + "experience");
                
                c.setXP(c.getXP() + exp);
                
                this.setVisible(false);
                new home(c).setVisible(true);
            }
        }else{
            playerHealth--;
            
            String H = "";
            for(int i = 0; i < playerHealth; i++){
               H += "❤ ";
            }
            lblPLayerHealth.setText(H);
            
            if(playerHealth <= 0){
                this.setVisible(false);
                new gameOver(c).setVisible(true);
            }
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

        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblPlayer = new javax.swing.JLabel();
        lblMonster = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnEarth = new javax.swing.JButton();
        btnFire = new javax.swing.JButton();
        btnWater = new javax.swing.JButton();
        btnIce = new javax.swing.JButton();
        btnFlee = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        lblMonStats = new javax.swing.JLabel();
        lblMonHealth = new javax.swing.JLabel();
        lblPLayerHealth = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel11");

        jLabel8.setText("Earth:");

        jLabel12.setText("jLabel12");

        jLabel13.setText("jLabel13");

        jLabel14.setText("jLabel14");

        jLabel15.setText("jLabel15");

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Battle");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Battle");

        jLabel2.setText("Player");

        jLabel3.setText("Monster");

        lblPlayer.setBackground(new java.awt.Color(0, 0, 0));
        lblPlayer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPlayer.setOpaque(true);

        jLabel6.setText("Actions");

        btnEarth.setText("Earth:");

        btnFire.setText("Fire:");

        btnWater.setText("Water:");

        btnIce.setText("Ice:");

        btnFlee.setText("Flee");
        btnFlee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFleeActionPerformed(evt);
            }
        });

        jLabel7.setText("Enemy Stats");

        lblMonStats.setText("Earth:");
        lblMonStats.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblMonStats.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(255, 255, 255), java.awt.Color.white, java.awt.Color.white));

        lblMonHealth.setForeground(new java.awt.Color(204, 0, 0));
        lblMonHealth.setText("❤ ❤ ❤ ");

        lblPLayerHealth.setForeground(new java.awt.Color(204, 0, 0));
        lblPLayerHealth.setText("❤ ❤ ❤ ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnEarth, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnFire, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnWater, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnIce, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnFlee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblPLayerHealth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(89, 89, 89)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(filler2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 43, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                                    .addComponent(lblMonHealth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                    .addComponent(lblMonStats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(lblPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(lblMonster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMonster, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMonHealth)
                            .addComponent(lblPLayerHealth))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEarth, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFire, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnWater, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIce, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFlee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMonStats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFleeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFleeActionPerformed
        JOptionPane.showMessageDialog(null, "As you run away you loose some experience");
        
         this.setVisible(false);
         new home(c).setVisible(true);
    }//GEN-LAST:event_btnFleeActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEarth;
    private javax.swing.JButton btnFire;
    private javax.swing.JButton btnFlee;
    private javax.swing.JButton btnIce;
    private javax.swing.JButton btnWater;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblMonHealth;
    private javax.swing.JLabel lblMonStats;
    private javax.swing.JLabel lblMonster;
    private javax.swing.JLabel lblPLayerHealth;
    private javax.swing.JLabel lblPlayer;
    // End of variables declaration//GEN-END:variables
}
