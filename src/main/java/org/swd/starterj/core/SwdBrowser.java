package org.swd.starterj.core;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.*;

public class SwdBrowser {
    
    private static WebDriverWrapper wrapper = null;
    
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
        if (wrapper == null) {
            // TODO: Implement browser creation from 
            // configuration file
            wrapper = WebDriverWrapper.getInstance();
        }
        return wrapper.getDriver();
    }
}
