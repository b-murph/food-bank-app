/*
 * Version 1.0
 * CS 444
 * 9/20/18
 */
package foodbankapp.service;

import org.junit.Test;
import static org.junit.Assert.*;
import foodbankapp.domain.*;
import java.util.*;
import service.InventorySvcCacheImpl;

/**
 *
 * @author Brian
 */
public class InventorySvcCacheImplTest {
    
    public InventorySvcCacheImplTest() {
    }

    @Test
    public void testCRUD() {
        InventorySvcCacheImpl impl = InventorySvcCacheImpl.getInstance();
        List<Inventory> inventories = impl.retrieveAll();
        assertEquals(inventories.size(),0);
        
        Inventory inventory = new Inventory();
        inventory.setName("food");
                
        inventory = impl.create(inventory);
        assertNotNull(inventory);
        assertNotNull(inventory.getName());
        
        inventories = impl.retrieveAll();
        assertEquals(inventories.size(), 1);
        
        inventory.setName("drink");
        inventory = impl.update(inventory);
        inventories = impl.retrieveAll();
        assertEquals(inventories.size(), 1);
        assertEquals(inventory.getName(), "drink");
        
        inventory = impl.delete(inventory);
        assertEquals(inventories.size(), 0);
    }
    
}
