package config;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;


import java.io.InputStream;
import java.util.Properties;

import static util.TestDataReader.getTestData;

public class TestSetup {
    private static String url;
    private static String environment;
    private static String browserType;

    public static void setEnvironment(String environment) {
        TestSetup.environment = environment;
    }

    public static void setBrowser(String browserType) {
        TestSetup.browserType = browserType;
    }

    public static String getEnvironmentFromMaven() {
        String env = System.getProperty("environment");
        if (env != null && !env.isEmpty()) {
            setEnvironment(env);
            return env;
        } else {
            env = "default";
            setEnvironment(env);
        }
        return env;
    }

    private static String getDriverTypeFromMaven() {
        String browserType = System.getProperty("browserType");
        if (browserType != null && !browserType.isEmpty()) {
            setBrowser(browserType);
            return browserType;
        } else {
            browserType = "default";
            setBrowser(browserType);
        }
        return browserType;
    }

    private static void setUrlBasedOnEnvironment() {
        // Set url from TestDataReader class
        url = getTestData("url");
    }

    private static void setBrowserType() {
        // Load the properties file
        Properties properties = new Properties();
        try (InputStream inputStream = TestSetup.class.getResourceAsStream("/config.properties")) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Get the BrowserType
        browserType = properties.getProperty("driver." + browserType);
    }


    public static WebDriver setupDriver() {
        environment = getEnvironmentFromMaven();
        browserType = getDriverTypeFromMaven();
        setUrlBasedOnEnvironment();
        setBrowserType();


        // Get the driver using DriverFactory and pass the driver type
        WebDriver driver = DriverFactory.getDriver(browserType, url);


        // Set the driver's URL
        return driver;
    }
}