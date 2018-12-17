/*
 * Version 1.0
 * CS 444
 * 10/12/18
 */
package foodbankapp.presentation;

import foodbankapp.domain.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brian
 */
public class InventoryTableModel extends AbstractTableModel {
    
    private String[] columnNames = {
        "Item Name", "Units", "Location", "Amount", "Cost"};
    
    private List<Inventory> inventory = new LinkedList<Inventory>();
    
    public void setItems(List<Inventory> inventory){
        this.inventory = inventory;
    }
    
    @Override
    public int getRowCount(){
        return inventory.size();
    }
    
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    
    @Override
    public Object getValueAt(int row, int column){
        Inventory item = inventory.get(row);
        switch(column){
            case 0:
                return item.getName();
            case 1:
                return item.getUnit();
            case 2:
                return item.getLocation().getName();
            case 3:    
                return item.getAmount();
            case 4:
                return item.getCost();
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


