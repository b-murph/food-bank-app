/*
 * Version 1.0
 * CS 444
 * 9/15/18
 */
package foodbankapp.domain;
import java.util.Date;

/**
 * this implements the class for transaction objects
 * @author Brian
 */
public class Transaction {
    
    private String item = "";
    private Date date = null;
    private double amount = 0;
    private int ID = 0;
    private Location location = null;

      
    public Transaction(){
        
    }

    public Transaction(
            String item, Date date, double amount, Location location) {
        this.amount = amount;
        this.date = date;
        this.item = item;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
     public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public boolean validate(){
        if (item == null||item.equals("")) return false;
        if (!(amount >0)) return false;
        if (date == null) return false;
        if (location == null) return false;
        if (!(ID > 0)) return false;
        return true;
    }
}

