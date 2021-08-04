package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.SignInPage;
import pageObjects.TrainingListPage;

import java.util.logging.Logger;

public class TrainingListBO {

    private TrainingListPage trainingListPage;

    public TrainingListBO() {
        trainingListPage = new TrainingListPage();
    }

    public TrainingListBO goToJavaCourses(){
        trainingListPage.clickOnJavaCheckbox();
        return this;
    }
    public TrainingListBO goToRubyCourses(){
        trainingListPage.clickOnRubyCheckbox();
        return this;
    }

    public TrainingListBO proceedToTrainingListPage(){
        trainingListPage.clickTrainingListPage();
        return new TrainingListBO();
    }

    public void verifyAllCoursesInListIsJava() {
        Assert.assertTrue(trainingListPage.isAllSearchResultJavaCourses(), "Not all courses in list is Java courses.");
    }

    public void verifyNoTrainingMessageIsDisplayed()
    {
        Assert.assertTrue(trainingListPage.isNoTraininMessageIsVisible(),"No training message ");
    }


}
