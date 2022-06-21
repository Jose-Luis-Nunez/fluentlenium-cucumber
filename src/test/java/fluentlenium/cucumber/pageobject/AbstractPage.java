package fluentlenium.cucumber.pageobject;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;

import java.util.concurrent.TimeUnit;

public class AbstractPage extends FluentPage {
    public static final long TIME_OUT_IN_SECONDS = 10L;

    public void clickOnElement(FluentWebElement webElement) {
        waitUntilElementPresent(webElement);
        webElement.click();
    }

    public void typeTextInElement(FluentWebElement webElement, String text) {
        waitUntilElementPresent(webElement);
        webElement.clear();
        webElement.write(text);
    }

    public void waitUntilElementPresent(FluentWebElement element) {
        await().atMost(TIME_OUT_IN_SECONDS, TimeUnit.SECONDS).until(element).present();
    }
}
