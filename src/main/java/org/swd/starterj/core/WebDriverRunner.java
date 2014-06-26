package org.swd.starterj.core;

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


class WebDriverRunner {

    private static WebDriver driver = null;
    private static WebDriverRunner instance = null;

    /*
     Supported Browsers
     */
    public static final String browser_Firefox = "Firefox";
    public static final String browser_Chrome = "Chrome";
    public static final String browser_InternetExplorer = "InternetExplorer";
    public static final String browser_PhantomJS = "PhantomJS";
    public static final String browser_HtmlUnit = "HtmlUnit";
    public static final String browser_HtmlUnitWithJavaScript = "HtmlUnitWithJavaScript";
    public static final String browser_Opera = "Opera";
    public static final String browser_Safari = "Safari";
    public static final String browser_IPhone = "IPhone";
    public static final String browser_IPad = "IPad";
    public static final String browser_Android = "Android";

    private WebDriverRunner() {

    }

    public static WebDriverRunner getInstance() {
        if (instance == null) {
            instance = new WebDriverRunner();
            instance.addShutDownHook();
        }
        return instance;
    }

    public WebDriver getDriver() throws MalformedURLException, IOException {
        if (driver == null) {
            // TODO: Implement browser creation from 
            // configuration file
            driver = RunDriver(Config.swdBrowserType(), Config.swdIsRemote(), Config.swdRemoteUrl());
        }
        return driver;
    }

    private void addShutDownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                if (driver != null) {
                    driver.quit();
                    driver = null;
                }
            }
        });
    }

    /**
     * Creates new local or remote WebDriver instance
     *
     * @param browserType
     * @param isRemote
     * @param remoteUrl
     * @return
     */
    private WebDriver RunDriver(String browserType, boolean isRemote, String remoteUrl) throws MalformedURLException {
        WebDriver newDriver = null;
        if (isRemote) {
            newDriver = ConnetctToRemoteWebDriver(browserType, remoteUrl);
        } else {
            newDriver = StartEmbededWebDriver(browserType);
        }
        return newDriver;
    }

    private WebDriver ConnetctToRemoteWebDriver(String browserType, String remoteUrl) throws MalformedURLException {
        DesiredCapabilities caps = null;
        URL hubUri = new URL(remoteUrl);

        switch (browserType) {

            case browser_Firefox:
                caps = DesiredCapabilities.firefox();
                break;
            case browser_Chrome:
                caps = DesiredCapabilities.chrome();
                break;
            case browser_InternetExplorer:
                caps = DesiredCapabilities.internetExplorer();
                break;
            case browser_PhantomJS:
                caps = DesiredCapabilities.phantomjs();
                break;
            case browser_HtmlUnit:
                caps = DesiredCapabilities.htmlUnit();
                break;
            case browser_HtmlUnitWithJavaScript:
                caps = DesiredCapabilities.htmlUnitWithJs();
                break;
            case browser_Opera:
                caps = DesiredCapabilities.opera();
                break;
            case browser_Safari:
                caps = DesiredCapabilities.safari();
                break;
            case browser_IPhone:
                caps = DesiredCapabilities.iphone();
                break;
            case browser_IPad:
                caps = DesiredCapabilities.ipad();
                break;
            case browser_Android:
                caps = DesiredCapabilities.android();
                break;
            default:
                String errorMessage = String.format(
                        "browserType: <%s> was not recognized as supported browser."
                        + " This parameter is case sensitive", browserType);
                throw new IllegalArgumentException(errorMessage);
        }
        RemoteWebDriver newDriver = new RemoteWebDriver(hubUri, caps);
        return newDriver;

    }

    private WebDriver StartEmbededWebDriver(String browserType) {
        switch (browserType) {
            case browser_Firefox:
                return new FirefoxDriver();
            case browser_Chrome:
                return new ChromeDriver();
            case browser_InternetExplorer:
                return new InternetExplorerDriver();
            case browser_PhantomJS:
                return new PhantomJSDriver();
            case browser_Safari:
                return new SafariDriver();
            default:
                String errorMessage = String.format(
                        "browserType: <%s> was not recognized as supported browser."
                        + " This parameter is case sensitive", browserType);
                throw new IllegalArgumentException(errorMessage);
        }
    }
}
