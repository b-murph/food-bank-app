/*
 *  (C) 2017 Richard Blumenthal, All rights reserved
 *  Regis University students are free to use this code for their own
 *  education purposes. Unauthorized duplication or distribution
 *  without the author's permission is strictly forbidden.
 */
package foodbankapp.xml;

import foodbankapp.err.FoodBankAppException;
import foodbankapp.err.ObjNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Utility for reading XML files located in a NetBeans project data directory.
 * 
 * @author Rickb
 */
public class XmlMgr {
    /**
     * Log unexpected events to this logger.
     */
    private static final Logger LOGGER = 
            Logger.getLogger(XmlMgr.class.getName());
    
    /**
     * The singleton instance of this class.
     */
    public static final XmlMgr SINGLETON = new XmlMgr();
    
    /**
     * Return the singleton object for this class.
     * 
     * @return 
     */
    public static XmlMgr instance() {
        return SINGLETON;
    }
    
    /**
     * The "Data/" directory path within the current NetBeans project
     */
    private String dataDirectory;
    
    /**
     * Initialize this Xml Manager by setting the default data directory.
     */
    private XmlMgr() {
        String netBeansDir = System.getProperty("user.dir");
        dataDirectory =  netBeansDir + "/Data/";
    }
    
    public boolean fileExists(String fileName) {
        File file = findFile(fileName);
        
        if ((file == null) || (!file.exists())) {
            return false;
        } else {
            return true;
        }        
    }
    
    /**
     * Return an open file with the given file name, which you must
     * eventually close.
     * 
     * This opens a file in "edu.regis.nonprofit.data" on the CLASSPATH with
     * a name like "Oranization_n.xml", which might not be a good idea.
     * Pro: We don't mess with the computer's disk outside of this project.
     * Cons: New files don't show up in the NetBeans IDE and can be deleted
     *       accidentally when a new project is imported.
     * 
     * 
     * @param fileName
     * @return the open file, make sure you close it.
     * @throws FileNotFoundException 
     */
    public FileOutputStream openFile(String fileName) 
            throws FileNotFoundException {

        String path = dataDirectory + fileName;
            
        return new FileOutputStream(new File(path));
    }
    
    /**
     * Delete the file with the given name
     * 
     * @param fileName String e.g. "Oranization_1.xml"
     * @throws FoodBankAppException 
     */
    public void deleteFile(String fileName) throws FoodBankAppException {
        File file = findFile(fileName);
  
        file.delete();
    }
    
    /**
     * Return the file with the given name
     * 
     * @param fileName String e.g. "Oranization_1.xml"
     * @return a File object corresponding to the given file name
     */
    public File findFile(String fileName) {
        String path = dataDirectory + fileName;
        
        return new File(path);
    }
    
    /**
     * Return the next available organization id.
     * 
     * Scans the existing Oranization_n.xml files until a file with 'n'
     * doesn't exists and then 'n' is returned.
     * 
     * @return an int for the next available id.
     */
    public int nextId() {
        String fileName;
        int id = 1;
        
        do {
            fileName = "Organization_" + id + ".xml";
            String fullPath = dataDirectory + fileName;

            Path path = Paths.get(dataDirectory);

            if (Files.exists(path)) {
                return id;
            } else {
                id++;
            }
        
        } while (id < Integer.MAX_VALUE);
        
        return -1;
    }
    
      /**
     * Return the XML root Element in the given file.
     * 
     * @param fileName a fileName.xml appearing on the CLASSPATH
     * @return the root element in the given file.
     * @throws ObjNotFoundException the file is not on the CLASSPATH
     * @throws XmlException a non-recoverable error occurred
     */
    public Element findRoot(String fileName) 
            throws ObjNotFoundException, XmlException {
        try {
            InputStream in = new FileInputStream(findFile(fileName));
 
            if (in == null)
                throw new ObjNotFoundException(dataDirectory + fileName);
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
          
            Document doc = dBuilder.parse(in);
			
            //optional, but recommended, see:
            //http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();
        
            return doc.getDocumentElement();
        
        } catch (ParserConfigurationException e) {
            throw new XmlException("XML_ERR_1 ", e);
        } catch (IOException e) {
            throw new XmlException("XML_ERR_2 ", e);
        } catch (SAXException e) {
            throw new XmlException("XML_ERR_3 ", e);
        }
    }

    /**
     * Return the content of the given element tag (e.g. &lt;tag>content&lt;/tag>).
     * Assumes the tag only appears once in the document
     * 
     * @param root the root element of the corresponding document to search
     * @param tag an element in the document (e.g. "&lt;tag>")
     * @return the text content for the tag or an empty string, if not found.
     */
    public static String contentText(Element root, String tag) {
        NodeList nodes = root.getElementsByTagName(tag);
        
        if (nodes.getLength() == 0) {
            LOGGER.log(Level.ALL, "XmlMgr: Unknown tag: {0}", tag);
            return "";
        } else {
            Node node = nodes.item(0);
        
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                return element.getTextContent();
            } else {
                LOGGER.log(Level.ALL, "XmlMgr: Unknown tag type: {1}", tag);
                return "";
            }
        }
    }
    
    /**
     * Return the attribute value for the named attribute in the given element
     * (The attribute should exists or a warning is logged)
     * @param element
     * @param name
     * @return 
     */
    public static String getAttribute(Element element, String name) {
        String val = element.getAttribute(name);
        
        if (val.equals(""))
            LOGGER.log(Level.ALL, "Missing or empty attribute {0}", name);
        
        return val;
    }
    
    /**
     * Return the optional attribute value for the named attribute in the 
     * given element
     * 
     * @param element
     * @param name
     * @return 
     */
    public static String getOptAttribute(Element element, String name) {
        return element.getAttribute(name);
    }
    
    /**
     * Return the int value of the named attribute in the given element
     * 
     * @param element
     * @param name
     * @return 
     */
    public static int getIntAttribute(Element element, String name) {
        String val = element.getAttribute(name);
        
        if (val.equals("")) {
            LOGGER.log(Level.ALL, "Missing or empty attribute {0}", name);
            return -1;
        } else {
            try {
                return Integer.parseInt(val);
            } catch (NumberFormatException e) {
                LOGGER.log(Level.ALL, "Expected in attribute value: {1}", name);
                return -1;
            }
        }
    }
    
    /**
     * Return the float value of the named attribute in the given element
     * 
     * @param element
     * @param name
     * @return 
     */
    public static float getFloatAttribute(Element element, String name) {
        String val = element.getAttribute(name);
        
        if (val.equals("")) {
            LOGGER.log(Level.ALL, "Missing or empty attribute {0}", name);
            return 0.0f;
        } else {
            try {
                return Float.parseFloat(val);
                
            } catch (NumberFormatException e) {
                LOGGER.log(Level.ALL, "Expected in attribute value: {1}", name);
                return 0.0f;
            }
        }
    }
}