package pageObjects;

import org.openqa.selenium.By;

import java.util.logging.Logger;

public class BlogPage extends AbstractPage {


    private static final Logger LOG = Logger.getLogger(String.valueOf(BlogPage.class));

    private final By blogPageButton = By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem news click hover' and contains(text(),'Blog')]");
    private final By newsLink = By.xpath("//span[@class='ng-binding' and contains(text(),'NEWS')]");
    private final By realStoryLink = By.xpath("//span[@class='ng-binding' and contains(text(),'REAL')]");
    private final By materialsLink = By.xpath("//span[@class='ng-binding' and contains(text(),'MATERIALS')]");
    private final By hardSkillsLink = By.xpath("//span[@class='ng-binding' and contains(text(),'HARD')]");
    private final By softSkillsLink = By.xpath("//span[@class='ng-binding' and contains(text(),'SOFT')]");
    private final By eventsLink = By.xpath("//span[@class='ng-binding' and contains(text(),'EVENTS')]");


    public BlogPage clickToBlogPage() {
        getElement(blogPageButton).click();
        LOG.info("Click on BlogPage button");
        return new BlogPage();
    }

    public boolean isAllLinksOnPageIsDisplayed() {
        boolean isDisplayed = isDisplayed(newsLink)
                & isDisplayed(realStoryLink)
                & isDisplayed(materialsLink)
                & isDisplayed(blogPageButton)
                & isDisplayed(softSkillsLink)
                & isDisplayed(eventsLink);
        LOG.info(String.format("Links : NEWS, REAL STORY, MATERIALS, HARD SKILLS, SOFT SKILLS, EVENT is displayed : '%s'", isDisplayed));
        return isDisplayed;
    }
}
