package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import java.util.logging.Logger;

public class FundamentalUse  {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;
    protected final int TIMEOUT = 50;



    public FundamentalUse(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        PageFactory.initElements(driver, this);
        logger = Logger.getLogger(FundamentalUse.class.getName());
    }


    protected void click(WebElement webElement) {
        waitForElementToBeClickable(webElement);
        logger.info("Clicking to " + webElement.getText());
        webElement.click();
    }

    protected void sendKeys(WebElement webElement, String text) {
        waitForVisibilityOfElement(webElement);
        logger.info("Filling " + webElement.getText() + "field with text " + text);
        webElement.sendKeys(text);
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitInvisibilityOfElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (WebDriverException e) {
            System.out.println("Locator of element still visible");
        }
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> pageLoadCondition =
                driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        wait.until(pageLoadCondition);
    }

    public void scrollDownToElementAndClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        //js.executeScript("arguments[0].click();", element);
    }

    public void fluentWaitForElementToBeDisappeared(WebElement element){
        // Create a fluent wait with a maximum timeout of 60 seconds
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.invisibilityOf(element));
    }
}

