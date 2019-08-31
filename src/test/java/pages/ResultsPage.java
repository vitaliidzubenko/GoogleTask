package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tools.Element;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsPage extends Page {
    private Element navigateForwardButton;
    private Element resultLinks;

    public ResultsPage() {
        navigateForwardButton = new Element(By.xpath("//a[@id = 'pnnext']"), "ResultsPage -> navigateForwardButton");
        resultLinks = new Element(By.xpath("//div[@class = 'TbwUpd']"), "ResultsPage -> resultLinks");
    }

    public ResultsPage openFirstResultUrl() {
        log.info("Clicking at first link in ResultsPage");
        if (resultLinks.isExist())
            resultLinks.click();
        return this;
    }

    public ResultsPage navigateForward() {
        log.info("Navigating to next Page using bottom menu");
        if (navigateForwardButton.isExist()) {
            navigateForwardButton.click();
        } else
            scrollToEndOfPage();
        return this;
    }

    public boolean getResultsOnPage(String searchingDomain) {
        log.info("Getting text of all Links on ResultsPage");
        List<String> allLinksText = resultLinks.getAll().stream().map(WebElement::getText).collect(Collectors.toList());
        allLinksText.forEach(link -> log.info(String.format("URL: %s", link)));
        return allLinksText.stream().anyMatch(s -> s.contains(searchingDomain));
    }
}
