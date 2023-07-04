package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MemberPreviewPage extends FundamentalUse {
    @FindBy(css = "ul[class='nav nav-tabs']>li")
    public List<WebElement> memberPageTabs;
    @FindBy(css = "div[class='d-flex mb-2']>div")
    public WebElement emailSubjectOnHistoryTab;
    @FindBy(css = "a[class*='nav-link']")
    public WebElement navLink;

    public MemberPreviewPage(WebDriver driver) {
        super(driver);
    }

    public void goToNeededTabOnMemberPage(String tabName) {
        WebElement neededTabElement = memberPageTabs.stream().filter(t -> t.findElement(By.cssSelector("a")).getText().equalsIgnoreCase(tabName)).findFirst().orElse(null);
        waitForVisibilityOfElement(navLink);
        click(neededTabElement);
    }


    public String emailSubjectText() {
        waitForVisibilityOfElement(emailSubjectOnHistoryTab);
        return emailSubjectOnHistoryTab.getText();
    }


}
