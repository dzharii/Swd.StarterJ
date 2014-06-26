/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.swd.starterj.demo;

import java.io.IOException;
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
    public void testJava() 
    {
        System.out.println("Hello Java!");
    }   
    
    @Test
    public void trueShouldNeverBeEqualToFalseSoThisCaseShouldFail() throws IOException 
    {
        WebDriver driver = SwdBrowser.getDriver();
        
        String url = Config.applicationMainUrl();
        driver.navigate().to(url);
        
        assertEquals(true, false, "should fail because tru is not equals to false");
    }
    
        @Test
    public void trueShouldNeverBeEqualToFalseSoThisCaseShouldFail2() throws IOException 
    {
        WebDriver driver = SwdBrowser.getDriver();
        
        String url = "http://automated-testing.info";
        driver.navigate().to(url);
        
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
