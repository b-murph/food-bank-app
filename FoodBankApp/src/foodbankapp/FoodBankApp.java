/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodbankapp;

import foodbankapp.presentation.LoginUI;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;
/**
 *
 * @author Brian
 */
public class FoodBankApp {

     private static final Logger LOGGER = 
            Logger.getLogger(FoodBankApp.class.getName());
    
    private static final String LOGGER_PROPERTIES =
            "./resources/logging.properties";
    
    // Configure the LOGGER using the properties in LOGGER_PROPERTIES
    static {
        final InputStream strm = 
           FoodBankApp.class.getResourceAsStream(LOGGER_PROPERTIES);
        
       try {
            LogManager.getLogManager().readConfiguration(strm);
        } catch (IOException e) {
        
            LOGGER.severe("Error loading ./logging.properties");
           LOGGER.severe(e.getMessage());
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        LOGGER.info("Starting Food Bank App...");
        ResourceMgr.instance(); 
        
        LoginUI login = new LoginUI();
        login.setVisible(true);
        LOGGER.info("Food Bank App Started");
    }
    
}
