package tests;

import baseTest.FundamentalUseForTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static util.TestDataReader.getTestData;


public class LoginTest extends FundamentalUseForTests {
    LoginPage loginPage;
    SoftAssert softAssert = new SoftAssert();

    @Test
    public  void loginWithValidData(){
         loginPage = new LoginPage(driver);
         boolean loginResult = loginPage.performLogin(getTestData("username"),getTestData("userPassword"));
         softAssert.assertTrue(loginResult);
         softAssert.assertAll();
    }

    @Test
    public  void loginWithInValidData(){
        loginPage = new LoginPage(driver);
        boolean loginResult = loginPage.performLogin(getTestData("invalidUsername"),getTestData("invalidPassword"));
        softAssert.assertFalse(loginResult);
        softAssert.assertAll();
    }

    public Object[][] getData() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//resources//userData.json");
        return new Object[][]{{data.get(0)}, {data.get(1)}};
    }

}
