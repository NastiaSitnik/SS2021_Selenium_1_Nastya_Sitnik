import consts.Constants;
import driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;


public class BaseTest extends DriverFactory {

    @Parameters({"browserName"})
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(@Optional(value = Constants.DriverConfigs.CHROME_NAME) final String browserName, Method method){
        initDriver(browserName);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        quitDriver();
    }
}
