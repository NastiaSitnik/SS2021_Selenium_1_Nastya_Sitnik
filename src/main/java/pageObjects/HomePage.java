package pageObjects;

import consts.Const;
import org.openqa.selenium.By;

import java.util.logging.Logger;


public class HomePage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(String.valueOf(HomePage.class));

    private final By signInButton = By.xpath("//a[@class='header-auth__signin']//span");
    private final By topRightCornerUserNameElement = By.className("user-info__name");


    public SignInPage clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("'Sign in' button clicked");
        return new SignInPage();
    }

    public HomePage proceedToHomePage() {
        proceedToPage(Const.HOME_PAGE_URL.getValue());
        LOG.info(String.format("Proceeded to '%s' URL.", Const.HOME_PAGE_URL.getValue()));
        return this;
    }

    public boolean isUserNameDisplayed() {
        boolean isDisplayed = isDisplayed(topRightCornerUserNameElement);
        LOG.info("User Name is displayed on the top-right conner");
        return isDisplayed;
    }

    public String getLoggedInUserName() {
        return getElement(topRightCornerUserNameElement).getText();
    }

}
