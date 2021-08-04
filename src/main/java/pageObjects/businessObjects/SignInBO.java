package pageObjects.businessObjects;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.SignInPage;

public class SignInBO {

    private SignInPage signInPage;

    public SignInBO() {
        signInPage = new SignInPage();
    }

    public HomeBO login(String mail, String password) {
        signInPage.enterEmail(mail)
                .continueButton()
                .enterPassword(password)
                .clickSignInButton();
        return new HomeBO();
    }

    public SignInBO enterEmail(String mail) {
        signInPage.enterEmail(mail);
//                .continueButton();
        return this;
    }

    public void verifyFailedLoginErrorMessageDisplayed() {
        Assert.assertTrue(signInPage.isLoginFailedErrorMessageDisplayed(), "Login failed error" +
                "message is not displayed ");
    }

    public void verifyContinueButtonIsEnable() {
        Assert.assertTrue(signInPage.isContinueButtonIsEnable(), "Continue button is disable");
    }


    // винести асертер як змінну класу
    public void varifyEmailIsNotCorrectAndContinueButtonIsDisableHardAssert() {

        Assert.assertTrue(signInPage.isContinueButtonIsDisable(), "Continue button is enabled");

    }

    public void varifyEmailIsNotCorrectAndContinueButtonIsDisableEmailSoft() {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(signInPage.isContinueButtonIsDisable(), "Continue button is enabled");
        softAssert.assertAll();
    }

}
