/*
 * Version 1.0
 * CS 444
 * 9/20/18
 */
package service;

import foodbankapp.domain.*;
import java.util.*;
/**
 *
 * @author Brian
 */
public class InventorySvcCacheImpl implements IInventorySvc {
    
    private InventorySvcCacheImpl(){
        
    }
    
    private static InventorySvcCacheImpl instance = new InventorySvcCacheImpl();
    
    public static InventorySvcCacheImpl getInstance(){
        return instance;
    }
    
    private List<Inventory> cache = new ArrayList<>();
        
    public Inventory create(Inventory inventory){
        cache.add(inventory);
        return inventory;
    }
    
    public List<Inventory> retrieveAll(){
        return cache;
    }
    
    public Inventory update(Inventory inventory){
        for (int i = 0; i<cache.size(); i++){
            Inventory next = cache.get(i);
            if (next.getName().equals(inventory.getName())){
                cache.set(i, inventory);
                break;
            }
        }
        return inventory;
    }
    
    public Inventory delete(Inventory inventory){
        for (int i = 0; i<cache.size(); i++){
            Inventory next = cache.get(i);
            if (next.getName().equals(inventory.getName())){
                cache.remove(i);
                break;
            }
        }
        return inventory;
    }
    
}
