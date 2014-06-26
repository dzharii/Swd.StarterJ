package org.swd.starterj.demo.testmodel.pages;

import org.swd.starterj.core.pageobjects.*;

/**
 *
 * Base Page for current TestModel
 */
public abstract class MyBasePage extends CorePage implements SelfTestingPage  {

    @Override
    public abstract void invoke();

    @Override
    public abstract boolean isDisplayed();

    @Override
    public abstract void verifyExpectedElementsAreDisplayed();
    
}
