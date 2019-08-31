package com.qa.google.tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.qa.google.pages.FirstWebPage;
import com.qa.google.pages.MainPage;
import com.qa.google.pages.ResultsPage;
import com.qa.google.base.BaseTest;

public class BddTestClass extends BaseTest {

    @Given("^Open Google and search for \"([^\"]*)\"$")
    public void openGoogleAndSearchFor(String word) {
        beforeTestRun();
        navigateToBaseUrl();
        new MainPage().searchText(word).submitSearch();
    }

    @When("^Open the first link on search results page$")
    public void openTheFirstLinkOnSearchResultsPage() {
        new ResultsPage().openFirstResultUrl();
    }

    @Then("^Verify that title contains searched \"([^\"]*)\"$")
    public void verifyThatTitleContainsSearched(String word) {
        softAssert.assertTrue(new FirstWebPage().getTitle().toLowerCase().contains(word), "Title of BasePage must contain direct word!");
        afterTestRun();
    }

    @Then("^Verify that there is expected \"([^\"]*)\" on \"([^\"]*)\" pages$")
    public void verifyThatThereIsExpectedOnPages(String domain, int number) {
        softAssert.assertTrue(new FirstWebPage().validateResult(domain, number), "Searching of Link must be passed!");
        afterTestRun();
    }
}
