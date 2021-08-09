package consts;

public enum Const {

    CHROME_NAME("webdriver.chrome.driver"),
    CHROME_DRIVER_LOCATION("/Users/nastasitnik/IdeaProjects/SS2021_Selenium_1_Nastya_Sitnik/src/main/resources/chromedriver"),
    SAFARI_NAME("webdriver.safari.driver"),
    SAFARI_DRIVER_LOCATION("/Library/Apple/System/Library/CoreServices/SafariSupport.bundle/Contents/MacOS/safaridriver"),
    IMPLICITLY_WAIT_VALUE("10"),
    HOME_PAGE_URL("https://training.epam.com/#!/Home");

    private final String value;

    Const(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
