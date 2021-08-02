package pageObjects.businessObjects;


import org.apache.http.util.Asserts;
import pageObjects.HomePage;

public class HomeBO {
    private HomePage homePage;

    public HomeBO(){homePage = new HomePage();}

    public HomeBO proceedToHomePage()
    {
        homePage.proceedToHomePage();
        return this;
    }

    public SignInBO clickSignInButton(){
        homePage.clickSignInButton();
        return new SignInBO();
    }


}
