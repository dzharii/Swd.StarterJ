package org.swd.starterj.demo.testmodel.pages;

import org.openqa.selenium.WebElement;
import org.swd.starterj.core.pageobjects.*;

/**
 *
 * Base Page for current TestModel
 */
public abstract class MyBasePage extends CorePage implements SelfTestingPage {

    @Override
    public abstract void invoke();

    @Override
    public abstract boolean isDisplayed();

    @Override
    public abstract void verifyExpectedElementsAreDisplayed() throws Throwable;

    /**
     * Verifies the expected WebElement to be Visible
     */
    // 
    public void verifyElementVisible(String elementName, WebElement webElement) throws Throwable {
        if (!webElement.isDisplayed()) {
            String message = "Error: WebElement with name <" + elementName + ">\n"
                    + "was expected to be visible,"
                    + "but the element was not found on the page.";

            throw new Exception(message);
        }
    }

}
