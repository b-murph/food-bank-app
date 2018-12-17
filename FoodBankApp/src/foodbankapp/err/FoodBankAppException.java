/*
 *  (C) 2017 Richard Blumenthal, All rights reserved
 *  Regis University students are free to use this code for their own
 *  education purposes. Unauthorized duplication or distribution
 *  without the author's permission is strictly forbidden.
 */
package foodbankapp.err;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Root of all checked application exceptions, which logs its errors.
 * 
 * In general these exceptions signal recoverable non-error conditions.
 * 
 * @author Rickb
 */
public class FoodBankAppException extends Exception {
     /**
     * Handler for logging messages. Log4j
     */
    private static final Logger LOGGER = 
            Logger.getLogger(FoodBankAppException.class.getName());

    /**
     * Initialize this new instance with the given message.
     *
     * @param msg a string describing the cause of this exception.
     */
    public FoodBankAppException(String msg) {
	super(msg);
        
        LOGGER.log(Level.SEVERE, "NpAppException: {0}", msg);
    }

    /**
     * Initialize this new instance with the given message and
     * and java exception that caused this exception.
     *
     * @param msg a string describing the cause of this exception.
     * @param cause the Java exception that caused this IRBt exception.
     */
    public FoodBankAppException(String msg, Throwable cause) {
	super(msg, cause);

        LOGGER.log(Level.SEVERE, msg, cause);
    }
}

