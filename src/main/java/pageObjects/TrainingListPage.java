package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Logger;

public class TrainingListPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(String.valueOf(SignInPage.class));

    private By searchInput = By.xpath("//input[@class='input-field-search ng-pristine ng-untouched ng-valid']");

    private By searchInputAgain = By.xpath("//input[@class='input-field-search ng-pristine ng-valid ng-touched']");

    private By bySkillsButton = By.xpath("//div[@class='navigation-item ng-binding' and contains(text(), 'By skills')]");

    private By javaCheckbox = By.xpath("//label[normalize-space()='Java']/span");

    private By javaCheckboxUnclick = By.xpath("//label[@class='location__not-active-label ng-binding location__location-active-label']//span[@class='checkmark']");

    private By rubyCheckbox = By.xpath("//div[@class='drop-down-choose__frame-active ng-scope']//label[normalize-space()='Ruby']/span");

    private By allCourses = By.xpath("//div[@class='training-list__container training-list__desktop']//div[@class='training-item__title ng-binding']");

    private By noTrainigMessage = By.xpath("//span[@class ='ng-binding' and contains(text(),'No training are available.')]");

    private By trainingListPageButton = By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem training click hover' and @href = '/#!/TrainingList']");

    public TrainingListPage clickTrainingListPage() {
        getElement(trainingListPageButton).click();
        LOG.info("TrainingListPage clicked.");
        return new TrainingListPage();
    }

    public TrainingListPage clickOnJavaCheckbox (){
        LOG.info("Click on search input on TrainingListPage");
            getElement(searchInput).click();
        LOG.info("Click on by skills button on TrainingListPage");
            getElement(bySkillsButton).click();
        LOG.info("Click on java checkbox on TrainingListPage");
            getElement(javaCheckbox).click();
        LOG.info("Click on search input on TrainingListPage");
        getElement(searchInputAgain).click();

        return new TrainingListPage();
    }

    public TrainingListPage clickOnRubyCheckbox (){
        LOG.info("Click on search input on TrainingListPage");
        getElement(searchInput).click();
//        LOG.info("Unclick java checkbox on TrainingListPage");
//        getElement(javaCheckboxUnclick).click();
        LOG.info("Click on by skills button on TrainingListPage");
        getElement(bySkillsButton).click();
        LOG.info("Click on ruby checkbox on TrainingListPage");
        getElement(rubyCheckbox).click();
        LOG.info("Click on search input on TrainingListPage");
        getElement(searchInputAgain).click();

        return new TrainingListPage();
    }

    public boolean isAllSearchResultJavaCourses(){
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
        }
        return state;
    }

    public boolean isNoTraininMessageIsVisible(){
       boolean isDisplayed = getElement(noTrainigMessage).isDisplayed();
        LOG.info(String.format("Is 'No training message ' error message displayed': '%s'", isDisplayed));
        return isDisplayed;
    }






}
