import org.testng.annotations.Test;
import pageObjects.businessObjects.BlogBO;
import pageObjects.businessObjects.HomeBO;

public class BlogPageTest  extends BaseTest {

    @Test(description = "Uswe can see and click on all links : NEWS, REAL STORY, MATERIALS, HARD SKILLS, SOFT SKILLS, EVENT ")
    public void verifyAllLinksOnPAgeISVisible(){

        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login("nastyasitnik24@gmail.com","0675692829Nastya");
        new BlogBO()
                .proceedToBlogPage()
                .verifyAllLinksIsDisplayed();

    }

}
