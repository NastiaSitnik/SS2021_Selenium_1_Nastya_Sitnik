package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.TrainingListPage;

public class TrainingListBO {

    private TrainingListPage trainingListPage;

    public TrainingListBO() {
        trainingListPage = new TrainingListPage();
    }

    public TrainingListBO goToCourses(String language) {
        trainingListPage.clickOnCheckBox(language);
        return this;
    }

    public TrainingListBO proceedToTrainingListPage() {
        trainingListPage.clickTrainingListPage();
        return new TrainingListBO();
    }

    public TrainingListBO goToCoursesInWhichCity(String country, String city) {
        trainingListPage.clickOnSearch().clickOnCountry(country).clickOnCity(city);
        return new TrainingListBO();
    }

    public void verifyAllCoursesInListIsJavaNeededLanguageSoftAssert(String language) {
        Assert.assertTrue(trainingListPage.isAllSearchResultIsNeededLanguageSoftAssert(language), "Not all courses in list is Java courses.");
    }

    public void verifyAllCoursesInListIsNeededLanguageHardAssert(String language) {
        Assert.assertTrue(trainingListPage.isAllSearchResultIsNeededLanguageHardAssert(language), "Not all courses in list is Java courses.");
    }

    public void verifyNoTrainingMessageIsDisplayed() {
        Assert.assertTrue(trainingListPage.isNoTrainingMessageIsVisible(), "No training message ");
    }

}
