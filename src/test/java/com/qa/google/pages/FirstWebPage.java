package com.qa.google.pages;

import com.qa.google.base.DriverInit;
import io.qameta.allure.Step;
import static com.qa.google.base.Reporter.log;

public class FirstWebPage extends DriverInit {

    @Step
    public String getPageTitle() {
        log("Getting title of Opened WebPage");
        waitForPageLoadComplete();
        String titleText = getDriver().getTitle();
        log(String.format("TEXT of TITLE is: [%s]", titleText));
        return titleText;
    }

    @Step
    public boolean validateResult(String searchingDomain, int pageCount) {
        for (int i = 0; i < pageCount; i++) {
            log(String.format("Results of Page #%s", (i + 1)));
            if (new ResultsPage().getResultsOnPage(searchingDomain)) {
                log(String.format("Domain [%s] is found at Page #%s", searchingDomain, (i + 1)));
                return true;
            } else
                new ResultsPage().navigateForward();
        }
        return false;
    }
}
