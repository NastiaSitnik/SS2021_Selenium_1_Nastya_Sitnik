package pageObjects;
import org.openqa.selenium.By;

import static  consts.Constants.BusinessConfigs.HOME_PAGE_URL;

public class HomePage extends AbstractPage{

   // private static final Logger LOG = Logger.getLogger(HomePage.class);

    // "a[@class='header-auth__signin'...]"
    private By signInButton = By.xpath("//a[@class='header-auth__signin']//span");

    private By topRightCornerUserNameElement = By.className("user-info__name");


    public  SignInPage clickSignInButton(){
        getElement(signInButton).click();
        return new SignInPage();
    }

    public HomePage proceedToHomePage(){
        proceedToPage(HOME_PAGE_URL);
        return this;
    }

    public boolean isUserNameDisplayed(){
        boolean isDisplayed = isDisplayed(topRightCornerUserNameElement);
        return  isDisplayed;
    }

    public String getLoggedInUserName(){return getElement(topRightCornerUserNameElement).getText();}




}
