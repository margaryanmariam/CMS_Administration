package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class SelectProjectPage   extends FundamentalUse {
    public SelectProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[class*='cursor-pointer']")
    public List<WebElement> projectsList;

    @FindBy(css = "[role='button']>i")
    public WebElement openSubProjects;

    @FindBy(css = "[class='kt-portlet']")
    public WebElement projectSelector;

    public LoaderPage selectProject(String projectName) {

        waitForVisibilityOfElement(projectSelector);


        if (openSubProjects.isDisplayed()){
            click(openSubProjects);
        }
        WebElement neededProject = projectsList.stream().filter(project -> project.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(projectName)).findFirst().orElse(null);
        click(neededProject);
        return new LoaderPage(driver);
    }
}
