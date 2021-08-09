import dataProvider.Register;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.SignInBO;

public class SignInPageTest extends BaseTest {


    @Test(description = "User should not be able to successfully login with incorrect password ",
            dataProvider = "Registration", dataProviderClass = Register.class)
    public void verifyIfErrorMessageIsDisplayed(String mail, String password) {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login(mail, password);
        new SignInBO()
                .verifyFailedLoginErrorMessageDisplayed();
    }

    @Test(description = "User should not be able to successfully login with incorrect password, check with Soft Asserts",
            dataProvider = "Registration", dataProviderClass = Register.class)
    public void verifyIfErrorMessageIsDisplayedSoftAssert(String mail, String password) {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login(mail, password);
        new SignInBO()
                .verifyFailedLoginErrorMessageDisplayedSoftAssert();
    }

    @Test(description = " User should be able to successfully login with correct email and password")
    public void verifyIfUserSuccessfullyLogin() {

        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login("nastyasitnik24@gmail.com", "0675692829Nastya"); //correct, create new account

        new HomeBO()
                .verifyUsernameIsVisibleRightTopCorner();
    }


    @Test(description = "User should not be able to successfully login with email that do not fits the criteria " +
            " using hard asserts", dataProvider = "Incorrect email", dataProviderClass = Register.class)
    public void verifyIfLoginStartWithDogHardAssert(String mail) {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(mail);

        new SignInBO()
                .verifyContinueButtonIsDisable();

    }

    @Test(description = "User should be able to login with correct email", dataProvider = "Boundary values",
            dataProviderClass = Register.class)
    public void verifyIfLoginIsCorrectBoundary(String email) {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(email);

        new SignInBO()
                .verifyContinueButtonIsEnable();
    }

}
