package fluentlenium.cucumber.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

import static org.openqa.selenium.chrome.ChromeOptions.LOGGING_PREFS;

public class WebDriverFactory {

    public WebDriver defaultWebDriver() {
        return chrome();
    }

    private WebDriver chrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions());
    }

    private WebDriver chromeHeadless() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions().setHeadless(true));
    }

    private ChromeOptions chromeOptions() {
        return new ChromeOptions()
                .addArguments("--start-maximized")
                .addArguments("--incognito")
                .addArguments("--ignore-certificate-errors")
                .addArguments("--disable-dev-shm-usage") //https://stackoverflow.com/a/50642913/3885491
                .addArguments("--no-sandbox")
                .addArguments("--silent")
                .merge(setCapabilities());
    }

    private Capabilities setCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        capabilities.setCapability(LOGGING_PREFS, logPrefs);
        capabilities.setCapability("acceptInsecureCerts", true);

        return capabilities;
    }
}
