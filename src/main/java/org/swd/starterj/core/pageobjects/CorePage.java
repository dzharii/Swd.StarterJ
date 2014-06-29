package org.swd.starterj.core.pageobjects;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.phantomjs.*;
import org.openqa.selenium.safari.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.support.PageFactory;

import org.swd.starterj.core.SwdBrowser;

/**
 * Base page
 * Automatically initializes the derived PageObject classes with PageFactory
 */
public abstract class CorePage {
    
    public WebDriver getDriver()
    {
        return SwdBrowser.getDriver();
    }

    /**
     * 
     * @param sourceElement: Webdriver PageObject element
     * @return 
     */
    public WebElementExtensions with(WebElement sourceElement)
    {
        return new WebElementExtensions(sourceElement);
    }
    
    public CorePage()
    {
        PageFactory.initElements(getDriver(), this);
    }
}
