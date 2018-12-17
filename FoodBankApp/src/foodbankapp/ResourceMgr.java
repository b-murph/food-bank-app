/*
 *  (C) 2017 Richard Blumenthal, All rights reserved
 *  Regis University students are free to use this code for their own
 *  education purposes. Unauthorized duplication or distribution
 *  without the author's permission is strictly forbidden.
 */
package foodbankapp;

import foodbankapp.err.MissingPropertyException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A utility Decorator wrapping the application's properties and resource 
 * bundle associated with the current locale, which is specified in the 
 * NonProfit.properties file on the CLASSPATH (see PROPERTY_FILE_PATH).
 * 
 * @author Rickb
 */
public class ResourceMgr {
    /**
     * Logger for any errors.
     */
    private static final Logger LOGGER = Logger.getLogger("ResourceMgr.class");
    
    /**
     * Singleton ResourceMgr instance.
     */
    private static final ResourceMgr SINGLETON;
    
    /**
     * Location of the NonProfit.properties file, which includes settings
     * assigning the current locale.
     */
    private static final String PROPERTY_FILE_PATH = "./resources/FoodBankApp.properties";
    
    private static final String LANGUAGE_PROP = "language";
    
    private static final String COUNTRY_PROP = "country";
  
    /**
     * Location of the UI text resources for a given locale.
     */
    private static final String UI_RESOURCE_PATH = "foodbankapp.resources.Msgs";
    
    static {
        SINGLETON = new ResourceMgr();
    }
    
    /**
     * Return the single instance object of this Resource Manager
     * 
     * @return single ResourceMgr object 
     */
    public static ResourceMgr instance() {
        return SINGLETON;
    }
    
    /**
     * Local cache of properties loaded from the NonProfit.properties file.
     */
    private final Properties properties;
    
    /**
     * The current locale, as specified in the NonProfit.properties file
     */
    private Locale locale;
    
    /**
     * Map from property keys to all text messages displayed in the UI
     * according to the current locale (see locale above).
     */
    private ResourceBundle msgs;
    
    /**
     * Initialize this manager by reading the locale specified in the
     * NonProfit.properties file and loading the associated UI text
     * messages from the corresponding resource messages.
     */
    private ResourceMgr() {
        properties = new Properties();
        
        loadProps(PROPERTY_FILE_PATH);

        try {
            locale = new Locale(getProp(LANGUAGE_PROP), getProp(COUNTRY_PROP));
            
            msgs =  ResourceBundle.getBundle(UI_RESOURCE_PATH, locale);
            
        } catch (MissingPropertyException e) {
            LOGGER.log(Level.SEVERE, "Missing Property", e);
        }
    }
    
    /**
     * Return the current local, as specified in the NonProfit.properties file
     * 
     * @return the current Locale 
     */
    public Locale getLocale() {
        return locale;
    }
    
    /**
     * Return the current local specific UI text message for the given key.
     * 
     * @param key unique identifier for a UI text display message
     * @return the locale specific String for the given key
     */
    public String string(String key) {
        return msgs.getString(key);
    }
    
    /**
     * Return the cached property value for the given property.
     *
     * @param name
     * @return The value of the given property.
     * @exception MissingPropertyException The given property wasn't found.
     */
    public String getProp(String name) throws MissingPropertyException {
	if (properties.containsKey(name)) {
	    return properties.getProperty(name);
	} else {
	    throw new MissingPropertyException(name);
	}
    }
    
    /**
     * Load and cache the properties found in the given properties file.
     * 
     * @param path location of property file, e.g. "./NonProfit.properties"
     */
    private void loadProps(String path) {
	try {
            InputStream strm = getClass().getResourceAsStream(path);

	    if (strm == null)
		throw new FileNotFoundException("property file '" + 
						path +
						"' not found in the classpath");

	    properties.load(strm);

	} catch (FileNotFoundException e) {
	    LOGGER.log(Level.ALL, "PropertyMgr-ERR_100: {0}", e.toString());
	} catch (IOException e) {
	    LOGGER.log(Level.ALL, "PropertyMgr-ERR_101: {0}", e.toString());
	}
    }
}