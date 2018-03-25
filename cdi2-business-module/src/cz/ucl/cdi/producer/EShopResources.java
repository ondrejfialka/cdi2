package cz.ucl.cdi.producer;

import java.io.*;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import cz.ucl.cdi.annotation.Configuration;
import cz.ucl.cdi.annotation.ConfigurationFile;

@ApplicationScoped
public class EShopResources {
    @Produces   
    @ApplicationScoped
    @ConfigurationFile
    public Reader getConfigurationFile() {
        Reader result = null;

        try {
            String path = System.getProperty("user.home");
            result = new FileReader(path + "/eshop_config.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return result;
    }

    public void closeConfigurationFile(@Disposes @ConfigurationFile Reader r) {
        try {
            r.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Produces
    @ApplicationScoped
    @Configuration
    public Properties getConfiguration(@ConfigurationFile Reader r) {
        Properties result = new Properties();
        try {
            result.load(r);
        } catch (IOException e) {           
            e.printStackTrace();
        }
        return result;
    }
}
