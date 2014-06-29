/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.swd.starterj.demo.testmodel;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.swd.starterj.demo.testmodel.pages.*;

/**
 *
 * @author dzhariy
 */
public class MyPages {
    
    public static <T extends MyBasePage> T getPage(Class<T> pageObjectClass)
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
