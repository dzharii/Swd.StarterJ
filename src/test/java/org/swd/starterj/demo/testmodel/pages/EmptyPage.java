package org.swd.starterj.demo.testmodel.pages;

/**
 *
 * @author dzhariy
 */
public class EmptyPage extends MyBasePage {

    @Override
    public void invoke() {
        // Does nothing 
    }

    @Override
    public boolean isDisplayed() {
        return true;
    }

    @Override
    public void verifyExpectedElementsAreDisplayed() {
       System.out.println("EmptyPage: does nothing");  
    }
    
}
