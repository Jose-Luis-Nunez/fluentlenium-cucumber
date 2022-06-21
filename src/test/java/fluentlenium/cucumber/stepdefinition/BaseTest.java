package fluentlenium.cucumber.stepdefinition;

import fluentlenium.cucumber.driver.Browser;
import fluentlenium.cucumber.driver.WebDriverFactory;
import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTest extends FluentCucumberTest {

    private String requestedDriver() {
        return getClass().getAnnotation(Browser.class).use.value;
    }

    @Override
    public WebDriver newWebDriver() {
        var webDriverFactory = new WebDriverFactory();
        WebDriver driver = webDriverFactory.defaultWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        return driver;
    }
}
