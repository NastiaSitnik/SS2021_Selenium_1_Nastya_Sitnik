package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.TrainingListPage;

public class TrainingListBO {

    private TrainingListPage trainingListPage;

    public TrainingListBO() {
        trainingListPage = new TrainingListPage();
    }

    public TrainingListBO goToCourses(String withCourses){
        trainingListPage.clickOnCheckBox(withCourses);
        return this;
    }

    public TrainingListBO proceedToTrainingListPage(){
        trainingListPage.clickTrainingListPage();
        return new TrainingListBO();
    }

    public void verifyAllCoursesInListIsJavaSoftAssert() {
        Assert.assertTrue(trainingListPage.isAllSearchResultJavaCoursesSoftAssert(), "Not all courses in list is Java courses.");
    }

    public void verifyAllCoursesInListIsJavaHardAssert() {
        Assert.assertTrue(trainingListPage.isAllSearchResultJavaCoursesHardAssert(), "Not all courses in list is Java courses.");
    }

    public void verifyNoTrainingMessageIsDisplayed()
    {
        Assert.assertTrue(trainingListPage.isNoTraininMessageIsVisible(),"No training message ");
    }

}
