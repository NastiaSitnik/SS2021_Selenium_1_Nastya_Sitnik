import driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.util.logging.Logger;


public class BaseTest extends DriverFactory {

    private static final String browser = "webdriver.safari.driver";
    private static final Logger LOG = Logger.getLogger(String.valueOf(BaseTest.class));

    @Parameters({"browserName"})
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(@Optional(value = browser) final String browserName, Method method) {
        initDriver(browserName);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(Method method) {
        LOG.info(String.format("Test '%s' completed.", method.getName()));
        quitDriver();
    }
}
