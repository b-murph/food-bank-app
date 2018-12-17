/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodbankapp.presentation;

import foodbankapp.domain.Location;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Brian
 */
public class LocationComboBoxModel  extends DefaultComboBoxModel{
    
    
    
    public void setLocations(List<Location> locations){
        locations.forEach((i) -> {
            addElement(i.getName());
        });   
    } 
}
