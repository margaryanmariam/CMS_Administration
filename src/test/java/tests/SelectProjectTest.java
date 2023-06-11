package tests;

import baseTest.FundamentalUseForTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SelectProjectPage;

public class SelectProjectTest extends FundamentalUseForTests {
    LoginPage loginPage;
    SelectProjectPage selectProjectPage;

    @Test
    public void selectProject() {
        loginPage = new LoginPage(driver);
        selectProjectPage = loginPage.login("qaAdminSub","test");
       // selectProjectPage = new pages.SelectProjectPage(driver);
        selectProjectPage.selectProject("QA-sub");
    }
}
