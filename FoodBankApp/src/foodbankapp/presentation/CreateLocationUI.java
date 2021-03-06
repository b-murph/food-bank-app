/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodbankapp.presentation;

import foodbankapp.ResourceMgr;
import foodbankapp.domain.*;
import javax.swing.JOptionPane;
import foodbankapp.service.AccountSvcCacheImpl;
import foodbankapp.service.IAccountSvc;
import java.util.logging.Logger;

public class CreateLocationUI extends javax.swing.JFrame {

    private Account account = null;
    
    public CreateLocationUI() {
        mgr = ResourceMgr.instance();
        initComponents();
    }
    
    public CreateLocationUI(Account account){
        mgr = ResourceMgr.instance();
        this.account = account;
        initComponents();
    }
    
    public void setAccount(Account account){
        this.account = account;
               
    }
    
    private static final Logger LOGGER = 
            Logger.getLogger(CreateAccountUI.class.getName());
    
    private ResourceMgr mgr;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        locationFld = new javax.swing.JTextField();
        confirmBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText(mgr.string("locationName"));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        locationFld.setToolTipText(mgr.string("locationHint")
        );

        confirmBtn.setBackground(new java.awt.Color(204, 204, 204));
        confirmBtn.setText(mgr.string("confirm"));
        confirmBtn.setToolTipText(mgr.string("confirmHint")
        );
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(204, 204, 204));
        cancelBtn.setText(mgr.string("cancel"));
        cancelBtn.setToolTipText(mgr.string("cancelHint")
        );
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(locationFld, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(confirmBtn)
                        .addGap(26, 26, 26)
                        .addComponent(cancelBtn)))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locationFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmBtn)
                    .addComponent(cancelBtn))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName(mgr.string("locationName"));
        locationFld.getAccessibleContext().setAccessibleName(mgr.string("locationName"));
        locationFld.getAccessibleContext().setAccessibleDescription(mgr.string("locationHint"));
        confirmBtn.getAccessibleContext().setAccessibleName(mgr.string("confirm"));
        confirmBtn.getAccessibleContext().setAccessibleDescription(mgr.string("confirmHint")
        );
        cancelBtn.getAccessibleContext().setAccessibleName(mgr.string("cancel")
        );
        cancelBtn.getAccessibleContext().setAccessibleDescription(mgr.string("cancelHint"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        Location location = new Location();
        location.setName(locationFld.getText());
        boolean isValid = location.validate();
        if (!isValid){
            JOptionPane.showMessageDialog(this,
                mgr.string("locationError1"), mgr.string("error"),
                JOptionPane.ERROR_MESSAGE);
            return;
        }else{
            account.addLoc(location);
            IAccountSvc impl =AccountSvcCacheImpl.getInstance();
            account = impl.update(account);
            if (account == null){
                JOptionPane.showMessageDialog(this,
                    mgr.string("locationError2"), mgr.string("error"),
                    JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                JOptionPane.showMessageDialog(this, mgr.string("locationMsg"),
                    mgr.string("locationMsg"), JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                MainUI mainUI = new MainUI();
                mainUI.setAccount(account);
                mainUI.setVisible(true);
            }
        }
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.setVisible(false);
        MainUI mainUI = new MainUI();
        mainUI.setAccount(account);
        mainUI.setVisible(true);
    }//GEN-LAST:event_cancelBtnActionPerformed

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
            LOGGER.log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            LOGGER.log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            LOGGER.log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            LOGGER.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateLocationUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField locationFld;
    // End of variables declaration//GEN-END:variables
}
