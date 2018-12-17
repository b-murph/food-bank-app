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
public interface ITransactionSvc {
    
    public Transaction create(Transaction transaction);
    public List<Transaction> retrieveAll();
    public Transaction update(Transaction transaction);
    public Transaction delete(Transaction transaction);
    
}
