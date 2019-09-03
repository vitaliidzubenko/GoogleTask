package com.qa.google.pages;

import com.qa.google.base.DriverInit;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.qa.google.base.Reporter.log;

public class ResultsPage extends DriverInit {
    private By navigateForwardButton = By.xpath("//a[@id = 'pnnext']");
    private By resultLinks = By.xpath("//div[@id = 'center_col']//cite");

    @Step
    public ResultsPage openFirstResultUrl() {
        log("Clicking at first link in ResultsPage");
        driverClick(resultLinks);
        return this;
    }

    public ResultsPage navigateForward() {
        log("Navigating to next Page using bottom menu");
        if (driverCheckIfVisible(navigateForwardButton))
            driverClick(navigateForwardButton);
        else {
            scrollToEndOfPage();
            driverClick(navigateForwardButton);
        }
        return this;
    }

    private void scrollToEndOfPage() {
        log("Scrolling to the End of Page using JS");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public boolean getResultsOnPage(String searchingDomain) {
        log("Getting text of all Links on ResultsPage");
        List<String> allLinksText = getDriver().findElements(resultLinks).stream().map(WebElement::getText).collect(Collectors.toList());
        allLinksText.forEach(link -> log(String.format("URL: %s", link)));
        return allLinksText.stream().anyMatch(s -> s.contains(searchingDomain));
    }
}
