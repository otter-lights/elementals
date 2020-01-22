/*
 * This is the war zone, in both game and code
 * Here the player fights a monster and either wins and walks of with more XP, loose XP running away, or looses and has to restart
 * Nathan Feenstra
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

    //subject player and monster
    player c;
    monster m;
    
    //variables to be used throughout the class
    int exp, playerHealth, monHealth, expGain;
    ImageIcon ii;
    
    
    //monsters stats
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
        
        //sets the given player to the subject player
        c = a;
        //players current xp
        exp = c.getXP();
        //players starting health
        playerHealth = 3;
        //displays the players stats
        btnEarth.setText("Earth: " + c.getEarth());
        btnFire.setText("Fire: " + c.getFire());
        btnWater.setText("Water: " + c.getWater());
        btnIce.setText("Ice: " + c.getIce());
        
        //determines which monster to fight
        if(exp < 4){
            fill("Blob-Boy");
        }else if(exp < 8){
            fill("Spike");
        }else{
            fill("Shadow");
        }
    }
    
    //reads from the monster's file, sets it's stats acordingly and displays those stats
    public void fill(String thing){
        try{
            
            FileReader fr = new FileReader("src//monsters//" + thing + ".txt");
            BufferedReader br = new BufferedReader(fr);
            
            //the monster's name
            String monName = br.readLine();
            lblMonName.setText(monName);
            
            //monster's health
            String h = br.readLine();
            monHealth = Integer.parseInt(h);   
            
            //loop to load up the health onto the health bar
            String H = ""; 
            for(int i = 0; i < monHealth; i++){
                H += "❤ ";
            }
            lblMonHealth.setText(H);
            
            //Monster's attack stats
            String f = br.readLine();
            String e = br.readLine();
            String i = br.readLine();
            String w = br.readLine();
            monFire = Double.parseDouble(f);
            monEarth = Double.parseDouble(e);
            monIce = Double.parseDouble(i);
            monWater = Double.parseDouble(w);
            //displays the monster's stats
            lblMonStats.setText("Earth: " + monEarth + "\nFire: " + monFire + "\nWater: " + monWater + "\nIce: " + monIce);
            
            //the amount of XP the player will gain if this monster is defeated
            String x = br.readLine();
            expGain = Integer.parseInt(x);
            
            //creates a new monster to hold all of this information for referance later
            m = new monster(thing, monFire, monEarth, monIce, monWater, monHealth);
        }catch(IOException e){
            //if something goes wrong, you will find it here
            System.out.println(e + ": Error reading monster file: " + thing);
        }
        
        //set the image of the monster - depends on what level the user is at
        ImageIcon im = new ImageIcon("src//elementals//images//" + thing + ".png");
        lblMonster.setIcon(im);
        
        //set the players box to their color
        lblPlayer.setBackground(c.getUserColor());
        
    }
    
    //returns a random number between 0 and 3 inclusive -> determines which attack the monster will use
    public int monsterAttack(){
        Random ran = new Random();
        return ran.nextInt(4);
    }
    
    //determines who won the fight
    private void attack(int player){
        //grabs a random number
        int monster = monsterAttack();
        
        //monsters strength and modifier against the player
        double monAttack;
        double monMod;
        //players strength and modifier against the monster
        double playerAttack;
        double playerMod;
        //holds the types of attacks the player and monster will have
        Element mType;
        Element pType;
        
        //resets the buttons
        btnFire.setEnabled(true);
        btnWater.setEnabled(true);
        btnIce.setEnabled(true);
        btnEarth.setEnabled(true);
        
        //sets the monsters type of attack
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
        
        //sets the players attack type, and monsters modifier
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
        
        //sets the monster's attack type, and player's modifier
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
        //decide who won the Attack
        decide(playerAttack, playerMod, monAttack, monMod, pType, mType);
    }
    
    private void decide(double playerA, double playerMod, double monA, double monMod, Element pType, Element mType){
        //apply modifiers and subtract
        double decider = (playerA * playerMod) - (monA * monMod);
        
        //common script between all messages to the user
        String info = "Info:\n"
                    + "You Chose " + pType.toString() + " -> " + playerA + " * " + playerMod + " = " + (playerA*playerMod) + "\n"
                    + "Opponent chose " + mType.toString() + " -> " + monA + " * " + monMod + " = " + (monA*monMod);
        
        if(decider > 0){//case that the player won
            
            //subtract from the monsters health
            monHealth--;
            
            //diplay new monsters health
            String H = "";
            for(int i = 0; i < monHealth; i++){
               H += "❤ ";
            }
            lblMonHealth.setText(H);
            
            //message to the user
            JOptionPane.showMessageDialog(null, "You hit your opponent\n" + info);
            
            if(monHealth <= 0){//in the case that the monster dies
                //message to user that they win the encounter
                JOptionPane.showMessageDialog(null, "Great work!\nYou Win!\n\nYou earned " + expGain + " experience");
                
                //add XP
                c.addXP(expGain);
                
                
                if(c.getXP() >= 20){//in the case that the player has enough XP to win the game
                    //display the win screen
                    this.setVisible(false);
                    new gameWon(c).setVisible(true);
                }else{//otherwise
                    //go back to home
                    this.setVisible(false);
                    new home(c).setVisible(true);  
                }
            }
           
        }else if(decider < 0){//case in which the monster won
            
            //the player looses one health
            playerHealth--;
            //update on screen
            String H = "";
            for(int i = 0; i < playerHealth; i++){
               H += "❤ ";
            }
            lblPlayerHealth.setText(H);
            
            //message and rundown to the user
            JOptionPane.showMessageDialog(null, "Ah, you've been hit\n" + info);
            
            //If the player dies to the monster
            if(playerHealth <= 0){
                //gameover screen
                this.setVisible(false);
                new gameOver(c).setVisible(true);
            }
        
        }else{//otherwise it was a tie
            //message with rundown
            JOptionPane.showMessageDialog(null, "tie, nobody wins\n" + info);
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

        lblPlayerName = new javax.swing.JLabel();
        lblMonName = new javax.swing.JLabel();
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

        lblPlayerName.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        lblPlayerName.setText("Player");

        lblMonName.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        lblMonName.setText("Monster");

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
                                    .addComponent(lblPlayerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .addComponent(lblMonName, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(lblMonHealth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlayerName)
                    .addComponent(lblMonName))
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
        //message to user explaining XP loss
        JOptionPane.showMessageDialog(null, "As you run away you loose some experience");
        
        //subtracts 4 XP or if the player does not have enough, the player looses the rest of their XP
        if(c.getXP() >= 4){
            c.setXP(c.getXP() - 4);
        }else{
            c.setXP(0);
        }
        
        //return to home screen
        this.setVisible(false);
        new home(c).setVisible(true);
    }//GEN-LAST:event_btnFleeActionPerformed
    
    //different attack buttons (0 = earth, 1 = fire, 2 = water, 3 = ice)
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMonHealth;
    private javax.swing.JLabel lblMonName;
    private javax.swing.JTextPane lblMonStats;
    private javax.swing.JLabel lblMonster;
    private javax.swing.JLabel lblPlayer;
    private javax.swing.JLabel lblPlayerHealth;
    private javax.swing.JLabel lblPlayerName;
    // End of variables declaration//GEN-END:variables
}
