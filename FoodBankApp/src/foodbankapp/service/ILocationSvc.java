/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import foodbankapp.domain.*;
import java.util.*;
/**
 *
 * @author Brian
 */
public interface ILocationSvc {
    
    public Location create(Location location);
    public List<Location> retrieveAll();
    public Location update(Location location);
    public Location delete(Location location);
}
