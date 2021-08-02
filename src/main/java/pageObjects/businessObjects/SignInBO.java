package pageObjects.businessObjects;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.SignInPage;

public class SignInBO {

    private SignInPage signInPage;

    public SignInBO(){ signInPage = new SignInPage();}

    public HomeBO login (String mail, String password)
    {
        signInPage.enterEmail(mail)
                .continueButton()
                .enterPassword(password)
                .clickSignInButton();
        return new HomeBO();
    }

    public void enterEmail(String mail)
    {
        signInPage.enterEmail(mail);
//                .continueButton();
        new HomeBO();
    }

    public void verifyFailedLoginErrorMessageDisplayed(){
        Assert.assertTrue(signInPage.isLoginFailedErrorMessageDisplayed(),"Login failed error" +
                "message is not displayed ");
    }

    public void verifyContinueButtonIsDisable() {
        Assert.assertTrue(signInPage.ContinueButtonIsDisable(), "Continue button is enabled");
    }
    public void varifyEnterCorrectEmailHard(){

        Assert.assertTrue(signInPage.ContinueButtonIsDisable(), "Continue button is enabled");

    }
    public void varifyEnterCorrectEmailSoft(){

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(signInPage.ContinueButtonIsDisable(), "Continue button is enabled");
        softAssert.assertAll();
    }

}
