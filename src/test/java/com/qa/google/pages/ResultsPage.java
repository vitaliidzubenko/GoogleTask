package com.qa.google.pages;

import com.qa.google.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.qa.google.base.Reporter.log;
import static com.qa.google.init.DriverManager.getDriver;
import static java.lang.String.format;

public class ResultsPage extends BasePage {

    private final By navigateForwardButton = By.xpath("//a[@id = 'pnnext']");
    private final By resultLinks = By.xpath("//div[@class= 'rc']//a");

    @Step
    public void openFirstResultUrl() {
        log("Clicking at first link in ResultsPage");
        driverClick(resultLinks);
    }

    @Step
    public boolean validateResult(String searchingDomain, int pageCount) {
        for (int i = 0; i < pageCount; i++) {
            log(format("Results of Page #%s", (i + 1)));
            if (getResultsOnPage(searchingDomain)) {
                log(format("Domain [%s] is found at Page #%s", searchingDomain, (i + 1)));
                return true;
            } else
                new ResultsPage().navigateForward();
        }
        return false;
    }

    private boolean getResultsOnPage(String searchingDomain) {
        log("Getting text of all Links on ResultsPage");
        List<String> allLinksText = getDriver().findElements(resultLinks).stream()
            .map(element -> element.getAttribute("href"))
            .collect(Collectors.toList());
        allLinksText.forEach(link -> log(format("URL: %s", link)));
        return allLinksText.stream().anyMatch(link -> link.contains(searchingDomain));
    }

    private void navigateForward() {
        log("Navigating to next Page using bottom menu");
        if (!driverCheckIfVisible(navigateForwardButton))
            scrollToEndOfPage();
        driverClick(navigateForwardButton);
    }

}
