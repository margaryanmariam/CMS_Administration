package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MemberOverviewPage extends FundamentalUse {
    public MemberOverviewPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css ="button[title='Email']")
    public WebElement emailButton;

    @FindBy(css ="a[title='Preview']")
    public WebElement previewButton;

    @FindBy(css ="i[class*='fa fa-spinner fa-spin pr-0']")
    public WebElement spinnerINOverviewTabs;


    public PrintOrSendEmailPage goToMembersSendEmailPopup(){
        waitInvisibilityOfElement(spinnerINOverviewTabs);
        click(emailButton);
        return new PrintOrSendEmailPage(driver);
    }

    public MemberPreviewPage goToMemberPreviewPage(){
        waitInvisibilityOfElement(spinnerINOverviewTabs);
        click(previewButton);
        return new MemberPreviewPage(driver);
    }


}
