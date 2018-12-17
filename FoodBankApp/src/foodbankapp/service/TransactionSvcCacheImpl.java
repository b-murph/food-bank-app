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
public class TransactionSvcCacheImpl implements ITransactionSvc {
    
    private TransactionSvcCacheImpl(){
        
    }
    
    private static TransactionSvcCacheImpl instance 
            = new TransactionSvcCacheImpl();
    
    public static TransactionSvcCacheImpl getInstance(){
        return instance;
    }
    
    private List<Transaction> cache = new ArrayList<Transaction>();
    private int nextID = -1;
    
    public Transaction create(Transaction transaction){
        transaction.setID(++nextID);
        cache.add(transaction);
        return transaction;
    }
    
    public List<Transaction> retrieveAll(){
        return cache;
    }
    
    public Transaction update(Transaction transaction){
        for (int i = 0; i<cache.size(); i++){
            Transaction next = cache.get(i);
            if (next.getID() == transaction.getID()){
                cache.set(i, transaction);
                break;
            }
        }
        return transaction;
    }
    
    public Transaction delete(Transaction transaction){
        for (int i = 0; i < cache.size(); i++){
            Transaction next = cache.get(i);
            if (next.getID() == transaction.getID()){
                cache.remove(i);
                break;
            }
        }
        return transaction;
    }
}
