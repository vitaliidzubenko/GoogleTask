package com.qa.google.pages;

import com.qa.google.base.BaseElement;
import com.qa.google.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsPage extends Page {
    private BaseElement navigateForwardButton;
    private BaseElement resultLinks;

    public ResultsPage() {
        navigateForwardButton = new BaseElement(By.xpath("//a[@id = 'pnnext']"), "ResultsPage -> navigateForwardButton");
        resultLinks = new BaseElement(By.xpath("//div[@id = 'center_col']//cite"), "ResultsPage -> resultLinks");
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
        } else {
            scrollToEndOfPage();
            navigateForwardButton.click();
        }
        return this;
    }

    public boolean getResultsOnPage(String searchingDomain) {
        log.info("Getting text of all Links on ResultsPage");
        List<String> allLinksText = resultLinks.getAll().stream().map(WebElement::getText).collect(Collectors.toList());
        allLinksText.forEach(link -> log.info(String.format("URL: %s", link)));
        return allLinksText.stream().anyMatch(s -> s.contains(searchingDomain));
    }
}
