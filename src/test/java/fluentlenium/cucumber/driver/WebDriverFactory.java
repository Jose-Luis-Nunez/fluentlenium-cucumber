package fluentlenium.cucumber.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.logging.Level;

import static org.openqa.selenium.chrome.ChromeOptions.LOGGING_PREFS;

public class WebDriverFactory {

    public static WebDriver defaultWebDriver() {
        WebDriver driver = chrome();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }

    private static WebDriver chrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions());
    }

    private static WebDriver chromeHeadless() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions().setHeadless(true));
    }

    private static ChromeOptions chromeOptions() {
        return new ChromeOptions()
                .addArguments("--window-size=1920,1080")
                .addArguments("--whitelisted-ips==") // to run in docker
                .addArguments("--start-maximized")
                .addArguments("--incognito")
                .addArguments("--ignore-certificate-errors")
                .addArguments("--disable-dev-shm-usage") //https://stackoverflow.com/a/50642913/3885491
                .addArguments("--no-sandbox")
                .addArguments("--silent")
                .merge(setCapabilities());
    }

    private static Proxy setProxy() {
        String proxyString = "213.136.89.121:80";
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxyString);
        proxy.setSslProxy(proxyString);

        return proxy;
    }

    private static Capabilities setCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        capabilities.setCapability(LOGGING_PREFS, logPrefs);
        capabilities.setCapability("acceptInsecureCerts", true);
        capabilities.setCapability("proxy", setProxy());

        return capabilities;
    }
}
