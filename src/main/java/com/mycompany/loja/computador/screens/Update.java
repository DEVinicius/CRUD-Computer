/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.loja.computador.screens;

import com.mycompany.loja.computador.models.Computador;
import com.mycompany.loja.computador.services.FindComputerByIdService;
import com.mycompany.loja.computador.services.UpdateComputerService;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius.oliveira
 */
public class Update extends javax.swing.JFrame {

    /**
     * Creates new form Insert
     */
    
    private FindComputerByIdService findComputerByIdService;
    private UpdateComputerService updateComputerService;
    private Computador computador;
    
    public Update(int id) {
        initComponents();
        
        this.findComputerByIdService = new FindComputerByIdService();
        this.updateComputerService = new UpdateComputerService();
        this.computador = this.findComputerByIdService.execute(id);
        
        if(computador != null) {
            this.processadorInput.setText(computador.getProcessador());
            this.hdInput.setText(computador.getHd());
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

        cadastrarComputadorLabel = new javax.swing.JLabel();
        processadorLabel = new javax.swing.JLabel();
        processadorInput = new javax.swing.JTextField();
        HdLabel = new javax.swing.JLabel();
        hdInput = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cadastrarComputadorLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        cadastrarComputadorLabel.setText("Gestão Computador");

        processadorLabel.setText("Processador");

        HdLabel.setText("HD");

        hdInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hdInputActionPerformed(evt);
            }
        });

        updateButton.setText("Atualizar");
        updateButton.setToolTipText("");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HdLabel)
                    .addComponent(processadorLabel)
                    .addComponent(cadastrarComputadorLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(updateButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                        .addComponent(hdInput, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(processadorInput, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(cadastrarComputadorLabel)
                .addGap(33, 33, 33)
                .addComponent(processadorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(processadorInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(HdLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hdInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {hdInput, processadorInput});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hdInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hdInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hdInputActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        try {
            String processador = this.processadorInput.getText();
            String hd = this.hdInput.getText();
            
            Computador updateComputer = this.updateComputerService.execute(this.computador.getId(), processador, hd);
            
            JOptionPane.showMessageDialog(null, "Computador Atualizado com sucesso");

        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_updateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HdLabel;
    private javax.swing.JLabel cadastrarComputadorLabel;
    private javax.swing.JTextField hdInput;
    private javax.swing.JTextField processadorInput;
    private javax.swing.JLabel processadorLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}