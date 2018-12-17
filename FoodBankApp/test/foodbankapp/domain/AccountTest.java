/*
 * Version 1.0
 * CS 444
 * 9/15/18
 */
package foodbankapp.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * this will test the meaningful behavior of the Account class
 * @author Brian
 */
public class AccountTest {
    
    public AccountTest() {
    }

    @Test
    public void testValidate() {
        Account account = new Account();
        boolean result = account.validate();
        assertFalse(result);
        account.setName("John Doe");
        result = account.validate();
        assertFalse(result);
        account.setEmail("john.doe@email.com");
        result = account.validate();
        assertFalse(result);
        Login login = new Login();
        login.setUsername("johndoe");
        login.setPassword("123456");
        account.setLogin(login);
        result = account.validate();
        assertFalse(result);
        account.setSecurityLevel("user");
        result = account.validate();
        assertTrue(result);
    }
    
}
