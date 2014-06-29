package org.swd.starterj.demo.testmodel.pages;
 
import java.util.List;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
 
public class TwitterLoginPage extends MyBasePage {
        
            @FindBy(how=How.XPATH, using="id(\"signin-email\")")
            private WebElement txtLogin;
        
        
            @FindBy(how=How.XPATH, using="id(\"front-container\")/div[2]/div[2]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/button[1]")
            private WebElement btnEnter;
        
 
    @Override
    public void invoke() {
        if (!isDisplayed()) {
            getDriver().get("http://twitter.com");
        }
    }
 
    @Override
    public boolean isDisplayed() {
        return with(btnEnter).isDisplayedSafe();
    }
 
    @Override
    public void verifyExpectedElementsAreDisplayed() throws Throwable{
        verifyElementVisible("txtLogin", txtLogin);
        verifyElementVisible("btnEnter", btnEnter);
    }
}