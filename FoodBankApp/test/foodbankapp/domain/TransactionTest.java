/*
 * Version 1.0
 * CS 444
 * 9/15/18
 */
package foodbankapp.domain;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;

/**
 *
 * @author Brian
 */
public class TransactionTest {
    
    public TransactionTest() {
    }

    @Test
    public void testValidate() {
        Transaction transaction = new Transaction();
        Date date = new Date();
        boolean result = transaction.validate();
        assertFalse(result);
        transaction.setDate(date);
        result = transaction.validate();
        assertFalse(result);
        transaction.setItem("food");
        result = transaction.validate();
        assertFalse(result);
        transaction.setAmount(1);
        result = transaction.validate();
        assertTrue(result);
        
    }
    
}
