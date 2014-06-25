
package org.swd.starterj.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class WebDriverWrapper {
    private static WebDriver driver = null;
    private static WebDriverWrapper instance = null;

    private WebDriverWrapper() {
    }
    
    public static WebDriverWrapper getInstance()
    {
        if (instance == null) {
            instance = new WebDriverWrapper();
            instance.addShutDownHook();
        }
        return instance;
    }

    public WebDriver getDriver()
    {
        if (driver == null) {
            // TODO: Implement browser creation from 
            // configuration file
            driver = new FirefoxDriver();
        }
        return driver;
    } 

    private void addShutDownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
               if (driver != null)
               {
                   driver.quit();
                   driver = null;
               }
            }
        });
       }
    }
        
        
        
} 

    
