package google_tests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FirstWebPage;
import pages.MainPage;
import pages.ResultsPage;
import tools.BaseTest;

public class TestRunner extends BaseTest {
    private MainPage mainPage;
    private FirstWebPage firstWebPage;

    @BeforeClass(alwaysRun = true)
    public void initPages() {
        mainPage = new MainPage();
        firstWebPage = new FirstWebPage();
    }

    @Test(priority = 1)
    @Description("Checking text of title at first opened link at results page")
    public void checkFirstLinkText() {
        mainPage.searchText(searchForWord).submitSearch();
        new ResultsPage().openFirstResultUrl();
        softAssert.assertTrue(firstWebPage.getTitle().toLowerCase().contains(searchForWord), String.format("Title of First Opened WebPage must contain [%s]", searchForWord));
    }

    @Test(priority = 2)
    @Description("Searching for specific domain at result pages")
    public void searchForDomain() {
        mainPage.searchText(searchForWord).submitSearch();
        softAssert.assertTrue(firstWebPage.validateResult(searchForDomain, pageCount), String.format("Failed to find domain [%s] at [%s] result pages", searchForDomain, pageCount));
    }
}
