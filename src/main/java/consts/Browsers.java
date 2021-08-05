package consts;

 public enum Browsers {

    CHROME("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"),
    SAFARI("", ""),
    IMPLICITLY_WAIT_VALUE(10);

    public String name;
    public String location;
    public Integer implicitly_wait_value;

    Browsers(String name, String location) {
        this.name = name;
        this.location = location;
    }
    Browsers(int implicitly_wait_value) {
        this.implicitly_wait_value = implicitly_wait_value;
    }
}
