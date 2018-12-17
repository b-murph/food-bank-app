/*
 *  (C) 2017 Richard Blumenthal, All rights reserved
 *  Regis University students are free to use this code for their own
 *  education purposes. Unauthorized duplication or distribution
 *  without the author's permission is strictly forbidden.
 */
package foodbankapp.xml;

/** 
 * Thrown when an unexpected, non-recoverable error occurred associated with
 * processing an XML file.
 * 
 * As this exception is not logged, it should be logged when caught
 *
 * @author Rickb
 */
public class XmlException extends Exception {
    /**
     * Initialize this exception with the given message.
     * 
     * @param msg descriptive information about this exception
     */
    public XmlException(String msg) {
        super(msg);
    }
    
    /**
     * Initialize this exception with the given message and cause
     * @param msg descriptive information about this exception
     * @param cause the original cause of this exception
     */
    public XmlException(String msg, Throwable cause) {
        super(msg, cause);
    }
}