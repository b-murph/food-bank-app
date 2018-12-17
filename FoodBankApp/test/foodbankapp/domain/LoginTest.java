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
public class LoginTest {
    
    public LoginTest() {
    }

    @Test
    public void testValidate() {
        Login login = new Login();
        boolean result = login.validate();
        assertFalse(result);
        login.setUsername("johndoe");
        result = login.validate();
        assertFalse(result);
        login.setPassword("123456");
        result = login.validate();
        assertTrue(result);
    }
    
    @Test
    public void testEquals(){
        Login login1 = new Login();
        login1.setUsername("johndoe");
        login1.setPassword("12345");
        
        Login login2 = new Login();
        login2.setUsername("janedoe");
        login2.setPassword("56789");
        
        assertFalse(login1.equals(login2));
        login2.setUsername("johndoe");
        assertFalse(login1.equals(login2));
        login2.setPassword("12345");
        assertTrue(login1.equals(login2));
    }
    
}
