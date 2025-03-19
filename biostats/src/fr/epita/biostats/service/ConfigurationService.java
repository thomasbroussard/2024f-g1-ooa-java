package fr.epita.biostats.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationService {

    Properties properties = new Properties();

    public ConfigurationService() throws IOException {
        properties.load(new FileReader("biostats/configuration.properties"));
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }
}
