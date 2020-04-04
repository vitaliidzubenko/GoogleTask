package com.qa.google.testRunners;

import com.qa.google.init.WebDriverListener;
import com.qa.google.pages.FirstWebPage;
import com.qa.google.pages.MainPage;
import com.qa.google.pages.ResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Listeners;

@Listeners(WebDriverListener.class)
public class BddTestClass {

    @Given("^Open Google and search for \"([^\"]*)\"$")
    public void openGoogleAndSearchFor(String word) {
        new MainPage().searchText(word).submitSearch();
    }

    @When("^Open the first link on search results page$")
    public void openTheFirstLinkOnSearchResultsPage() {
        new ResultsPage().openFirstResultUrl();
    }

    @Then("^Verify that title contains searched \"([^\"]*)\"$")
    public void verifyThatTitleContainsSearched(String word) {
        Assert.assertTrue(new FirstWebPage().getPageTitle().toLowerCase().contains(word), "Title of BasePage must contain direct word!");
    }

    @Then("^Verify that there is expected \"([^\"]*)\" on \"([^\"]*)\" pages$")
    public void verifyThatThereIsExpectedOnPages(String domain, int number) {
        Assert.assertTrue(new ResultsPage().validateResult(domain, number), "Searching of Link must be passed!");
    }
}
