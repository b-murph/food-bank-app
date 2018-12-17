/*
 * Version 1.0
 * CS 444
 * 9/15/18
 */
package foodbankapp.domain;
import java.util.Date;

/**
 * this implements the class for inventory items in the food bank app
 * @author Brian
 */
public class Inventory {
    
    private Location location;
    private String name = "";
    private String unit = "";
    private double amount = 0;
    private double cost = 0;
    private int itemID = 0;

    public Inventory() {
    }
    
    public Inventory(
            String name, String unit, double amount, 
            double cost, Location location){
        
        this.location = location;
        this.name = name;
        this.unit = unit;
        this.amount = amount;
        this.cost = cost;    
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    /*
    * This method will create a new transaction object and dispense the 
    * specified amount of the item. The method will need to be updated to
    * include adding the transaction object to the data structure. The return
    * value may not be used in the final code, but was put in place
    * here for testing purposes
    */
    public Transaction dispense(double dispensed){
        Date date = new Date();
        Transaction transaction = 
                new Transaction(this.name, date, dispensed, this.location);
        this.setAmount(amount-dispensed);
        return transaction;
    }
    
    public boolean validate(){
        if (name == null||name.equals("")) return false;
        if (unit == null||unit.equals("")) return false;
        if (!(itemID >=0)) return false;
        if (!(amount >=0)) return false;
        if (!(cost >=0)) return false;
        return true;
    }
}
