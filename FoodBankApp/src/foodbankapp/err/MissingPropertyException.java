/*
 *  (C) 2017 Richard Blumenthal, All rights reserved
 *  Regis University students are free to use this code for their own
 *  education purposes. Unauthorized duplication or distribution
 *  without the author's permission is strictly forbidden.
 */
package foodbankapp.err;

/**
 * Thrown when a property cannot be found.
 *
 * @author Rickb
 */
public class MissingPropertyException extends Exception {
    /**
     * Construct this new instance with the given message.
     *
     * @param property the property key string, (e.g. "rct2.DebugLevel")
     */
    public MissingPropertyException(String property) {
	super("Missing property " + property);
    }

    /**
     * Initialize this new instance with the given message and
     * and java exception that initially caused this exception.
     *
     * @param property the property key string
     *                 (e.g. "edu.regis.tibis.DebugLevel")
     * @param cause the Java exception that caused this exception.
     */
    public MissingPropertyException(String property, Throwable cause) {
	super(("Missing property " + property), cause);
    }
}

