/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodbankapp.presentation;

import foodbankapp.ResourceMgr;
import foodbankapp.domain.*;
import java.util.*;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Brian
 */
public class EditAmountUI extends javax.swing.JFrame {

    private Account account = null;
    private int itemID = 0;
    private List<Inventory> inventory;
    private static final Logger LOGGER = 
            Logger.getLogger(CreateAccountUI.class.getName());
    
    private ResourceMgr mgr;
    
    /**
     * Creates new form editAmount
     * @param account
     */
    public void setAccount(Account account){
        this.account = account;
    }
    
    public void setItem(int item){
        this.itemID = item;
    }

    
    public EditAmountUI() {
        mgr = ResourceMgr.instance();
        initComponents();
             
    }
    
    public EditAmountUI(Account account, int itemID) {
        mgr = ResourceMgr.instance();
        initComponents();
        this.account = account;
        this.itemID = itemID;
        inventory = account.getInventory();
        Inventory item = inventory.get(itemID);
        itemNameFld.setText(item.getName());
        itemAmountFld.setText(String.valueOf(item.getAmount()));
        unitLabel.setText(item.getUnit());
           
              
    }

    /**
     * the code in this section is a work in progress, was just tooling around
     * with how to implement things. 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        editAmountFld = new javax.swing.JTextField();
        addAmountBtn = new javax.swing.JButton();
        removeAmountBtn = new javax.swing.JButton();
        itemNameFld = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        unitLabel = new javax.swing.JLabel();
        itemAmountFld = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 300));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText(mgr.string("amountEditLbl"));
        jLabel1.setToolTipText("");

        editAmountFld.setToolTipText(mgr.string("amountEditLbl"));

        addAmountBtn.setBackground(new java.awt.Color(255, 255, 255));
        addAmountBtn.setText(mgr.string("addBtn")
        );
        addAmountBtn.setToolTipText(mgr.string("addBtnHint"));
        addAmountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAmountBtnActionPerformed(evt);
            }
        });

        removeAmountBtn.setBackground(new java.awt.Color(255, 255, 255));
        removeAmountBtn.setText(mgr.string("removeBtn")
        );
        removeAmountBtn.setToolTipText(mgr.string("removeBtnHint"));
        removeAmountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAmountBtnActionPerformed(evt);
            }
        });

        itemNameFld.setToolTipText(mgr.string("itemDisp"));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText(mgr.string("itemName"));

        unitLabel.setForeground(new java.awt.Color(0, 0, 0));

        itemAmountFld.setToolTipText(mgr.string("amountDisp"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editAmountFld)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addAmountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(removeAmountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(144, 144, 144))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(itemAmountFld)
                                .addGap(64, 64, 64)
                                .addComponent(unitLabel))
                            .addComponent(itemNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(114, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 57, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editAmountFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addAmountBtn)
                            .addComponent(removeAmountBtn))
                        .addGap(53, 53, 53))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itemAmountFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unitLabel))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel1.getAccessibleContext().setAccessibleName(mgr.string("amountEditLbl"));
        editAmountFld.getAccessibleContext().setAccessibleName(mgr.string("amountEditLbl"));
        editAmountFld.getAccessibleContext().setAccessibleDescription(mgr.string("amountEditLbl"));
        addAmountBtn.getAccessibleContext().setAccessibleName(mgr.string("addBtn"));
        addAmountBtn.getAccessibleContext().setAccessibleDescription(mgr.string("addBtnHint"));
        removeAmountBtn.getAccessibleContext().setAccessibleName(mgr.string("removeBtn"));
        removeAmountBtn.getAccessibleContext().setAccessibleDescription(mgr.string("removeBtnHint"));
        itemNameFld.getAccessibleContext().setAccessibleName(mgr.string("itemName"));
        itemNameFld.getAccessibleContext().setAccessibleDescription(mgr.string("itemDisp")
        );
        jLabel2.getAccessibleContext().setAccessibleName(mgr.string("itemName"));
        jLabel2.getAccessibleContext().setAccessibleDescription(mgr.string("itemName"));
        itemAmountFld.getAccessibleContext().setAccessibleName(mgr.string("amount"));
        itemAmountFld.getAccessibleContext().setAccessibleDescription(mgr.string("amountDisp")
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addAmountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAmountBtnActionPerformed
        int editAmount = Integer.parseInt(editAmountFld.getText());
        if (editAmount >= 0){
        Inventory item = inventory.get(itemID);
        item.setAmount(item.getAmount()+editAmount);
        JOptionPane.showMessageDialog(this, mgr.string("addedMsg") + " " 
                + editAmount + " " + item.getUnit()  +
                " of " + item.getName(), mgr.string("itemUpdatedMsg"), 
                JOptionPane.INFORMATION_MESSAGE);
        this.account.setInventory(inventory);
        this.setVisible(false);
        MainUI mainUI = new MainUI();
        mainUI.setAccount(account);
        mainUI.setVisible(true);
        }else{
           JOptionPane.showMessageDialog(this, 
                     mgr.string("negativeNumError"), mgr.string("error"),
                     JOptionPane.ERROR_MESSAGE);  
        }
    }//GEN-LAST:event_addAmountBtnActionPerformed

    private void removeAmountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAmountBtnActionPerformed
        int editAmount = Integer.parseInt(editAmountFld.getText());
        if (editAmount >= 0){
        Inventory item = inventory.get(itemID);
        item.setAmount(item.getAmount()-editAmount);
        JOptionPane.showMessageDialog(this, mgr.string("removedMsg") + " " 
                + editAmount + " " + item.getUnit()  +
                " of " + item.getName(), mgr.string("itemUpdatedMsg"), 
                JOptionPane.INFORMATION_MESSAGE);
        this.account.setInventory(inventory);
        this.setVisible(false);
        MainUI mainUI = new MainUI();
        mainUI.setAccount(account);
        mainUI.setVisible(true);
        }else{
           JOptionPane.showMessageDialog(this, 
                     mgr.string("negativeNumError"), mgr.string("error"),
                     JOptionPane.ERROR_MESSAGE);  
        }
    }//GEN-LAST:event_removeAmountBtnActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditAmountUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAmountBtn;
    private javax.swing.JTextField editAmountFld;
    private javax.swing.JTextField itemAmountFld;
    private javax.swing.JTextField itemNameFld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton removeAmountBtn;
    private javax.swing.JLabel unitLabel;
    // End of variables declaration//GEN-END:variables
}
