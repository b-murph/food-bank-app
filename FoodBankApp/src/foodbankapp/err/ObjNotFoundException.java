/*
 *  (C) 2017 Richard Blumenthal, All rights reserved
 *  Regis University students are free to use this code for their own
 *  education purposes. Unauthorized duplication or distribution
 *  without the author's permission is strictly forbidden.
 */
package foodbankapp.err;

/** 
 * Thrown when an object isn't found (context specific).
 *
 * @author Rickb
 */
public class ObjNotFoundException extends FoodBankAppException {
    /**
     * Initialize this exception with the given message.
     */
    public ObjNotFoundException(String msg) {
        super(msg);
    }
}