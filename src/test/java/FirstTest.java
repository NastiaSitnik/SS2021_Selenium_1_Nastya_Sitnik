import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    @Test(description = "Verify user is successfully logged in with appropriate credentials.")
    public void verifyUserIsSuccessfullyLoggedIn() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.epam.ua/#!/Home?lang=ua");
        WebElement signInButton = driver.findElement(By.className("header-auth__signin"));
        signInButton.click();
        WebElement mailInput = driver.findElement(By.id("username"));
        mailInput.sendKeys("nastyasitnik24@gmail.com");
        WebElement continueButton = driver.findElement(By.id("kc-login-next"));
        continueButton.click();
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("0675692829Nastya");
        WebElement signInButtonOnPasswordWindow = driver.findElement(By.id("kc-login"));
        signInButtonOnPasswordWindow.click();

        WebElement userName = driver.findElement(By.className("user-info__name"));
        Assert.assertTrue(userName.isDisplayed(), "Username is NOT displayed");

        driver.quit();
    }

    @Test(description = "Verify user is successfully logged in with appropriate credentials.")
    public void verifyUserIsUnSuccessfullyLoggedIn() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.epam.ua/#!/Home?lang=ua");
        WebElement signInButton = driver.findElement(By.className("header-auth__signin"));
        signInButton.click();
        WebElement mailInput = driver.findElement(By.id("username"));
        mailInput.sendKeys("nastyasitnik24@gmail.com");
        WebElement continueButton = driver.findElement(By.id("kc-login-next"));
        continueButton.click();
        WebElement incorrectPasswordInput = driver.findElement(By.id("password"));
        incorrectPasswordInput.sendKeys("0675692829");
        WebElement signInButtonOnPasswordWindow = driver.findElement(By.id("kc-login"));
        signInButtonOnPasswordWindow.click();

//       WebElement mailInputIncorrectPassword = driver.findElement(By.id("username"));
//       Assert.assertTrue(mailInputIncorrectPassword.isEnabled()," Password was not incorrect ");

        WebElement errorMessage = driver.findElement(By.className("error-text"));
        Assert.assertTrue(errorMessage.isEnabled(), " Password was not incorrect ");

        driver.quit();
    }


}
