import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.SignInBO;

public class SignInPageTest extends BaseTest {

    // negative
    @Test(description = "User should not be able to successfully login with incorrect password ")
    public void verifyIfErrorMessageIsDisplayed() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login("incorrextemail@gmail.com", "incorrectPassword");
        new SignInBO()
                .verifyFailedLoginErrorMessageDisplayed();
    }

    // positive
    @Test(description = " User should be able to successfully login with correct email and password")
    public void verifyIfUserSuccessfullyLogin() {

        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login("nastyasitnik24@gmail.com", "0675692829Nastya"); //correct, create new account

        new HomeBO()
                .verifyUsernameIsVisibleRightTopCorner();
    }

    // negative
    @Test(description = "User should not be able to successfully login if his email starts with @ symbol" +
            " using hard asserts")
    public void verifyIfLoginStartWithDogHardAssert() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("@nastyasitk24gmail.com");

        new SignInBO()
                .varifyEmailIsNotCorrectAndContinueButtonIsDisableHardAssert();

    }
    // negative
    @Test(description = "User should not be able to successfully login if his email dont contain @ symbol " +
            "using hard asserts ")
    public void verifyIfLoginIsIncorrectHardDontContainsDog() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("nastyasitk24gmail.com");

        new SignInBO()
                .varifyEmailIsNotCorrectAndContinueButtonIsDisableHardAssert();
    }

    // negative
    @Test(description = "User should not be able to successfully login if his email dont contain '.' symbol " +
            "using hard asserts")
    public void verifyIfLoginIsIncorrectHardDontContainsDot() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("nastyasitk24@gmailcom");

        new SignInBO()
                .varifyEmailIsNotCorrectAndContinueButtonIsDisableHardAssert();
    }

    // negative
    @Test(description = "User should not be able to successfully login if his email starts with @ symbol" +
            " using soft asserts")
    public void verifyIfLoginIsIncorrectSoftStartsWithDog() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("@nastyasitk24gmail.com");

        new SignInBO()
                .varifyEmailIsNotCorrectAndContinueButtonIsDisableEmailSoft();
    }

    // negative
    @Test(description = "User should not be able to successfully login if his email dont contain @ symbol " +
            "using hard asserts ")
    public void verifyIfLoginIsIncorrectSoftDontContainDog() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("nastyasitk24gmail.com");

        new SignInBO()
                .varifyEmailIsNotCorrectAndContinueButtonIsDisableEmailSoft();
    }

    // negative
    @Test(description = "User should not be able to successfully login if his email dont contain '.' symbol " +
            "using hard asserts ")
    public void verifyIfLoginIsIncorrectSoftDontContainDot() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("nastyasitk24@gmailcom");

        new SignInBO()
                .varifyEmailIsNotCorrectAndContinueButtonIsDisableEmailSoft();
    }

    // boundary values 63-correct // positive
    @Test(description = "User should be able to login with correct email")
    public void verifyIfLoginIsCorrectBoundary() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("nastyasitnik24242424242424242424242424242424242424242424242424@gmail.com");

        new SignInBO()
                .verifyContinueButtonIsEnable();
    }



}
