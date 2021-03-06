/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodbankapp.presentation;

import foodbankapp.ResourceMgr;
import javax.swing.JOptionPane;
import foodbankapp.domain.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**
 *
 * @author Brian
 */
public class MainUI extends javax.swing.JFrame {
    
    private Account account = null;
    
    private InventoryTableModel model = new InventoryTableModel();
        
    private int selectedRow = -1;
    
    private static final Logger LOGGER = 
            Logger.getLogger(CreateAccountUI.class.getName());
    
    private ResourceMgr mgr;
    
    public static void ensureDataDirectory() throws SecurityException {
        String netBeansDir = System.getProperty("user.dir");
        
        String dataDirectory =  netBeansDir + "/Data/";
        
        Path path = Paths.get(dataDirectory);
        
        if (!Files.exists(path)) {
            File file = new File(dataDirectory);
            
            file.mkdir();
        }
    }
    
    public void setAccount(Account account){
        this.account = account;
        model.setItems(account.getInventory());
    }

    /**
     * Creates new form main
     */
    public MainUI() {
        mgr = ResourceMgr.instance();
        String[] names = {
        mgr.string("itemName"), mgr.string("unit"), mgr.string("location"),
            mgr.string("amount"), mgr.string("cost")};
        model.setColumnNames(names);
        initComponents();
        inventoryTbl.setModel(model);
        inventoryTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int row = inventoryTbl.rowAtPoint(evt.getPoint());
                if (row >= 0){
                    selectedRow = row;
                    Inventory item = account.getInventory().get(selectedRow);
                    System.out.println(item.getItemID());
                }
            }
});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryTbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        createNewItemBtn = new javax.swing.JButton();
        dispenseItemBtn = new javax.swing.JButton();
        editAmountBtn = new javax.swing.JButton();
        getTrendDataBtn = new javax.swing.JButton();
        createLocationBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory");
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setAutoscrolls(true);
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        inventoryTbl.setBackground(new java.awt.Color(255, 255, 255));
        inventoryTbl.setModel(model);
        jScrollPane1.setViewportView(inventoryTbl);
        inventoryTbl.getAccessibleContext().setAccessibleName(null);
        inventoryTbl.getAccessibleContext().setAccessibleDescription(null);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setLabelFor(inventoryTbl);
        jLabel1.setText(mgr.string("inventory"));

        createNewItemBtn.setBackground(new java.awt.Color(204, 204, 204));
        createNewItemBtn.setText(mgr.string("createNewItem")
        );
        createNewItemBtn.setToolTipText(mgr.string("createNewItemHint"));
        createNewItemBtn.setMinimumSize(new java.awt.Dimension(125, 32));
        createNewItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewItemBtnActionPerformed(evt);
            }
        });

        dispenseItemBtn.setBackground(new java.awt.Color(204, 204, 204));
        dispenseItemBtn.setText(mgr.string("dispenseItem")
        );
        dispenseItemBtn.setToolTipText(mgr.string("dispenseItemHint"));
        dispenseItemBtn.setPreferredSize(new java.awt.Dimension(125, 32));
        dispenseItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispenseItemBtnActionPerformed(evt);
            }
        });

        editAmountBtn.setBackground(new java.awt.Color(204, 204, 204));
        editAmountBtn.setText(mgr.string("editAmount")
        );
        editAmountBtn.setToolTipText(mgr.string("editAmountHint"));
        editAmountBtn.setPreferredSize(new java.awt.Dimension(125, 32));
        editAmountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAmountBtnActionPerformed(evt);
            }
        });

        getTrendDataBtn.setBackground(new java.awt.Color(204, 204, 204));
        getTrendDataBtn.setText(mgr.string("getTrendData")
        );
        getTrendDataBtn.setToolTipText(mgr.string("getTrendHint"));
        getTrendDataBtn.setPreferredSize(new java.awt.Dimension(125, 32));
        getTrendDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getTrendDataBtnActionPerformed(evt);
            }
        });

        createLocationBtn.setBackground(new java.awt.Color(204, 204, 204));
        createLocationBtn.setText(mgr.string("createLocation"));
        createLocationBtn.setToolTipText(mgr.string("createLocationHint"));
        createLocationBtn.setPreferredSize(new java.awt.Dimension(125, 32));
        createLocationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createLocationBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(createNewItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dispenseItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(createLocationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editAmountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(getTrendDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createNewItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dispenseItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editAmountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getTrendDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createLocationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(177, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName(null);
        jLabel1.getAccessibleContext().setAccessibleDescription(null);
        createNewItemBtn.getAccessibleContext().setAccessibleName(mgr.string("createNewItem")
        );
        createNewItemBtn.getAccessibleContext().setAccessibleDescription(mgr.string("createNewItemHint"));
        dispenseItemBtn.getAccessibleContext().setAccessibleName(mgr.string("dispenseItem")
        );
        dispenseItemBtn.getAccessibleContext().setAccessibleDescription(mgr.string("dispenseItemHint")
        );
        editAmountBtn.getAccessibleContext().setAccessibleName(mgr.string("editAmount"));
        editAmountBtn.getAccessibleContext().setAccessibleDescription(mgr.string("editAmountHint")
        );
        getTrendDataBtn.getAccessibleContext().setAccessibleName(mgr.string("getTrendData")
        );
        getTrendDataBtn.getAccessibleContext().setAccessibleDescription(mgr.string("getTrendHint"));
        createLocationBtn.getAccessibleContext().setAccessibleName(mgr.string("createLocation")
        );
        createLocationBtn.getAccessibleContext().setAccessibleDescription(mgr.string("createLocationHint")
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createNewItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewItemBtnActionPerformed
        this.setVisible(false);
        CreateItemUI createItemUI = new CreateItemUI();
        createItemUI.setAccount(account);
        createItemUI.setVisible(true);
    }//GEN-LAST:event_createNewItemBtnActionPerformed

    private void editAmountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAmountBtnActionPerformed
        if (selectedRow >= 0){
        Inventory item = account.getInventory().get(selectedRow);
        EditAmountUI editAmountUI = new EditAmountUI(account, item.getItemID());
        this.setVisible(false);
        editAmountUI.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, 
                     mgr.string("inventorySelectError"), mgr.string("error"),
                     JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editAmountBtnActionPerformed

    private void dispenseItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispenseItemBtnActionPerformed
        if (selectedRow >= 0){
        Inventory item = account.getInventory().get(selectedRow);
        DispenseUI dispenseUI = new DispenseUI(account, item.getItemID());
        this.setVisible(false);
        dispenseUI.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, 
                     mgr.string("inventorySelectError"), mgr.string("error"),
                     JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dispenseItemBtnActionPerformed

    private void getTrendDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getTrendDataBtnActionPerformed
        this.setVisible(false);
        GetTrendDataUI getTrendDataUI = new GetTrendDataUI(account);
        getTrendDataUI.setVisible(true);
    }//GEN-LAST:event_getTrendDataBtnActionPerformed

    private void createLocationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createLocationBtnActionPerformed
        this.setVisible(false);
        CreateLocationUI createLocationUI = new CreateLocationUI(account);
        createLocationUI.setVisible(true);
    }//GEN-LAST:event_createLocationBtnActionPerformed

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
                new MainUI().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createLocationBtn;
    private javax.swing.JButton createNewItemBtn;
    private javax.swing.JButton dispenseItemBtn;
    private javax.swing.JButton editAmountBtn;
    private javax.swing.JButton getTrendDataBtn;
    private javax.swing.JTable inventoryTbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
