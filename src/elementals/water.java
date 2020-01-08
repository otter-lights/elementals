/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementals;

import java.util.Random;
import javax.swing.JComboBox;

/**
 *
 * @author rachelroutly
 */
public class water extends javax.swing.JFrame {

    player character;
    home house;
    /**
     * Creates new form water
     */
    public water(player c) {
        character = c;
        initComponents();
        chooseQuestions();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        questionOne = new javax.swing.JLabel();
        questionTwo = new javax.swing.JLabel();
        questionThree = new javax.swing.JLabel();
        answerOne = new javax.swing.JComboBox<>();
        answerTwo = new javax.swing.JComboBox<>();
        answerThree = new javax.swing.JComboBox<>();
        submitBttn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        waterVal = new javax.swing.JLabel();
        homeBttn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        questionOne.setText(" --");

        questionTwo.setText(" --");

        questionThree.setText(" --");

        submitBttn.setText("Submit");
        submitBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBttnActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elementals/images/water-icon.png"))); // NOI18N
        jLabel1.setText("  :");

        waterVal.setText("       ");

        homeBttn.setText("Back to Home");
        homeBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBttnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(questionOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(questionTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(questionThree, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(answerOne, 0, 91, Short.MAX_VALUE)
                    .addComponent(answerTwo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(answerThree, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(waterVal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(submitBttn, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(homeBttn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(waterVal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questionOne)
                    .addComponent(answerOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questionTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answerTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questionThree)
                    .addComponent(answerThree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submitBttn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeBttn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBttnActionPerformed
        // TODO add your handling code here:
        int numCorrect = 0;
        if(correct[numOne] == answerOne.getSelectedItem()){
            numCorrect++;
        }
        
        if(correct[numTwo] == answerTwo.getSelectedItem()){
            numCorrect++;
        }
        
        if(correct[numThree] == answerThree.getSelectedItem()){
            numCorrect++;
        }
        double d = character.getWater();
        System.out.println(d);        
        
        switch (numCorrect) {
            case 1:
                System.out.println("1");
                character.setWater(d + 0.3);
                break;
            case 2:
                System.out.println("2");
                character.setWater(d + 0.6);
                break;
            case 3:
                System.out.println("3");                
                character.setWater(d + 1.0);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_submitBttnActionPerformed

    private void homeBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBttnActionPerformed
        // TODO add your handling code here:
        if(house == null){
            System.out.println("yeet");
            house = new home(character);
        }    
        this.setVisible(false);
        house.setVisible(true); 
    }//GEN-LAST:event_homeBttnActionPerformed
    
    String[] questions = {"The climate is made of five components, which relates to water?", 
                          "Tides on earth are due to which celestial body?", 
                          "How much freshwater is trapped in glaciers?", 
                          "What is the freezing temperature of seawater?", 
                          "In the developing world ____% illnesses is a result of unsanitary water", 
                          "Salt water accounts for ____% of water on earth", 
                          "The average European uses _____ the water that the average American uses", 
                          "2.2 pounds of beef uses about _____ gallons of water",
                          "South African women collectively walk the distance of ____ trips to the moon to collect water",
                          "1 in __ people don’t have access to clean water",
                          "The economic return on $1 invested in water infrastructure in Africa is between ", 
                          "Uncontaminated water has a pH value of", 
                          "4L of gasoline can contaminate _______L during production",
                          "Bottled water can be ____ times as expensive as tap water ",
                          "Nestle (evil corporation) wants to take ____ L of water/day from the middlebrook well"};
    
    String[] correct = {"hydrosphere",
                        "Moon",
                        "69%",
                        "-2 Celcius",
                        "80%",
                        "97",
                        "50%",
                        "4 000",
                        "16",
                        "9",
                        "3-34",
                        "7",
                        "750 000",
                        "2 000",
                        "1.6 Million"};
    
    String[] wrong1 =  {"atmosphere",
                        "Sun",
                        "32%",
                        "0 Celcius",
                        "50%",
                        "80",
                        "75%",
                        "2 000",
                        "2",
                        "3",
                        "5-48",
                        "4",
                        "500 000",
                        "500",
                        "500 000"};
    
    String[] wrong2 =  {"cryosphere",
                        "Mars",
                        "50%",
                        "2 Celcius",
                        "70%",
                        "93",
                        "100%",
                        "3 000",
                        "4",
                        "5",
                        "3-10",
                        "9",
                        "100 000",
                        "5 000",
                        "1 Million"};
    
    String[] wrong3 =  {"biosphere",
                        "Venus",
                        "75%",
                        "-1 Celcius",
                        "90%",
                        "95",
                        "125%",
                        "3 500",
                        "32",
                        "13",
                        "5-25",
                        "20",
                        "125 000",
                        "10 000",
                        "1.8 Million"};
    
    Random rand = new Random(); 
    int numOne = rand.nextInt((15 - 1) + 1) + 1;
    int numTwo = rand.nextInt((15 - 1) + 1) + 1;
    int numThree = rand.nextInt((15 - 1) + 1) + 1;
    
    public void chooseQuestions(){           
        questionOne.setText(questions[numOne]);
        ranOrder(numOne, answerOne);
        
        questionTwo.setText(questions[numTwo]);
        ranOrder(numTwo, answerTwo);
        
        questionThree.setText(questions[numThree]);
        ranOrder(numThree, answerThree);
    }
    
    public void ranOrder(int n, JComboBox<String> question){
        Random rand = new Random(); 
        int order = rand.nextInt((4 - 1) + 1) + 1;
        if(order <= 1){
            question.addItem(correct[n]);
            question.addItem(wrong1[n]);
            question.addItem(wrong2[n]);
            question.addItem(wrong3[n]);
        }   
        else if(order <= 2){           
            question.addItem(wrong1[n]);
            question.addItem(correct[n]);
            question.addItem(wrong2[n]);
            question.addItem(wrong3[n]);
        } 
        else if(order <= 3){
            question.addItem(wrong1[n]);           
            question.addItem(wrong2[n]);
            question.addItem(correct[n]);
            question.addItem(wrong3[n]);
        }
        else{
            question.addItem(wrong1[n]);            
            question.addItem(wrong2[n]);
            question.addItem(wrong3[n]);
            question.addItem(correct[n]);
        }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> answerOne;
    private javax.swing.JComboBox<String> answerThree;
    private javax.swing.JComboBox<String> answerTwo;
    private javax.swing.JButton homeBttn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel questionOne;
    private javax.swing.JLabel questionThree;
    private javax.swing.JLabel questionTwo;
    private javax.swing.JButton submitBttn;
    private javax.swing.JLabel waterVal;
    // End of variables declaration//GEN-END:variables
}