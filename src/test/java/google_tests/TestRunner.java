package google_tests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainBasePage;
import pages.OpenedWebSite;
import pages.ResultsPage;
import tools.BaseTest;
import tools.TestParameters;

public class TestRunner extends BaseTest {
    private MainBasePage mainPage;
    private ResultsPage resPage;
    private OpenedWebSite openedWebSite;

    @BeforeClass
    public void beforeRun() {
        mainPage = new MainBasePage();
        resPage = new ResultsPage();
        openedWebSite = new OpenedWebSite();
    }

    @Test(priority = 1)
    @Description("Checking text of title at first opened link at results page")
    public void firstTest() {
        mainPage.searchText().submitSearch();
        resPage.openFirstResultUrl();
        softAssert.assertTrue(openedWebSite.getTitle().toLowerCase().contains(searchFor), "Title of BasePage must contain direct word!");
    }

    @Test(priority = 2, dataProvider = "searchDomain", dataProviderClass = TestParameters.class)
    @Description("Searching direct domain at result pages")
    public void secondTest(String domain) {
        mainPage.searchText().submitSearch();
        softAssert.assertTrue(openedWebSite.validateResult(domain), "Searching of Link must be passed!");
    }
}
