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
        resultLinks = new Element(By.xpath("//div[@class = 'TbwUpd']"), "ResultsPage -> resultLinks");
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
        String textOfLink;
        List<WebElement> allLinksAtPage = resultLinks.getAll();
        for (WebElement link : allLinksAtPage) {
            if (!link.isDisplayed()) {
                scrollDownOnPage();
            }
            textOfLink = link.getText();
            log.info("TEXT OF LINK  is: [" + textOfLink + "]");
            if (textOfLink.contains(searchingDomain)) {
                log.info("Successfully found! LINK: [" + textOfLink + "]");
                return true;
            }
        }
        return false;
    }
}
