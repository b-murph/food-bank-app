/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodbankapp.presentation;

import foodbankapp.EncryptionMgr;
import foodbankapp.ResourceMgr;
import foodbankapp.domain.*;
import foodbankapp.service.*;
import javax.swing.JOptionPane;
import foodbankapp.service.*;
import foodbankapp.service.AccountSvcCacheImpl;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 *
 * @author Brian
 */
public class LoginUI extends javax.swing.JFrame {

    /**
     * Creates new form getTrendData
     */
    public LoginUI() {
        mgr = ResourceMgr.instance();
        initComponents();
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
        usernameFld = new javax.swing.JTextField();
        passwordFld = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        createAccountBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        usernameFld.setToolTipText(mgr.string("usernameHint"));

        passwordFld.setToolTipText(mgr.string("passwordHint"));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setLabelFor(usernameFld);
        jLabel1.setText(mgr.string("username"));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setLabelFor(passwordFld);
        jLabel2.setText(mgr.string("password"));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText(mgr.string("login"));

        loginBtn.setBackground(new java.awt.Color(204, 204, 204));
        loginBtn.setText(mgr.string("login"));
        loginBtn.setToolTipText(mgr.string("loginHint"));
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(204, 204, 204));
        cancelBtn.setText(mgr.string("cancel"));
        cancelBtn.setToolTipText(mgr.string("cancelHint"));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        createAccountBtn.setBackground(new java.awt.Color(204, 204, 204));
        createAccountBtn.setText(mgr.string("createAcct"));
        createAccountBtn.setToolTipText(mgr.string("createAcctHint"));
        createAccountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameFld)
                    .addComponent(passwordFld, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                .addGap(109, 109, 109))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(loginBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createAccountBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelBtn)
                .addGap(97, 97, 97))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginBtn)
                    .addComponent(cancelBtn)
                    .addComponent(createAccountBtn))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        loginBtn.getAccessibleContext().setAccessibleDescription("mgr.string(\"loginHint\")");
        cancelBtn.getAccessibleContext().setAccessibleDescription(mgr.string("cancelHint"));
        createAccountBtn.getAccessibleContext().setAccessibleDescription(null);

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

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void createAccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountBtnActionPerformed
        this.setVisible(false);
        CreateAccountUI createAccountUI = new CreateAccountUI();
        createAccountUI.setVisible(true);
    }//GEN-LAST:event_createAccountBtnActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        Login login = new Login();
        login.setUsername(usernameFld.getText());
        
        final String iv = "2163243567289329"; // This has to be 16 characters
        final String secretKey = "foodBankApp.secret";
        EncryptionMgr mgrEncrypt = new EncryptionMgr();
        final String clearPassword = Arrays.toString(passwordFld.getPassword());
        final String encryptedPassword = mgrEncrypt.encrypt(clearPassword,iv,secretKey);
        
        login.setPassword(encryptedPassword);
        if (!login.validate()){
            JOptionPane.showMessageDialog(this,
                    mgr.string("loginError1"), mgr.string("error"), 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        IAccountSvc impl = AccountSvcCacheImpl.getInstance();
        Account account = impl.authenticate(login);
        if (account == null){
            JOptionPane.showMessageDialog(this, 
                    mgr.string("loginError2"), 
                    mgr.string("error"), JOptionPane.ERROR_MESSAGE);
            return;
        }else{
            this.setVisible(false);
            MainUI mainUI = new MainUI();
            mainUI.setAccount(account);
            mainUI.setVisible(true);
        }
    }//GEN-LAST:event_loginBtnActionPerformed


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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton createAccountBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordFld;
    private javax.swing.JTextField usernameFld;
    // End of variables declaration//GEN-END:variables
}
