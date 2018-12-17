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
/**
 *
 * @author Brian
 */
public class CreateItemUI extends javax.swing.JFrame {

    private Account account = null;
    private Location location;
    private LocationComboBoxModel model = new LocationComboBoxModel();
    
    public void setAccount(Account account){
        this.account = account;
        model.setLocations(account.getLocations());  
    }
    
    private static final Logger LOGGER = 
            Logger.getLogger(CreateAccountUI.class.getName());
    
    private ResourceMgr mgr;
    
    /**
     * Creates new form createItem
     */ 
    
    
    public CreateItemUI(){
        mgr = ResourceMgr.instance();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        itemNameFld = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        itemAmountFld = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        itemCostFld = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        confirmItemBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        itemUnitsFld = new javax.swing.JTextField();
        locComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create an Inventory Item");
        setBackground(new java.awt.Color(204, 204, 204));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(0, 0));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(mgr.string("createNewItem")
        );

        itemNameFld.setToolTipText(mgr.string("itemNameHint"));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setLabelFor(itemNameFld);
        jLabel2.setText(mgr.string("name")
        );

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText(mgr.string("unit")
        );

        itemAmountFld.setToolTipText("Enter an initial number of units");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setLabelFor(itemAmountFld);
        jLabel4.setText(mgr.string("amount")
        );

        itemCostFld.setToolTipText(mgr.string("costHint"));
        itemCostFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCostFldActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setLabelFor(itemCostFld);
        jLabel5.setText(mgr.string("cost"));

        confirmItemBtn.setBackground(new java.awt.Color(204, 204, 204));
        confirmItemBtn.setText(mgr.string("confirm"));
        confirmItemBtn.setToolTipText(mgr.string("confirmHint")
        );
        confirmItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmItemBtnActionPerformed(evt);
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

        itemUnitsFld.setToolTipText(mgr.string("unitHint"));
        itemUnitsFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUnitsFldActionPerformed(evt);
            }
        });

        locComboBox.setModel(model);
        locComboBox.setSelectedItem(1);
        locComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setLabelFor(itemCostFld);
        jLabel6.setText(mgr.string("location"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(confirmItemBtn)
                        .addGap(26, 26, 26)
                        .addComponent(cancelBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(itemNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(itemAmountFld, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(itemCostFld, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(itemUnitsFld, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(locComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(123, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(309, 309, 309))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemUnitsFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemAmountFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemCostFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmItemBtn)
                    .addComponent(cancelBtn))
                .addContainerGap(233, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName(mgr.string("createNewItem"));
        jLabel1.getAccessibleContext().setAccessibleDescription(mgr.string("createItemViewHint"));
        itemNameFld.getAccessibleContext().setAccessibleName(mgr.string("itemName")
        );
        itemNameFld.getAccessibleContext().setAccessibleDescription(mgr.string("itemNameHint")
        );
        jLabel2.getAccessibleContext().setAccessibleName(mgr.string("name")
        );
        jLabel3.getAccessibleContext().setAccessibleName(mgr.string("unit"));
        jLabel4.getAccessibleContext().setAccessibleName(mgr.string("amount")
        );
        jLabel4.getAccessibleContext().setAccessibleDescription(mgr.string("amountHint"));
        itemCostFld.getAccessibleContext().setAccessibleName(mgr.string("cost"));
        itemCostFld.getAccessibleContext().setAccessibleDescription(mgr.string("costHint")
        );
        jLabel5.getAccessibleContext().setAccessibleName(mgr.string("cost"));
        confirmItemBtn.getAccessibleContext().setAccessibleName(mgr.string("confirm")
        );
        confirmItemBtn.getAccessibleContext().setAccessibleDescription(mgr.string("confirmHint")
        );
        cancelBtn.getAccessibleContext().setAccessibleName(mgr.string("cancel")
        );
        cancelBtn.getAccessibleContext().setAccessibleDescription(mgr.string("cancelHint")
        );
        itemUnitsFld.getAccessibleContext().setAccessibleName(mgr.string("unit"));
        itemUnitsFld.getAccessibleContext().setAccessibleDescription(mgr.string("unitHint"));
        locComboBox.getAccessibleContext().setAccessibleName(mgr.string("location"));
        locComboBox.getAccessibleContext().setAccessibleDescription(mgr.string("locationListHint"));
        jLabel6.getAccessibleContext().setAccessibleName(mgr.string("location")
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmItemBtnActionPerformed
       Inventory item = new Inventory();
       item.setName(itemNameFld.getText());
       item.setUnit(itemUnitsFld.getText());
       item.setCost(Double.parseDouble(itemCostFld.getText()));
       item.setAmount(Double.parseDouble(itemAmountFld.getText()));
       item.setLocation(location);
       boolean isValid = item.validate();
       if (!isValid){
           JOptionPane.showMessageDialog(this, 
                   mgr.string("itemError1"), mgr.string("error"), 
                   JOptionPane.ERROR_MESSAGE);
           return;
       }else{
         account.add(item);
         IAccountSvc impl =AccountSvcCacheImpl.getInstance();
         account = impl.update(account);
         if (account == null){
             JOptionPane.showMessageDialog(this, 
                     mgr.string("itemError2"), mgr.string("error"),
                     JOptionPane.ERROR_MESSAGE);
             return;
         }else{
             JOptionPane.showMessageDialog(this, mgr.string("itemAddMsg"), 
                     mgr.string("itemAddTitle"), JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            MainUI mainUI = new MainUI();
            mainUI.setAccount(account);
            mainUI.setVisible(true);
         }
       }
    }//GEN-LAST:event_confirmItemBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.setVisible(false);
        MainUI mainUI = new MainUI();
        mainUI.setAccount(account);
        mainUI.setVisible(true);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void itemCostFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCostFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemCostFldActionPerformed

    private void itemUnitsFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUnitsFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemUnitsFldActionPerformed

    private void locComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locComboBoxActionPerformed
        location = this.account.findLocation((String)locComboBox.getSelectedItem());
    }//GEN-LAST:event_locComboBoxActionPerformed

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
                new CreateItemUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton confirmItemBtn;
    private javax.swing.JTextField itemAmountFld;
    private javax.swing.JTextField itemCostFld;
    private javax.swing.JTextField itemNameFld;
    private javax.swing.JTextField itemUnitsFld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> locComboBox;
    // End of variables declaration//GEN-END:variables
}