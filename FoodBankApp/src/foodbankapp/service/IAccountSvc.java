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
public interface IAccountSvc {
    
    public Account create(Account account);
    public List<Account> retrieveAll();
    public Account update(Account account);
    public Account delete(Account account);
    public Account authenticate(Login login);
    
}
