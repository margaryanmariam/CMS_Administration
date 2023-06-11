package util;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
