package org.swd.starterj.demo;

import java.io.IOException;
import org.openqa.selenium.*;
import org.swd.starterj.core.*;
import org.swd.starterj.demo.testmodel.*;
import org.swd.starterj.demo.testmodel.pages.*;
import static org.testng.Assert.*;
import org.testng.annotations.*;

public class Smoke_test_for_each_pageobject {
    
    public Smoke_test_for_each_pageobject() {
    }

    
    
    public void testPage(MyBasePage page)
    {
        page.invoke();
        page.verifyExpectedElementsAreDisplayed();
    }
    
    @Test
    public void test_EmptyPage() 
    {
        testPage(MyPages.getEmptyPage());
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
