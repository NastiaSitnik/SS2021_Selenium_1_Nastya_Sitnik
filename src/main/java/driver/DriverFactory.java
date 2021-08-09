package driver;

import consts.Const;
import consts.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver webDriver;

    protected void initDriver(String browserName) {
        if (Const.CHROME_NAME.getValue().equalsIgnoreCase(browserName)) {
            System.setProperty(Const.CHROME_NAME.getValue(), Const.CHROME_DRIVER_LOCATION.getValue());
            webDriver = new ChromeDriver();
        } else if (Const.SAFARI_NAME.getValue().equalsIgnoreCase(browserName)) {
            System.setProperty(Const.SAFARI_NAME.getValue(), Const.SAFARI_DRIVER_LOCATION.getValue());
            webDriver = new SafariDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Integer.parseInt(Const.IMPLICITLY_WAIT_VALUE.getValue()), TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    protected void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
