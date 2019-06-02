package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tools.Element;

import java.util.List;

public class ResultsPage extends BasePage {
    private Element navigateForwardButton;
    private Element resultLinks;

    public ResultsPage() {
        navigateForwardButton = new Element(By.xpath("//a[@id = 'pnnext']"), "ResultsPage -> navigateForwardButton");
        resultLinks = new Element(By.xpath("//div[@class = 'r']"), "ResultsPage -> resultLinks");
    }

    public ResultsPage openFirstResultUrl() {
        log.info("Clicking at first link in ResultsPage");
        if (resultLinks.isExist()) {
            resultLinks.click();
        }
        return this;
    }

    public ResultsPage navigateForward() {
        log.info("Navigating to next Page using bottom menu");
        if (navigateForwardButton.isExist()) {
            navigateForwardButton.click();
        } else {
            scrollToEndOfPage();
        }
        return this;
    }

    public boolean getResultsOnPage(String searchingDomain) {
        log.info("Getting text of all Links on ResultsPage");
        String result, resultLink;
        List<WebElement> links = resultLinks.getAll();
        for (WebElement link : links) {
            if (!link.isDisplayed()) {
                scrollDownOnPage();
            }
            result = link.getText();
            resultLink = result.substring(result.indexOf("\n") + 1, result.lastIndexOf("/"));
            log.info("TEXT OF LINK  is: [" + resultLink + "]");
            if (resultLink.contains(searchingDomain)) {
                return true;
            }
        }
        return false;
    }
}
