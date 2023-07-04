package tests;

import baseTest.FundamentalUseForTests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import static util.TestDataReader.getTestData;

public class PrintOrSendEmailTest extends FundamentalUseForTests {
    LoginPage loginPage;
    SelectProjectPage selectProjectPage;
    NavigationMenuPage navigationMenuPage;
    MemberOverviewPage memberOverviewPage;
    PrintOrSendEmailPage printOrSentEmailPage;
    LoaderPage loaderPage;
    MemberPreviewPage memberPreviewPage;
    SoftAssert softAssert = new SoftAssert();


    @Test
    public void sendNewTemplate() throws InterruptedException {
        loginPage = new LoginPage(driver);
        selectProjectPage = loginPage.login(getTestData("username"),getTestData("userPassword"));
        loaderPage = selectProjectPage.selectProject(getTestData("project"));
        navigationMenuPage = loaderPage.openProjectView();
        memberOverviewPage = navigationMenuPage.navigateToMemberOverview();
        printOrSentEmailPage =  memberOverviewPage.goToMembersSendEmailPopup();
        printOrSentEmailPage.sendNewOwnTemplate("AutomationTestSubject","Automation test email content");
        memberPreviewPage = memberOverviewPage.goToMemberPreviewPage();
        memberPreviewPage.goToNeededTabOnMemberPage("History");
        String emailSubject = memberPreviewPage.emailSubjectText();
        softAssert.assertEquals(emailSubject,"AutomationTestSubject");
        softAssert.assertAll();
    }
}
