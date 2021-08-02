import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.SignInBO;

public class SignInPageTest extends BaseTest {


    @Test(description = "User should not be able to successfully login with incorrect password ")
    public void verifyIfErrorMessageIsDisplayed() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login("incorrextemail@gmail.com", "incorrectPassword");
new SignInBO()
        .verifyFailedLoginErrorMessageDisplayed();
    }

    @Test(description = " 1 positive scenario test ")
    public void verifyIfLoginIsCorrect(){

        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("nastyasitnik24@gmail.com");

        new SignInBO()
                .varifyEnterCorrectEmailSoft();

    }

    @Test(description = "1 negative scenario test with verifying all the criteria using hard asserts ")
    public void verifyIfLoginIsIncorrectHard()
    {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("@nastyasitk24gmail.com");

        new SignInBO()
                .varifyEnterCorrectEmailHard();
    }
    @Test(description = "1 negative scenario test with verifying all the criteria using soft asserts ")
    public void verifyIfLoginIsIncorrectSoft()
    {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("@nastyasitk24gmail.com");

        new SignInBO()
                .varifyEnterCorrectEmailSoft();
    }

    @Test(description = "positive scenario test which will be verifying only ‘’boundary values” criteria")
    public void verifyIfLoginIsCorrectBoundary()
    {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("nastyasitnik24@gmail.com");

        new SignInBO()
                .varifyEnterCorrectEmailSoft();
    }



}
