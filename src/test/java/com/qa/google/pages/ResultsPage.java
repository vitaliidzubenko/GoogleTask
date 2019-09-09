package com.qa.google.pages;

import com.qa.google.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.qa.google.base.Reporter.log;
import static com.qa.google.init.DriverManager.getDriver;

public class ResultsPage extends BasePage {

    private By navigateForwardButton = By.xpath("//a[@id = 'pnnext']");
    private By resultLinks = By.xpath("//div[@id = 'center_col']//cite");

    @Step
    public ResultsPage openFirstResultUrl() {
        log("Clicking at first link in ResultsPage");
        driverClick(resultLinks);
        return this;
    }

    @Step
    public boolean validateResult(String searchingDomain, int pageCount) {
        for (int i = 0; i < pageCount; i++) {
            log(String.format("Results of Page #%s", (i + 1)));
            if (getResultsOnPage(searchingDomain)) {
                log(String.format("Domain [%s] is found at Page #%s", searchingDomain, (i + 1)));
                return true;
            } else
                new ResultsPage().navigateForward();
        }
        return false;
    }

    private boolean getResultsOnPage(String searchingDomain) {
        log("Getting text of all Links on ResultsPage");
        List<String> allLinksText = getDriver().findElements(resultLinks).stream().map(WebElement::getText).collect(Collectors.toList());
        allLinksText.forEach(link -> log(String.format("URL: %s", link)));
        return allLinksText.stream().anyMatch(s -> s.contains(searchingDomain));
    }

    private ResultsPage navigateForward() {
        log("Navigating to next Page using bottom menu");
        if (driverCheckIfVisible(navigateForwardButton))
            driverClick(navigateForwardButton);
        else {
            scrollToEndOfPage();
            driverClick(navigateForwardButton);
        }
        return this;
    }

}
