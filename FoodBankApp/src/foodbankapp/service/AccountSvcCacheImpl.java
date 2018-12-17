/*
 * Version 1.0
 * CS 444
 * 9/20/18
 */
package foodbankapp.service;

import foodbankapp.domain.*;
import java.util.*;

/**
 *
 * @author Brian
 */
public class AccountSvcCacheImpl implements IAccountSvc {
    
    private AccountSvcCacheImpl(){
        
    }
    
    private static AccountSvcCacheImpl instance = new AccountSvcCacheImpl();
    
    public static AccountSvcCacheImpl getInstance(){
        return instance;
    }
    
    private List<Account> cache = new ArrayList<>();
    private int nextID = 0;
    
    public Account create(Account account){
        account.setId(++nextID);
        cache.add(account);
        return account;
    }
    
    public List<Account> retrieveAll(){
        return cache;
    }
    
    public Account update(Account account){
        for (int i = 0; i<cache.size(); i++){
            Account next = cache.get(i);
            if (next.getId() == account.getId()){
                cache.set(i, account);
                break;
            }
        }
        return account;
    }
    
    public Account delete(Account account){
        for (int i = 0; i < cache.size(); i++){
            Account next = cache.get(i);
            if (next.getId() == account.getId()){
                cache.remove(i);
                break;
            }
        }
        return account;
    }
    
    public Account authenticate(Login login){
        Account account = null;
        for (int i=0; i<cache.size(); i++){
            account = cache.get(i);
            Login accountLogin = account.getLogin();
            if (login.equals(accountLogin)) return account;
        }
        return null;
    }
    
}
