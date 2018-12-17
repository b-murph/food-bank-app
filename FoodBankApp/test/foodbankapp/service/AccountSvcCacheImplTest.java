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
import foodbankapp.service.AccountSvcCacheImpl;

/**
 *
 * @author Brian
 */
public class AccountSvcCacheImplTest {
    
    public AccountSvcCacheImplTest() {
    }

    @Test
    public void testCRUD() {
        
        AccountSvcCacheImpl impl = AccountSvcCacheImpl.getInstance();
        List<Account> accounts = impl.retrieveAll();
        assertEquals(accounts.size(),0);
        
        Account account = new Account();
        account.setName("John Doe");
        Login login = new Login();
        login.setUsername("johndoe");
        login.setPassword("123456");
        account.setLogin(login);
        
        account = impl.create(account);
        assertNotNull(account);
        assertNotEquals(account.getId(), 0);
        
        accounts = impl.retrieveAll();
        assertEquals(accounts.size(), 1);
        
        account.setName("Jane Doe");
        account = impl.update(account);
        accounts = impl.retrieveAll();
        assertEquals(accounts.size(), 1);
        assertEquals(account.getName(), "Jane Doe");
        
        account = impl.delete(account);
        assertEquals(accounts.size(), 0);
        
        Account account1 = new Account();
        account1.setName("John Doe");
        account1.setEmail("john.doe@gmail.com");
        Login login1 = new Login();
        login1.setUsername("johndoe");
        login1.setPassword("123456");
        account1.setLogin(login1);
        account1 = impl.create(account1);
        assertNotNull(account1);
        
        Account account2 = new Account();
        account2.setName("Jane Doe");
        account2.setEmail("jane.doe@gmail.com");
        Login login2 = new Login();
        login2.setUsername("janedoe");
        login2.setPassword("234567");
        account2.setLogin(login2);
        account2 = impl.create(account2);
        assertNotNull(account2);
        
        Login login3 = new Login();
        login3.setUsername("blank");
        login3.setPassword("notapassword");
        Account authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);
        login3.setUsername("johndoe");
        authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);
        login3.setPassword("123456");
        authenticatedAccount = impl.authenticate(login3);
        assertNotNull(authenticatedAccount);
        login3.setUsername("janedoe");
        authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);
        login3.setPassword("234567");
        authenticatedAccount = impl.authenticate(login3);
        assertNotNull(authenticatedAccount);
    }
    
}
