package driver;

import consts.Browsers;
import consts.Constants;
import org.apache.http.impl.cookie.BrowserCompatSpec;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver webDriver;

  //   обробити кейс коли ініт драйвер який не підтрим
    protected void initDriver(String browserName) {
        if (Constants.DriverConfigs.CHROME_NAME.equalsIgnoreCase(browserName)) {
            System.setProperty(Constants.DriverConfigs.CHROME_NAME, Constants.DriverConfigs.CHROME_DRIVER_LOCATION);
            webDriver = new ChromeDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Constants.DriverConfigs.IMPLICITLY_WAIT_VALUE, TimeUnit.SECONDS);
    }

//    protected void initDriver(String browserName) {
//        if (Browsers.CHROME.name.equalsIgnoreCase(browserName)) {
//            System.setProperty(Browsers.CHROME.name, Browsers.CHROME.location);
//            webDriver = new ChromeDriver();
//        }
//        webDriver.manage().window().maximize();
//        webDriver.manage().timeouts().implicitlyWait(Browsers.IMPLICITLY_WAIT_VALUE.implicitly_wait_value, TimeUnit.SECONDS);
//
//    }

    //дод перевірка на інснування драйвера , там де потрібно драйвер використовувати getdriver()
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
