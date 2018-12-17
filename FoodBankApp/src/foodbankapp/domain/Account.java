/*
 * Version 1.0
 * CS 444
 * 9/15/18
 */
package foodbankapp.domain;
import java.util.*;

/**
 * the implements the class for user accounts
 * @author Brian
 */
public class Account {
    
    private List<Inventory> inventory = new LinkedList<Inventory>();
    private List<Transaction> transactions = new LinkedList<Transaction>();
    private List<Location> locations = new LinkedList<Location>();
    private int nextId = -1;

    public Account(){
        
    }
    
    public List<Location> getLocations() {
        return locations;
    }
    
    public Location findLocation(String name) {
        for (Location i:locations){
            if (i.getName().equals(name)){
                return i;
            }
        }
            return null;    
                }
    

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
    
    

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setInventory(List<Inventory> inventory) {
        this.inventory = inventory;
    }
    
    public Inventory add(Inventory item){
        item.setItemID(++nextId);
        inventory.add(item);
        return item;
    }
    
    public Transaction add(Transaction transaction){
        transactions.add(transaction);
        return transaction;
    }
    
     public Location addLoc(Location location){
        locations.add(location);
        return location;
    }
    
    private String name = "";
    private String email = "";
    private Login login = null;
    private String securityLevel = "";
    private int Id;

    public int getId() {
        return Id;
    }

    public List<Inventory> getInventory() {
        return inventory;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }
    
    public boolean validate(){
        if (name == null||name.equals("")) return false;
        if (email == null||email.equals("")) return false;
        if (login == null) return false;
        if (securityLevel == null||securityLevel.equals("")) return false;
        return true;
    }

   
  
    
}
