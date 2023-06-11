package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MemberPreviewPage extends FundamentalUse {
    public MemberPreviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css ="ul[class='nav nav-tabs']>li")
    public List<WebElement> memberPageTabs;

    @FindBy(css ="div[class='d-flex mb-2']>div")
    public WebElement emailSubjectOnHistoryTab;


    public void goToNeededTabOnMemberPage(String tabName){
        WebElement neededTabElement = memberPageTabs.stream().filter(t->t.findElement(By.cssSelector("a")).getText().equalsIgnoreCase(tabName)).findFirst().orElse(null);
        click(neededTabElement);
    }


    public String emailSubjectText(){
       return emailSubjectOnHistoryTab.getText();
    }


}
