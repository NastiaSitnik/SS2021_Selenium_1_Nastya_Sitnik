package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.TrainingListPage;

public class HomeBO {
    private HomePage homePage;

    public HomeBO() {
        homePage = new HomePage();
    }

    public HomeBO proceedToHomePage() {
        homePage.proceedToHomePage();
        return this;
    }

    public SignInBO clickSignInButton() {
        homePage.clickSignInButton();
        return new SignInBO();
    }



    public void verifyUsernameIsVisibleRightTopCorner() {
        Assert.assertTrue(homePage.isUserNameDisplayed(), "Username is not displayed ");
    }


}
