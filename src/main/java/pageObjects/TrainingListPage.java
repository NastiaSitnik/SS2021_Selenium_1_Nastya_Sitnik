package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.logging.Logger;

public class TrainingListPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(String.valueOf(SignInPage.class));

    private final By searchInput = By.xpath("//input[@class='input-field-search ng-pristine ng-untouched ng-valid']");
    private final By searchInputAgain = By.xpath("//input[@class='input-field-search ng-pristine ng-valid ng-touched']");
    private final By bySkillsButton = By.xpath("//div[@class='navigation-item ng-binding' and contains(text(), 'By skills')]");
    private final By javaCheckbox = By.xpath("//label[normalize-space()='Java']/span");
    private final By rubyCheckbox = By.xpath("//div[@class='drop-down-choose__frame-active ng-scope']//label[normalize-space()='Ruby']/span");
    private final By allCourses = By.xpath("//div[@class='training-list__container training-list__desktop']//div[@class='training-item__title ng-binding']");
    private final By noTrainingMessage = By.xpath("//span[@class ='ng-binding' and contains(text(),'No training are available.')]");
    private final By trainingListPageButton = By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem training click hover' and @href = '/#!/TrainingList']");
    private final By UkraineCountryButton = By.xpath("//div[@class='location__not-active-label city-name ng-binding location__location-active-label location__location-active-label-country' and contains(text(),'Ukraine')]");
    private final By LvivCityButton = By.xpath("//div[@class='location__cities']//li[@class='cities ng-scope']//label[contains(text(),'Lviv')]");


    public TrainingListPage clickTrainingListPage() {
        getElement(trainingListPageButton).click();
        LOG.info("TrainingListPage clicked.");
        return new TrainingListPage();
    }

    public TrainingListPage clickOnSearch() {
        LOG.info("Click on search input on TrainingListPage");
        getElement(searchInput).click();
        return this;
    }

    public TrainingListPage clickOnCountry(String country) {
        if (country.equalsIgnoreCase("ukraine ")) {
            getElement(UkraineCountryButton).click();
        }
        return this;
    }

    public TrainingListPage clickOnCity(String city) {
        if (city.equalsIgnoreCase("lviv")) {
            getElement(LvivCityButton).click();
        }
        return new TrainingListPage();
    }

    public TrainingListPage clickOnCheckBox(String whichCheckbox) {

        LOG.info("Click on search input on TrainingListPage");
        getElement(searchInput).click();
        LOG.info("Click on by skills button on TrainingListPage");
        getElement(bySkillsButton).click();
        if (whichCheckbox.equalsIgnoreCase("java")) {
            LOG.info("Click on java checkbox on TrainingListPage");
            getElement(javaCheckbox).click();
        } else if (whichCheckbox.equalsIgnoreCase("ruby")) {
            LOG.info("Click on ruby checkbox on TrainingListPage");
            getElement(rubyCheckbox).click();
        }
        LOG.info("Click on search input on TrainingListPage");
        getElement(searchInputAgain).click();

        return new TrainingListPage();
    }

    public boolean isAllSearchResultIsNeededLanguageSoftAssert(String language) {
        boolean state = false;
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> CoursesList = getElements(allCourses);
        for (WebElement webElement : CoursesList) {
            String temp = webElement.getText().toLowerCase();
            state = temp.contains(language.toLowerCase());
            softAssert.assertTrue(state, "This course is not contains Java" + temp);
        }
        return state;
    }

    public boolean isAllSearchResultIsNeededLanguageHardAssert(String language) {
        boolean state = false;
        List<WebElement> CoursesList = getElements(allCourses);
        for (WebElement webElement : CoursesList) {
            String temp = webElement.getText().toLowerCase();
            state = temp.contains(language.toLowerCase());
            Assert.assertTrue(state, "This course is not contains Java" + temp);
        }
        return state;
    }

    public boolean isNoTrainingMessageIsVisible() {
        boolean isDisplayed = getElement(noTrainingMessage).isDisplayed();
        LOG.info(String.format("Is 'No training message ' error message displayed': '%s'", isDisplayed));
        return isDisplayed;
    }

//    public boolean isAllCoursesCanBeInLviv(){
//        List<WebElement> allCoursesList = getElements(getAllCourses);
//        for(int i =0 ; i< allCoursesList.size(); i++) {
//            String temp = allCoursesList.get(i).getText();
//            if(temp.contains())
//
//        }
//    }

}
