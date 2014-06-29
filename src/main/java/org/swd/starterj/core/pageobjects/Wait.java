/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.swd.starterj.core.pageobjects;

import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.WebElement;

/**
 *
 * @author dzhariy
 */
public class Wait {
    
    /** 
     * @todo 
     * Needs to be tested!   
     * -------------------
     *  * This method requires unit test
     *  * And documentation
     * 
     * @param element
     * @param timeOutMilliSeconds
     * @return
     * @throws TimeoutException 
     */

    public static WebElement untilVisible(WebElement element, long timeOutMilliSeconds) throws TimeoutException {
        Stopwatch sw = Stopwatch.createStarted();
        while (true) {
            Exception lastException = null;
            try {
                if (element.isDisplayed()) {
                    return element;
                }
                Thread.sleep(100);
            } catch (Exception e) {
                lastException = e;
            }

            long elapsedMillisec = sw.elapsed(TimeUnit.MILLISECONDS);
            if (elapsedMillisec > timeOutMilliSeconds) {
                String exceptionMessage = lastException == null ? "" : lastException.getMessage();
                
                String errorMessage = String.format(
                          "Wait.UntilVisible: Element was not displayed after %s Milliseconds"
                        + "\r\n Error Message:\r\n%s", elapsedMillisec, exceptionMessage);
                
                throw new TimeoutException(errorMessage);
            }
        }
    }
}
