package org.swd.starterj.core;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.*;

public final class SwdBrowser {
    
    private static WebDriverRunner webDriverRunner = null;
    
    private SwdBrowser(){
    }
    
    /**
     * Returns current WebDriver instance.    
     *
     * * When the Driver was already created and the browser was opened – the 
     *  property returns a reference to current browser.  
     * * If the Driver was not initialized yet – it will create a new browser 
     *  (WebDriver) instance automatically, according to the configuration file. 
    */
    public static WebDriver getDriver()
    {
        if (webDriverRunner == null) {
            // TODO: Implement browser creation from 
            // configuration file
            webDriverRunner = WebDriverRunner.getInstance();
        }
        
        WebDriver driver = null; 
        try {
            driver = webDriverRunner.getDriver();
        } catch (IOException ex) {
            Logger.getLogger(SwdBrowser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return driver;
    }
}
