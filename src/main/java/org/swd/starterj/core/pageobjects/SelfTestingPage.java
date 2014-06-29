package org.swd.starterj.core.pageobjects;

/**
 * SelfTestingPage indicates that the PageObject can be self-tested 
 * e.g. added to the smoke-test suite which opens the page and verifies if the 
 * actual web-elements on the real page 
 * still correspond to PageObject class declarations.
 * 
 */
public interface SelfTestingPage {
        
    /** 
     * Opens the real page.
     *  
     */
    void invoke();
    
    /**
     *  Checks if the current page is actually displayed on the user screen
     * @return true if the page is opened 
     */
    boolean isDisplayed();
    
    /**
     * Performs user defined self-testing actions. Usually, 
     * checks if the declared controls are present on the user screen
     * for opened web page
     * @throws java.lang.Throwable
     */
    void verifyExpectedElementsAreDisplayed() throws Throwable;    
}
