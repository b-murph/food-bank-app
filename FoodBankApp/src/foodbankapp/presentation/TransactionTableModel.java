/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodbankapp.presentation;

import foodbankapp.domain.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class TransactionTableModel extends AbstractTableModel{
    private String[] columnNames = {"Item Name", "Amount", "Date"};
    
    private List<Transaction> transactions = new LinkedList<Transaction>();
    
    public void setTransactions(List<Transaction> transactions){
        this.transactions = transactions;
    }
    
    @Override
    public int getRowCount(){
        return transactions.size();
    }
    
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    
    @Override
    public Object getValueAt(int row, int column){
        Transaction transaction = transactions.get(row);
        switch(column){
            case 0:
                return transaction.getItem();
            case 1:
                return transaction.getAmount();
            case 2:
                return transaction.getDate();
            }
        return "";
    }
    
    @Override
    public String getColumnName(int column){
        return columnNames[column];
    }
    
    public void setColumnNames(String[] names){
        this.columnNames=names;
    }
}
