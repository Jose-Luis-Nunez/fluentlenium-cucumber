package fluentlenium.cucumber.driver;

public enum Driver {
    CHROME("chrome"),
    DEFAULT("chrome-headless");

    public String value;

    Driver(String driver) {
        this.value = driver;
    }
}
