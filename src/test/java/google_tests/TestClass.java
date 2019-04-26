package google_tests;

import common.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.OpenedWebSite;
import pages.ResultsPage;
import tools.CustomListener;
import tools.TestInfo;

@Listeners({CustomListener.class})
public class TestClass extends BaseTest {
    private MainPage mainPage;
    private ResultsPage resPage;
    private OpenedWebSite openedWebSite;

    @BeforeClass
    public void beforeRun() {
        mainPage = new MainPage(getDriver());
        resPage = new ResultsPage(getDriver());
        openedWebSite = new OpenedWebSite(getDriver());
    }

    @Test(priority = 1)
    @Description("This Test is checking text of title at first opened link in results page")
    @TestInfo(testId = "1", endpoint = "GoogleSearchTest")
    public void firstTest() {
        mainPage.searchText(searchFor);
        resPage.clickAtFirstUrl();
        Assert.assertTrue(openedWebSite.getTitle().toLowerCase().contains(searchFor), "Title of Page must contain direct word!");
    }

    @Test(priority = 2)
    @Description("This Test is searching direct domain at result pages")
    @TestInfo(testId = "2", endpoint = "GoogleSearchTest")
    public void secondTest() {
        boolean result = false;
        mainPage.searchText(searchFor);
        for (int i = 0; i < pageCount; i++) {
            log.info("Results at Page #" + (i + 1));
            if (resPage.getResultsOnPage(searchingDomain)) {
                result = true;
                log.info("Domain found at Page#" + (i + 1));
                break;
            } else {
                resPage.navigateForward();
            }
        }
        Assert.assertTrue(result, "Searching of Link is passed: [" + result +  "]");
    }
}
