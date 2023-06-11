package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;



public class NavigationMenuPage extends FundamentalUse {
    public NavigationMenuPage(WebDriver driver) {
        super(driver);
    }
    Actions action = new Actions(driver);

    @FindBy(css = "[class='kt-menu__nav ']>li:nth-child(1)")
    public WebElement Manage;

    @FindBy(css ="[class='kt-menu__nav ']>li:nth-child(1)>div>ul>li:nth-child(2)")
    public WebElement Members;
    @FindBy(css = "[class='kt-menu__nav ']>li:nth-child(1)>div>ul>li:nth-child(2)>div>ul>li:nth-child(1)")
    public WebElement navigateToMemberOverview;



    @FindBy(css = "[class='kt-menu__nav']>li:nth-child(2)")
    public WebElement Entertainment;

    @FindBy(css = "[class='kt-menu__nav']>li:nth-child(3)")
    public WebElement Proleos;

    @FindBy(css = "[class='kt-menu__nav']>li:nth-child(4)")
    public WebElement Care;

    @FindBy(css = "[class='kt-menu__nav']>li:nth-child(5)")
    public WebElement Marketing;

    @FindBy(css = "[class='kt-menu__nav']>li:nth-child(6)")
    public WebElement Shop;

    @FindBy(css = "[class='kt-menu__nav']>li:nth-child(8)")
    public WebElement Cabines;


    public MemberOverviewPage navigateToMemberOverview(){
        click(Manage);
        action.moveToElement(Members).build().perform();
        action.moveToElement(navigateToMemberOverview).build().perform();
        click(navigateToMemberOverview);
        return new MemberOverviewPage(driver);
    }




}
