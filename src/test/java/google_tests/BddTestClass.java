package google_tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.MainBasePage;
import pages.OpenedWebSite;
import pages.ResultsPage;
import tools.BaseTest;

public class BddTestClass extends BaseTest {

    @Given("^Open Google and search for \"([^\"]*)\"$")
    public void openGoogleAndSearchFor(String word) {
        beforeTestRun();
        navigateToBaseUrl();
        new MainBasePage().searchText(word).submitSearch();
    }

    @When("^Open the first link on search results page$")
    public void openTheFirstLinkOnSearchResultsPage() {
        new ResultsPage().openFirstResultUrl();
    }

    @Then("^Verify that title contains searched \"([^\"]*)\"$")
    public void verifyThatTitleContainsSearched(String word) {
        Assert.assertTrue(new OpenedWebSite().getTitle().toLowerCase().contains(word), "Title of BasePage must contain direct word!");
    }

    @Then("^Verify that there is expected \"([^\"]*)\" on (\\d+) pages$")
    public void verifyThatThereIsExpectedOnPages(String domain, int number) {
        Assert.assertTrue(new OpenedWebSite().validateResult(domain, number), "Searching of Link must be passed!");
    }

}
