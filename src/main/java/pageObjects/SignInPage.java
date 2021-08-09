package pageObjects;

import org.openqa.selenium.By;

import java.util.logging.Logger;

public class SignInPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(String.valueOf(SignInPage.class));

    private final By mailInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By signInButton = By.id("kc-login");
    private final By continueButton = By.id("kc-login-next");
    private final By loginFailedErrorMessage = By.xpath("//span[@class ='error-text' and contains(text(),'credentials')]");


    public SignInPage enterEmail(String email) {
        getElement(mailInput).sendKeys(email);
        LOG.info("Mail was entered.");  // логувати значення мейлу
        return this;
    }

    public SignInPage enterPassword(String password) {
        getElement(passwordInput).sendKeys(password);
        LOG.info("Password was entered.");
        return this;
    }

    public HomePage clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("SignIn button clicked.");
        return new HomePage();
    }

    public SignInPage clickContinueButton() {
        getElement(continueButton).click();
        LOG.info("Continue button clicked.");
        return this;
    }

    public boolean isLoginFailedErrorMessageDisplayed() {
        boolean isDisplayed = isDisplayed(loginFailedErrorMessage);
        LOG.info(String.format("Is 'Login Failed' error message displayed': '%s'", isDisplayed));
        return isDisplayed;
    }

    public boolean isContinueButtonIsDisable() {
        boolean isDisable = getElement(continueButton).isDisplayed();
        LOG.info(String.format("Is 'Login Failed' continue button is disable ': '%s'", isDisable));
        return isDisable;
    }

    public boolean isContinueButtonIsEnable() {
        boolean isEnable = getElement(continueButton).isDisplayed();
        LOG.info(String.format("Is 'Login Failed' continue button is enable ': '%s'", isEnable));
        return isEnable;
    }
}
