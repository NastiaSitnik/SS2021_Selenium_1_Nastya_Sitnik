package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.BlogPage;
import pageObjects.HomePage;

public class BlogBO {

    private BlogPage blogPage;

    public BlogBO() {
        blogPage = new BlogPage();
    }

    public BlogBO proceedToBlogPage() {
        blogPage.clickToBlogPage();
        return new BlogBO();
    }

    public void verifyAllLinksIsDisplayed() {
        Assert.assertTrue(blogPage.isAllLinksOnPageIsDisplayed(), "Not all link is displayed.");
    }
}
