/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodbankapp.domain;

/**
 *
 * @author Brian
 */
public class Location {
    
    private String name = "";
    private int locationID = 0;

    public Location() {
    }
    
    public Location(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }
    
    public boolean validate(){
        if (name == null||name.equals("")) return false;
        if (!(locationID >=0)) return false;
        return true;
    }
    
}
