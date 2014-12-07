package org.swd.starterj.demo.testmodel;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.swd.starterj.demo.testmodel.pages.*;

public class MyPages {
    
    private static <T extends MyBasePage> T getPage(Class<T> pageObjectClass)
    {
        T newInstance = null;
        
        try {
            newInstance = pageObjectClass.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MyPages.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  newInstance;
    }
    
    public static final EmptyPage getEmptyPage()
    {
        return getPage(EmptyPage.class);
    }
    
    public static final TwitterLoginPage getTwitterLoginPage () { 
        return getPage(TwitterLoginPage.class); 
    }
    
    
    // Put your new pages here:
}
