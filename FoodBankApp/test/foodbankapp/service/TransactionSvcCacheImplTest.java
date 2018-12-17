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
import service.TransactionSvcCacheImpl;

/**
 *
 * @author Brian
 */
public class TransactionSvcCacheImplTest {
    
    public TransactionSvcCacheImplTest() {
    }

    @Test
    public void testCRUD() {
        TransactionSvcCacheImpl impl = TransactionSvcCacheImpl.getInstance();
        List<Transaction> transactions = impl.retrieveAll();
        assertEquals(transactions.size(),0);
        
        Transaction transaction = new Transaction();
        transaction.setItem("food");
        
        transaction = impl.create(transaction);
        assertNotNull(transaction);
        assertNotEquals(transaction.getID(), 0);
        
        transactions = impl.retrieveAll();
        assertEquals(transactions.size(), 1);
        
        transaction.setItem("drink");
        transaction = impl.update(transaction);
        transactions = impl.retrieveAll();
        assertEquals(transactions.size(), 1);
        assertEquals(transaction.getItem(), "drink");
        
        transaction = impl.delete(transaction);
        assertEquals(transactions.size(), 0);
    }
    
}
