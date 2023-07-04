package util;

import config.TestSetup;

import java.io.InputStream;
import java.util.Properties;


import static config.TestSetup.getEnvironmentFromMaven;

public class TestDataReader {

    public static String getTestData(String key) {
        Properties properties = new Properties();
        try (InputStream inputStream = TestSetup.class.getResourceAsStream("/" + getEnvironmentFromMaven() + "Config.properties")) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return properties.getProperty(key);
    }
}
