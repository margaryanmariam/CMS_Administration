package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LoginPage extends FundamentalUse {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(css = "[class='kt-checkbox']>span")
    public WebElement checkbox;

    @FindBy(id = "kt_login_submit")
    public WebElement submit;

    @FindBy(css = "[role='alert']>div:nth-child(2)")
    public WebElement errorMessage;


    public SelectProjectPage login(String userName, String passWord) {
        sendKeys(username, userName);
        sendKeys(password, passWord);
        click(checkbox);
        click(submit);
        return new SelectProjectPage(driver);
    }

    public String getErrorMessage() {
        waitForVisibilityOfElement(errorMessage);
        return errorMessage.getText();
    }

    public boolean performLogin(String userName, String passWord) {
        login(userName, passWord);
        try {
            waitForVisibilityOfElement(errorMessage);
            if (errorMessage.isDisplayed()) {
                return false;
            } else {
                return true;
            }
        } catch (TimeoutException e) {
            return true;
        }
    }
}

