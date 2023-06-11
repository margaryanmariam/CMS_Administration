package tests;

import baseTest.FundamentalUseForTests;
import config.TestSetup;
import driver.DriverFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends FundamentalUseForTests {
    LoginPage loginPage;
    SoftAssert softAssert = new SoftAssert();

    @Test(dataProvider ="getData")
    public  void loginValidation(HashMap<String, String> userdata){
         loginPage = new LoginPage(TestSetup.setupDriver());
         boolean loginResult = loginPage.performLogin(userdata.get("username"), userdata.get("password"));
         //Assert.assertTrue(loginResult);
         softAssert.assertTrue(loginResult);
         softAssert.assertAll();
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//resources//userData.json");
        return new Object[][]{{data.get(0)}, {data.get(1)}};
    }

}
