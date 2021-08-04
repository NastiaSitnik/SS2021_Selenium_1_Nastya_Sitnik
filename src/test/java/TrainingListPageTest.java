import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.TrainingListBO;

public class TrainingListPageTest extends BaseTest {

    @Test(description = " User should see all Java courses. ")
    public void verifyAllChosenCoursesIsJavaCourses(){    // do not work
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login("nastyasitnik24@gmail.com","0675692829Nastya");
        new TrainingListBO()
                .proceedToTrainingListPage()
                .goToJavaCourses()
                .verifyAllCoursesInListIsJava();

    }

    @Test(description = "User should see message that 'No trainings available' on Ruby  ")
    public void verifyNoTrainingsAvailableMessageIsDisplayed(){
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login("nastyasitnik24@gmail.com","0675692829Nastya");
        new TrainingListBO()
                .proceedToTrainingListPage()
                .goToRubyCourses()
                .verifyNoTrainingMessageIsDisplayed();
    }


}
