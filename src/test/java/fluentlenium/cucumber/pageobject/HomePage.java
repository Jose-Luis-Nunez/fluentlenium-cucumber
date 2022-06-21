package fluentlenium.cucumber.pageobject;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("https://duckduckgo.com")
public class HomePage extends FluentPage {

    @FindBy(css = "#search_form_input_homepage")
    private FluentWebElement searchInput;
    @FindBy(css = "#search_button_homepage")
    private FluentWebElement searchButton;

    public void find(String text) {
        searchInput.fill().with(text);
        searchButton.submit();
    }
}
