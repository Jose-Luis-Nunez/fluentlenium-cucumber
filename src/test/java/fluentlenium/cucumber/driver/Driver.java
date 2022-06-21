package fluentlenium.cucumber.driver;

enum Driver {
    CHROME("chrome"),
    CHROME_HEADLESS("chrome-headless");

    private String browser;

    Driver(String browserName) {
        this.browser = browserName;
    }
}
