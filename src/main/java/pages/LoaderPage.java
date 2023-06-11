package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoaderPage  extends FundamentalUse {
    public LoaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div#projectView.cover")
    public WebElement loader;


    public NavigationMenuPage openProjectView(){
        fluentWaitForElementToBeDisappeared(loader);
        return new NavigationMenuPage(driver);
    }
}
