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
                .clickContinueButton()
                .enterPassword(password)
                .clickSignInButton();
        return new HomeBO();
    }

    public SignInBO enterEmail(String mail) {
        signInPage.enterEmail(mail);
        return this;
    }

    public void verifyFailedLoginErrorMessageDisplayed() {
        Assert.assertTrue(signInPage.isLoginFailedErrorMessageDisplayed(), "Login failed error" +
                "message is not displayed ");
    }

    public void verifyFailedLoginErrorMessageDisplayedSoftAssert() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(signInPage.isLoginFailedErrorMessageDisplayed(), "Login failed error" +
                "message is not displayed ");
        softAssert.assertAll();
    }

    public void verifyContinueButtonIsEnable() {
        Assert.assertTrue(signInPage.isContinueButtonIsEnable(), "Continue button is disable");
    }

    public void verifyContinueButtonIsDisable() {
        Assert.assertTrue(signInPage.isContinueButtonIsDisable(), "Continue button is enabled");
    }

//    public void verifyContinueButtonIsDisableEmailSoft() {
//
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertTrue(signInPage.isContinueButtonIsDisable(), "Continue button is enabled");
//        softAssert.assertAll();
//    }

}
