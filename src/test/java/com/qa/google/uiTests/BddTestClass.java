package com.qa.google.uiTests;

import com.qa.google.pages.FirstWebPage;
import com.qa.google.pages.MainPage;
import com.qa.google.pages.ResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

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
        Assert.assertTrue(new FirstWebPage().validateResult(domain, number), "Searching of Link must be passed!");
    }
}
