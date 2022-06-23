package fluentlenium.cucumber.stepdefinition;

import fluentlenium.cucumber.driver.WebDriverFactory;
import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseStep extends FluentCucumberTest {

    @Override
    public WebDriver newWebDriver() {
        var webDriverFactory = new WebDriverFactory();
        WebDriver driver = webDriverFactory.defaultWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        return driver;
    }
}
