import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.TrainingListBO;

public class TrainingListPageTest extends BaseTest {

    @Test(description = " User should see all Java courses with Soft Assert. ")
    public void verifyAllChosenCoursesIsJavaCoursesSoftAssert(){
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login("nastyasitnik24@gmail.com","0675692829Nastya");
        new TrainingListBO()
                .proceedToTrainingListPage()
                .goToCourses("Java")
                .verifyAllCoursesInListIsJavaSoftAssert();

    }

    @Test(description = " User should see all Java courses with Hard Assert. ")
    public void verifyAllChosenCoursesIsJavaCoursesHardAssert(){
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login("nastyasitnik24@gmail.com","0675692829Nastya");
        new TrainingListBO()
                .proceedToTrainingListPage()
                .goToCourses("Java")
                .verifyAllCoursesInListIsJavaHardAssert();

    }

    @Test(description = "User should see message that 'No trainings available' on Ruby  ")
    public void verifyNoTrainingsAvailableMessageIsDisplayed(){
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login("nastyasitnik24@gmail.com","0675692829Nastya");
        new TrainingListBO()
                .proceedToTrainingListPage()
                .goToCourses("Ruby")
                .verifyNoTrainingMessageIsDisplayed();
    }


}
