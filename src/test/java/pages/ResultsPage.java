package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tools.Element;
import tools.Page;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends Page {
    private Element firstLink;
    private Element navigateForwardButton;
    private Element resultLinks;

    public ResultsPage(WebDriver driver) {
        super(driver);
        firstLink = new Element(driver, By.xpath("//div[@class = 'ad_cclk']"), "ResultsPage -> firstLink");
        navigateForwardButton = new Element(driver, By.xpath("//a[@id = 'pnnext']"), "ResultsPage -> navigateForwardButton");
        resultLinks = new Element(driver, By.xpath("//div[@class = 'r']"), "ResultsPage -> resultLinks");
    }

    public ResultsPage clickAtFirstUrl() {
        log.info("Clicking at first link in ResultsPage");
        if (firstLink.isExist()) {
            firstLink.clickElem();
        }
        return this;
    }

    public ResultsPage navigateForward() {
        log.info("Navigating to next Page using bottom menu");
        if (navigateForwardButton.isExist()) {
            navigateForwardButton.clickElem();
        } else {
            scrollToEndOfPage();
        }
        pause(1500);
        return this;
    }

    public boolean getResultsOnPage(String searchingDomain) {
        log.info("Getting text of all Links on ResultsPage");
        String result, resultLink;
        List<WebElement> links = new ArrayList<>();
        links.addAll(resultLinks.getAll());
        for (int i = 0; i < links.size(); i++) {
            if (!links.get(i).isDisplayed())
                scrollDownOnPage();
            result = links.get(i).getText();
            resultLink = result.substring(result.indexOf("\n") + 1, result.lastIndexOf("/"));
            log.info("TEXT OF LINK #" + (i + 1) + " is: [" + resultLink + "]");
            if (resultLink.contains(searchingDomain)) {
                return true;
            }
        }
        return false;
    }
}
