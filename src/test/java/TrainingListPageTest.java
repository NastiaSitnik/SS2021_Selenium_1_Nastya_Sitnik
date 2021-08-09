import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.TrainingListBO;

public class TrainingListPageTest extends BaseTest {

    @Test(description = " User should see all Java courses using soft assert. ")
    public void verifyAllChosenCoursesIsJavaCourses() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login("nastyasitnik24@gmail.com", "0675692829Nastya");
        new TrainingListBO()
                .proceedToTrainingListPage()
                .goToCourses("Java")
                .verifyAllCoursesInListIsJavaNeededLanguageSoftAssert("Java");

    }

    @Test(description = " User should see all Java courses using hard assert. ")
    public void verifyAllChosenCoursesIsJavaCoursesHardAssert() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login("nastyasitnik24@gmail.com", "0675692829Nastya");
        new TrainingListBO()
                .proceedToTrainingListPage()
                .goToCourses("Java")
                .verifyAllCoursesInListIsNeededLanguageHardAssert("Java");

    }

    @Test(description = "User should see message that 'No trainings available' on Ruby  ")
    public void verifyNoTrainingsAvailableMessageIsDisplayed() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login("nastyasitnik24@gmail.com", "0675692829Nastya");
        new TrainingListBO()
                .proceedToTrainingListPage()
                .goToCourses("Ruby")
                .verifyNoTrainingMessageIsDisplayed();
    }

}
