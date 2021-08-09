package consts;

public interface Constants {

    interface DriverConfigs{
        String CHROME_NAME = "webdriver.chrome.driver";
        String CHROME_DRIVER_LOCATION = "/Users/nastasitnik/IdeaProjects/SS2021_Selenium_1_Nastya_Sitnik/src/main/resources/chromedriver";
        String SAFARI_NAME= "webdriver.safari.driver";
        String SAFARI_DRIVER_LOCATION = "/Library/Apple/System/Library/CoreServices/SafariSupport.bundle/Contents/MacOS/safaridriver";
        int IMPLICITLY_WAIT_VALUE = 10;

    }

    interface BusinessConfigs {
        String BASE_URL = "https://training.by";
        String HOME_PAGE_URL = BASE_URL + "/#/Home";
    }
}
