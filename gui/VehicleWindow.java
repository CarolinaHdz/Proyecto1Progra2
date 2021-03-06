/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Christian
 */
public class VehicleWindow extends javax.swing.JFrame {

    /**
     * Creates new form VehicleWindow
     */
    Color c= new Color(150,150,255);
    public VehicleWindow() {
        initComponents();
        
        this.setTitle("Vehicule Window");
        setLocationRelativeTo(null);
        setResizable(false);
        
      
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Assets/fondoCar_1_1.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());

        this.getContentPane().setBackground(c);
        this.setBackground(Color.BLACK);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtInsertCar = new javax.swing.JButton();
        jbtInserHM = new javax.swing.JButton();
        jbtSeeInfo = new javax.swing.JButton();
        jbtCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtInsertCar.setBackground(new java.awt.Color(0, 51, 102));
        jbtInsertCar.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jbtInsertCar.setForeground(new java.awt.Color(255, 255, 255));
        jbtInsertCar.setText("Insert Car");
        jbtInsertCar.setBorder(null);
        jbtInsertCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtInsertCarActionPerformed(evt);
            }
        });

        jbtInserHM.setBackground(new java.awt.Color(0, 51, 102));
        jbtInserHM.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jbtInserHM.setForeground(new java.awt.Color(255, 255, 255));
        jbtInserHM.setText("Insert Heavy M");
        jbtInserHM.setBorder(null);
        jbtInserHM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtInserHMActionPerformed(evt);
            }
        });

        jbtSeeInfo.setBackground(new java.awt.Color(0, 51, 102));
        jbtSeeInfo.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jbtSeeInfo.setForeground(new java.awt.Color(255, 255, 255));
        jbtSeeInfo.setText("See Info");
        jbtSeeInfo.setBorder(null);
        jbtSeeInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSeeInfoActionPerformed(evt);
            }
        });

        jbtCancel.setBackground(new java.awt.Color(0, 51, 102));
        jbtCancel.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jbtCancel.setForeground(new java.awt.Color(255, 255, 255));
        jbtCancel.setText("Cancel");
        jbtCancel.setBorder(null);
        jbtCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbtInserHM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtInsertCar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtSeeInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtInserHM, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtInsertCar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSeeInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtInsertCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtInsertCarActionPerformed
        try {
            InsertCar car=new InsertCar();
            car.setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(VehicleWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtInsertCarActionPerformed

    private void jbtInserHMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtInserHMActionPerformed
        try {
            InsertHeavyMachinery mach=new InsertHeavyMachinery();
            mach.setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(VehicleWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtInserHMActionPerformed

    private void jbtSeeInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSeeInfoActionPerformed
        SeeVehicleInformation see=new SeeVehicleInformation();
        see.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtSeeInfoActionPerformed

    private void jbtCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelActionPerformed
        this.dispose();
        PrincipalWindow pw= new PrincipalWindow();
        pw.setVisible(true);
    }//GEN-LAST:event_jbtCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtCancel;
    private javax.swing.JButton jbtInserHM;
    private javax.swing.JButton jbtInsertCar;
    private javax.swing.JButton jbtSeeInfo;
    // End of variables declaration//GEN-END:variables
}
