/*
 * Version 1.0
 * CS 444
 * 9/15/18
 */
package foodbankapp.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brian
 */
public class InventoryTest {
    
    public InventoryTest() {
    }

    @Test
    public void testValidate() {
        Inventory inventory = new Inventory();
        boolean result = inventory.validate();
        assertFalse(result);
        inventory.setAmount(-1.5);
        inventory.setCost(-1.5);
        inventory.setName("food");
        result = inventory.validate();
        assertFalse(result);
        inventory.setUnit("liters");
        result = inventory.validate();
        assertFalse(result);
        inventory.setAmount(1);
        result = inventory.validate();
        assertFalse(result);
        inventory.setCost(1);
        result = inventory.validate();
        assertTrue(result);
    }
    
  
    
}
