package tests;

import baseTest.FundamentalUseForTests;
import org.testng.Assert;
import org.testng.annotations.Test;
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


    @Test
    public void sendNewTemplate(){
        loginPage = new LoginPage(driver);
        selectProjectPage = loginPage.login(getTestData("username"),getTestData("password"));
        loaderPage = selectProjectPage.selectProject("Qa-sub");
        navigationMenuPage = loaderPage.openProjectView();
        memberOverviewPage = navigationMenuPage.navigateToMemberOverview();
        printOrSentEmailPage =  memberOverviewPage.goToMembersSendEmailPopup();
        printOrSentEmailPage.sendNewOwnTemplate("AutomationTestSubject","Automation test email content");
        memberPreviewPage = memberOverviewPage.goToMemberPreviewPage();
        memberPreviewPage.goToNeededTabOnMemberPage("History");
        String emailSubject = memberPreviewPage.emailSubjectText();
        Assert.assertEquals(emailSubject,"AutomationTestSubject");

    }
}
