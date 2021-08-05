package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.logging.Logger;

public class TrainingListPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(String.valueOf(TrainingListPage.class));

    private final By searchInput = By.xpath("//input[@class='input-field-search ng-pristine ng-untouched ng-valid']");

    private final By searchInputAgain = By.xpath("//input[@class='input-field-search ng-pristine ng-valid ng-touched']");

    private final By bySkillsButton = By.xpath("//div[@class='navigation-item ng-binding' and contains(text(), 'By skills')]");

    private final By javaCheckbox = By.xpath("//label[normalize-space()='Java']/span");

    private final By rubyCheckbox = By.xpath("//div[@class='drop-down-choose__frame-active ng-scope']//label[normalize-space()='Ruby']/span");

    private final By allCourses = By.xpath("//div[@class='training-list__container training-list__desktop']//div[@class='training-item__title ng-binding']");

    private final By noTrainingMessage = By.xpath("//span[@class ='ng-binding' and contains(text(),'No training are available.')]");

    private final By trainingListPageButton = By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem training click hover' and @href = '/#!/TrainingList']");

    public TrainingListPage clickTrainingListPage() {
        getElement(trainingListPageButton).click();
        LOG.info("TrainingListPage clicked.");
        return new TrainingListPage();
    }

    public TrainingListPage clickOnCheckBox (String witchCheckbox){
        LOG.info("Click on search input on TrainingListPage");
        getElement(searchInput).click();
        LOG.info("Click on by skills button on TrainingListPage");
        getElement(bySkillsButton).click();
        if(witchCheckbox == "Java"){
            LOG.info("Click on java checkbox on TrainingListPage");
            getElement(javaCheckbox).click();
        } else if(witchCheckbox == "Ruby"){
            LOG.info("Click on ruby checkbox on TrainingListPage");
            getElement(rubyCheckbox).click();
        }
        LOG.info("Click on search input on TrainingListPage");
        getElement(searchInputAgain).click();

        return  new TrainingListPage();
    }

    public boolean isAllSearchResultJavaCoursesSoftAssert(){
        boolean state = false;
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> javaCoursesList = getElements(allCourses);
        for(int i =0 ; i< javaCoursesList.size(); i++)
        {
            String temp = javaCoursesList.get(i).getText();
            if(temp.contains("JAVA"))
            {
                state = true;

            }
            else {state = false;}
            softAssert.assertTrue(state,"This course is not contains Java" + temp);
        }
        return state;
    }

    public boolean isAllSearchResultJavaCoursesHardAssert(){
        boolean state = false;
        List<WebElement> javaCoursesList = getElements(allCourses);
        for(int i =0 ; i< javaCoursesList.size(); i++)
        {
            String temp = javaCoursesList.get(i).getText();
            if(temp.contains("JAVA"))
            {
                state = true;

            }
            else {state = false;}
            Assert.assertTrue(state,"This course is not contains Java" + temp);
        }
        return state;
    }

    public boolean isNoTraininMessageIsVisible(){
       boolean isDisplayed = getElement(noTrainingMessage).isDisplayed();
        LOG.info(String.format("Is 'No training message ' error message displayed': '%s'", isDisplayed));
        return isDisplayed;
    }






}
