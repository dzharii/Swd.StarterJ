package org.swd.starterj.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Framework Configuration File
 * -----------------------------
 * The configuration class in the Swd.Starter allows to change some values without project recompilation, such as:
 * 
 * * Selecting WebBrowser
 * * Setting the main application  URLs and others;
 * 
 * The configuration sub-module is based on standard Java Property. 
 * 
 * The class `Config` read the configuration values from the file `config.properties`
 */
public class Config {
    
    private Config() {
    }
    
    /**
     * Reads a property value from the project configuration file config.properties
     * @param propertyName the parameter name from config.properties file
     * @return property value
     * @throws IOException 
     */
    public static String readProperty(String propertyName ) throws IOException {
        Properties prop = new Properties();
        String result = null;
        
        try (FileInputStream input = new FileInputStream("config.properties"))
        {
            prop.load(input);
            result = prop.getProperty(propertyName);
        }
        catch(IOException e)
        {
            throw e;
        }
        return result;
    }
    
    public static String applicationMainUrl() throws IOException
    {
        return readProperty("applicationMainUrl");
    }
    
    public static String swdBrowserType() throws IOException
    {
        return readProperty("swdBrowserType");
    }
    
    public static boolean swdIsRemote() throws IOException
    {
        return readProperty("swdIsRemote").equalsIgnoreCase("true");
    }
    
    public static String swdRemoteUrl() throws IOException
    {
        return readProperty("swdRemoteUrl");
    }

    /**
     * Add your own configuration parameters
     * -------------------------------------
     * Quick instructions:  
     * 
     * 1. Open the file `config.properties`
     * 2. Add the following line: 
     *    >  yourParameterName=AnyStringValue
     * 3. Create a method with name `yourParameterName` 
     *    which reads configuration file key `yourParameterName`
     *
     * Put your configuration settings below:
     * @throws java.io.IOException
     */
    public static String yourParameterName() throws IOException
    {
        return readProperty("yourParameterName");
    }
    
    
    
}
