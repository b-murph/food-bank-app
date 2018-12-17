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
public class LocationSvcCacheImpl implements ILocationSvc {
    
    private LocationSvcCacheImpl(){
        
    }
    
    private static LocationSvcCacheImpl instance = new LocationSvcCacheImpl();
    
    public static LocationSvcCacheImpl getInstance(){
        return instance;
    }
    
    private List<Location> cache = new ArrayList<>();
    private int nextID = 0;
    
    public Location create(Location location){
        location.setLocationID(++nextID);
        cache.add(location);
        return location;
    }
    
    public List<Location> retrieveAll(){
        return cache;
    }
    
    public Location update(Location location){
        for (int i = 0; i<cache.size(); i++){
            Location next = cache.get(i);
            if (next.getLocationID() == location.getLocationID()){
                cache.set(i, location);
                break;
            }
        }
        return location;
    }
    
    public Location delete(Location location){
        for (int i = 0; i < cache.size(); i++){
            Location next = cache.get(i);
            if (next.getLocationID() == location.getLocationID()){
                cache.remove(i);
                break;
            }
        }
        return location;
    }
    

}
