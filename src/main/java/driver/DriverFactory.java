package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {
    private static WebDriver driver;
//    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//    private static ChromeOptions option = new ChromeOptions();

    private DriverFactory() {
    }

    public static WebDriver getDriver(String driverType, String url) {
        if (driver == null) {
            switch (driverType) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    System.out.println("------------123456543213456---");
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
//                    System.setProperty("webdriver.chrome.driver", "/home/beeweb/Desktop/Projects/JavaProjects/CMS_Administration/resources/chromedriver");
                    break;
                default:
                    throw new IllegalArgumentException("Invalid driver type: " + driverType);
            }
            driver.manage().window().maximize();
            driver.get(url);
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
//        private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//        private static ChromeOptions option = new ChromeOptions();
//        private DriverFactory() {
//        }
//
//        public static WebDriver getDriver() {
//            if (driver.get() == null) {
//                switch (System.getProperty("browser", "chrome")) {
//                    case "firefox": {
//                        //Initializing the firefox driver (Gecko)
//                        System.setProperty("webdriver.gecko.driver", "/home/beeweb/Desktop/JavaProjects/CMS_Administration/resources/geckodriver");
//                        driver.set(new FirefoxDriver());
//                        driver.get();
//                    }
//                    default: {
//                        //Initialize the chrome driver
//                        option.addArguments("--remote-allow-origins=*");
//                        WebDriverManager.chromedriver().setup();
//                        driver.set(new ChromeDriver(option));
//                        driver.get();
//                    }
//                }
//
//                driver.get().manage().window().maximize();
//            }
//            return driver.get();
//        }
//
//        public static void closeDriver() {
//            driver.get().close();
//            driver.set(null);
//        }

