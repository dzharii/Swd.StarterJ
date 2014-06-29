package org.swd.starterj.core.pageobjects;

import java.util.concurrent.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElementExtensions {

    private WebElement sourceWebElement = null;

    /**
     * Default timeout for \see waitUntilVisible methods
     */
    public static long defaultTimeoutMilliseconds = 1000;

    public WebElementExtensions(WebElement sourceElement) {
        sourceWebElement = sourceElement;
    }

    /**
     * Waits until element is visible. Internally, uses element.isDisplayed with
     * ignored WebDriver exceptions
     *
     * @param timeOutMilliSeconds
     * @return the reference to web element if it was found
     * @throws TimeoutException
     */
    public WebElement waitUntilVisible(long timeOutMilliSeconds) throws TimeoutException {
        return Wait.untilVisible(sourceWebElement, timeOutMilliSeconds);
    }

    /**
     * Replaces WebDriver’s element.Text property. Gets value from *input* and
     * *select* tags rather than returning text inside those elements.
     *
     * @return current control value
     */
    public String getElementText() {
        String result = "";
        String tag = sourceWebElement.getTagName().toLowerCase();

        switch (tag) {
            case "input":
                result = sourceWebElement.getAttribute("value");
                break;
            case "select":
                result = new Select(sourceWebElement).getFirstSelectedOption().getText();
                break;
            default:
                result = sourceWebElement.getText();
                break;
        }
        return result;
    }
    
    /**
     * Gets a value indicating whether or not this element is displayed.
     * This method  suppresses any WebDriver exceptions
     * @return 
     */
    public boolean isDisplayedSafe() {
        boolean result = false;
        try {
            result = sourceWebElement.isDisplayed();
        } catch (Exception e) {
            // Empty; Ignored
        }
        return result;
    }

}
