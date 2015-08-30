package org.swd.starterj.core;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
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
    public static final String BROWSER_FIREFOX = "Firefox";
    public static final String BROWSER_CHROME = "Chrome";
    public static final String BROWSER_IE = "InternetExplorer";
    public static final String BROWSER_PHANTOM_JS = "PhantomJS";
    public static final String BROWSER_HTML_UNIT = "HtmlUnit";
    public static final String BROWSER_HTML_UNIT_JS = "HtmlUnitWithJavaScript";
    public static final String BROWSER_OPERA = "Opera";
    public static final String BROWSER_SAFARI = "Safari";
    public static final String BROWSER_IPHONE = "IPhone";
    public static final String BROWSER_IPAD = "IPad";
    public static final String BROWSER_ANDROID = "Android";

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
            newDriver = connetctToRemoteWebDriver(browserType, remoteUrl);
        } else {
            newDriver = startEmbededWebDriver(browserType);
        }
        return newDriver;
    }

    private WebDriver connetctToRemoteWebDriver(String browserType, String remoteUrl) throws MalformedURLException {
        DesiredCapabilities caps = null;
        URL hubUri = new URL(remoteUrl);

        switch (browserType) {

            case BROWSER_FIREFOX:
                caps = DesiredCapabilities.firefox();
                break;
            case BROWSER_CHROME:
                caps = DesiredCapabilities.chrome();
                break;
            case BROWSER_IE:
                caps = DesiredCapabilities.internetExplorer();
                break;
            case BROWSER_PHANTOM_JS:
                caps = DesiredCapabilities.phantomjs();
                break;
            case BROWSER_HTML_UNIT:
                caps = DesiredCapabilities.htmlUnit();
                break;
            case BROWSER_HTML_UNIT_JS:
                caps = DesiredCapabilities.htmlUnitWithJs();
                break;
            case BROWSER_OPERA:
                caps = DesiredCapabilities.opera();
                break;
            case BROWSER_SAFARI:
                caps = DesiredCapabilities.safari();
                break;
            case BROWSER_IPHONE:
                caps = DesiredCapabilities.iphone();
                break;
            case BROWSER_IPAD:
                caps = DesiredCapabilities.ipad();
                break;
            case BROWSER_ANDROID:
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

    private WebDriver startEmbededWebDriver(String browserType) {
        switch (browserType) {
            case BROWSER_FIREFOX:
                return new FirefoxDriver();
            case BROWSER_CHROME:
                return new ChromeDriver();
            case BROWSER_IE:
                return new InternetExplorerDriver();
             case BROWSER_SAFARI:
                return new SafariDriver();
            default:
                String errorMessage = String.format(
                        "browserType: <%s> was not recognized as supported browser."
                        + " This parameter is case sensitive", browserType);
                throw new IllegalArgumentException(errorMessage);
        }
    }
}
