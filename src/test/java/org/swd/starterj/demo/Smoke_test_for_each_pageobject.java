/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.swd.starterj.demo;

import static org.testng.Assert.*;
import org.testng.annotations.*;
import org.swd.starterj.core.*;
import org.openqa.selenium.*;
/**
 *
 * @author dzhariy
 */
public class Smoke_test_for_each_pageobject {
    
    public Smoke_test_for_each_pageobject() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void trueShouldNeverBeEqualToFalseSoThisCaseShouldFail() 
    {
        WebDriver driver = SwdBrowser.getDriver();
        driver.navigate().to("http://swd-tools.com");
//        driver.quit();
        
        assertEquals(true, false, "should fail because tru is not equals to false");
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
