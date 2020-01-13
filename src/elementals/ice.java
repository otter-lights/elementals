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
public class ice extends javax.swing.JFrame {
    
    player character;
    rachelMain house;
    training train;
    /**
     * Creates new form ice
     * @param c
     */
    public ice(player c) {
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
        fireVal = new javax.swing.JLabel();
        homeBttn = new javax.swing.JButton();
        questionOne = new javax.swing.JLabel();
        questionTwo = new javax.swing.JLabel();
        questionThree = new javax.swing.JLabel();
        answerOne = new javax.swing.JComboBox<>();
        answerTwo = new javax.swing.JComboBox<>();
        answerThree = new javax.swing.JComboBox<>();
        submitBttn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elementals/images/ice-icon.png"))); // NOI18N
        jLabel1.setText("  :");

        fireVal.setText("       ");

        homeBttn.setText("Back to Home");
        homeBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBttnActionPerformed(evt);
            }
        });

        questionOne.setText(" --");

        questionTwo.setText(" --");

        questionThree.setText(" --");

        submitBttn.setText("Submit");
        submitBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBttnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fireVal)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(questionOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(questionTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(questionThree, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(answerOne, 0, 91, Short.MAX_VALUE)
                            .addComponent(answerTwo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(answerThree, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(homeBttn, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(submitBttn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fireVal))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(submitBttn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeBttn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBttnActionPerformed
        // TODO add your handling code here:
        if(house == null){
            System.out.println("yeet");
            house = new rachelMain(character);
        }
        this.setVisible(false);
        house.setVisible(true);
    }//GEN-LAST:event_homeBttnActionPerformed

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
        if(train == null){
            train = new training(character);
        }
        this.setVisible(false);
        train.setVisible(true);
    }//GEN-LAST:event_submitBttnActionPerformed
    
        String[] questions = {"The climate is made of five components, which relates to rocks and sediments?", 
                          "Offshore earthquakes can cause ________", 
                          "______% of the energy in an earthquake is seismic", 
                          "Which is not a normal type of fault", 
                          "Earthquales from normal faults generally have a magnitude less than ______", 
                          "An 8.6 magnitude earthquake releases the same energy as _______ bombs from WW2", 
                          "How many major tectonic plates are there?", 
                          "How many minor tectonic plates are there?",
                          "Which is not a classification of tectonic plate?",
                          "What is the minimum amount of time to form 1 inch of top soil?",
                          "There are _______ different types of soil in the US", 
                          "What type of tree changes the acidity of its soil to prevent other growth?", 
                          "In a _________ of healthy soil there are more organisms than humans on earth.",
                          "In North America (as of 2003) ______ soil series have gone extinct",
                          "Which is not a common threat to soil health?"};
    
    String[] correct = {"lithosphere",
                        "tsunamis",
                        "10",
                        "horizontal",
                        "7",
                        "10,000",
                        "7",
                        "10",
                        "nano",
                        "500 years",
                        "70,000",
                        "Black Walnut",
                        "Teaspoon",
                        "33",
                        "Over Watering"};
    
    String[] wrong1 =  {"atmosphere",
                        "hurricanes",
                        "10",
                        "normal",
                        "2",
                        "100",
                        "10",
                        "7",
                        "major",
                        "10 years",
                        "10,000",
                        "Oak",
                        "Litre",
                        "4",
                        "Urbanization"};
    
    String[] wrong2 =  {"cryosphere",
                        "tornados",
                        "50",
                        "reverse",
                        "13",
                        "1,000",
                        "18",
                        "8",
                        "minor",
                        "50 years",
                        "30,000",
                        "Cherry",
                        "Cup",
                        "27",
                        "Acidification"};
    
    String[] wrong3 =  {"biosphere",
                        "hail",
                        "85",
                        "strike-slip",
                        "9",
                        "1",
                        "5",
                        "19",
                        "micro",
                        "100 years",
                        "90,000",
                        "Maple",
                        "Tablespoon",
                        "46",
                        "Overgrazing"};
    
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
    private javax.swing.JLabel fireVal;
    private javax.swing.JButton homeBttn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel questionOne;
    private javax.swing.JLabel questionThree;
    private javax.swing.JLabel questionTwo;
    private javax.swing.JButton submitBttn;
    // End of variables declaration//GEN-END:variables
}
