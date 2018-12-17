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
public interface IInventorySvc {
    
    public Inventory create(Inventory inventory);
    public List<Inventory> retrieveAll();
    public Inventory update(Inventory inventory);
    public Inventory delete(Inventory inventory);
    
    
}
