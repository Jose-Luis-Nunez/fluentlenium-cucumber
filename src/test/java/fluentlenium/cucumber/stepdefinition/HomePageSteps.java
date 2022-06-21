package fluentlenium.cucumber.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.core.annotation.Page;
import fluentlenium.cucumber.pageobject.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

@FluentConfiguration(webDriver = "chrome")
public class HomePageSteps extends BaseTest {

    @Page
    private HomePage page;

    @Given("visit duck duck go")
    public void visitDuckDuckGo() {
        goTo("https://duckduckgo.com");
    }

    @When("^I search (.*)")
    public void searchFor(String searchString) {
        page.find(searchString);
    }

    @Then("^Title contains (.*)")
    public void titleContains(String expectedString) {
        assertThat(page.window().title()).contains(expectedString);
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        this.before(scenario);
    }

    @After
    public void afterScenario(Scenario scenario) {
        this.after(scenario);
    }
}
