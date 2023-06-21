package util;

import config.TestSetup;

import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import static config.TestSetup.getEnvironmentFromMaven;

public class TestDataReader {

    public static String getTestData(String key) {
        Properties properties = new Properties();
        try (InputStream inputStream = TestSetup.class.getResourceAsStream("/" + getEnvironmentFromMaven() + "Config.properties")) {
            System.out.println("/" + getEnvironmentFromMaven() + "Config.properties");
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return properties.getProperty(key);
    }





//    private static ResourceBundle resourceBundle= ResourceBundle.getBundle("config");
//
//    public static String getTestData(String key){
//        return resourceBundle.getString(key);
//    }
}
