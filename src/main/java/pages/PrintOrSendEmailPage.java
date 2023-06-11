package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PrintOrSendEmailPage extends FundamentalUse {
    public PrintOrSendEmailPage(WebDriver driver) {
        super(driver);
    }
    Actions actions = new Actions(driver);


    @FindBy(css="div[class='kt-portlet']:nth-child(2)>div>ul>li:nth-child(2)")
    public WebElement sendTab;

    @FindBy(css ="div[class='kt-portlet']:nth-child(2)>div>div>div>select")
    public WebElement selectSendEmailType;

    @FindBy(id="subject_en")
    public WebElement emailSubject_en;


    @FindBy(css ="div[id = 'cke_1_contents']")
    public  WebElement ckContentDiv;
    @FindBy(css ="div[id = 'content_en']")
    public  WebElement emailContent;
    @FindBy(css="div[class='pt-3']>div:nth-child(3)>div>button:nth-child(2)")
    public WebElement sendButton;

    @FindBy(css="div[class='modal-header']>button")
    public WebElement closeButton;


    public void sendNewOwnTemplate(String emailSubject, String emailBody){
        click(sendTab);
        Select selector = new Select(selectSendEmailType);
        selector.selectByIndex(2);
        waitForElementToBeClickable(emailSubject_en);
        emailSubject_en.sendKeys(emailSubject);
        scrollDownToElementAndClick(ckContentDiv);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
        actions.sendKeys(emailBody).build().perform();
        click(sendButton);
        click(closeButton);
    }

}
