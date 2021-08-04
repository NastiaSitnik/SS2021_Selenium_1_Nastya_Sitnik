package pageObjects;

import org.openqa.selenium.By;

import java.util.logging.Logger;

public class SignInPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(String.valueOf(SignInPage.class));

    private By mailInput = By.id("username");

    private By passwordInput = By.id("password");

    private By signInButton = By.id("kc-login");

    protected By continueButton = By.id("kc-login-next");

    private By loginFailedErrorMessage = By.xpath("//span[@class ='error-text' and contains(text(),'credentials')]");


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

    public SignInPage continueButton() { //клік в назві
        getElement(continueButton).click();
        LOG.info("Continue button clicked.");
        return this;
    }




    public boolean isLoginFailedErrorMessageDisplayed() {
        boolean isDisplayed = isDisplayed(loginFailedErrorMessage);
        LOG.info(String.format("Is 'Login Failed' error message displayed': '%s'", isDisplayed));
        return isDisplayed;
    }


    public boolean isContinueButtonIsDisable() {  // name : is..
        boolean isDisable = getElement(continueButton).isDisplayed();
        LOG.info(String.format("Is 'Login Failed' continue button is disable ': '%s'", isDisable));
        return isDisable;
    }

    public boolean isContinueButtonIsEnable() {  // name : is..
        boolean isEnable = getElement(continueButton).isDisplayed();
        LOG.info(String.format("Is 'Login Failed' continue button is disable ': '%s'", isEnable));
        return isEnable;
    }
}
