package pageObjects;

import org.openqa.selenium.By;

import java.util.logging.Logger;

public class SignInPage extends AbstractPage{

    private static final Logger LOG = Logger.getLogger(String.valueOf(SignInPage.class));

    private  By mailInput = By.id("username");

    private By passwordInput = By.id("password");

    private By signInButton = By.id("kc-login");

    protected By continueButton = By.id("kc-login-next");

    private By loginFailedErrorMessage = By.xpath("//span[@class ='error-text' and contains(text(),'credentials')]");



    public SignInPage enterEmail (String email)
    {
        getElement(mailInput).sendKeys(email);
        LOG.info("Mail was entered.");
        return this;
    }
    public SignInPage enterPassword (String password){
        getElement(passwordInput).sendKeys(password);
        LOG.info("Password was entered.");
        return this;
    }

    public HomePage clickSignInButton(){
        getElement(signInButton).click();
        LOG.info("SignIn button clicked.");
        return new HomePage();
    }
    public SignInPage continueButton(){
        getElement(continueButton).click();
        LOG.info("Continue button clicked.");
        return this;
    }


    public boolean isLoginFailedErrorMessageDisplayed(){
        boolean isDisplayed = isDisplayed(loginFailedErrorMessage);
        LOG.info(String.format("Is 'Login Failed' error message displayed': '%s'",isDisplayed));
        return isDisplayed;
    }

    public boolean isLoginIsContainsDogSymbol() {
        return getElement(mailInput).getText().contains("@");
    }

    public boolean isLoginIsContainsDotSymbol(){
        return getElement(mailInput).getText().contains(".");
    }

    public boolean isLoginStartsWithDogSymbol() {
        boolean startsWith= getElement(mailInput).getText().startsWith("@");
        LOG.info(String.format("Is 'Login Failed' login starts with @ ': '%s'",startsWith));
        return startsWith;
    }
    public boolean isLoginStartsWithDotSymbol() {
        boolean startsWith = getElement(mailInput).getText().startsWith(".");
        LOG.info(String.format("Is 'Login Failed' login starts with dot ': '%s'",startsWith));
        return startsWith;
    }
    public boolean isRecipientNameLengthOk () {
        String mail = getElement(mailInput).getText();
        System.out.println("mail = "+ mail);
        int index = mail.indexOf("@");
        System.out.println("Index of  @ = "+index );
        String recName = mail.substring(0,index-1);
        return recName.length() < 64;
    }
    public boolean ContinueButtonIsDisable() {
        boolean isDisable = getElement(continueButton).isDisplayed();
        LOG.info(String.format("Is 'Login Failed' continue button is disable ': '%s'",isDisable));
        return isDisable;
    }
}
