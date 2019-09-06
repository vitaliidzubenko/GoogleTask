package com.qa.google.base;

import com.qa.google.pages.ResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static com.qa.google.base.Reporter.log;
import static com.qa.google.init.DriverManager.getDriver;
import static com.qa.google.init.DriverManager.getWebDriverWait;

public class BasePage {
    protected JavascriptExecutor js = (JavascriptExecutor) getDriver();

    protected void driverClick(By Locator) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(Locator)).click();
    }

    protected void driverSendKeys(By locator, String text) {
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    protected boolean driverCheckIfVisible(By locator) {
        return getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    protected void waitForPageLoadComplete() {
        getWebDriverWait().until(getDriver -> String
                .valueOf(((JavascriptExecutor) getDriver()).executeScript("return document.readyState"))
                .equals("complete"));
    }

    public boolean getResultsOnPage(String searchingDomain) {
        log("Getting text of all Links on ResultsPage");
        List<String> allLinksText = getDriver().findElements(new ResultsPage().getResultLinks()).stream().map(WebElement::getText).collect(Collectors.toList());
        allLinksText.forEach(link -> log(String.format("URL: %s", link)));
        return allLinksText.stream().anyMatch(s -> s.contains(searchingDomain));
    }
}
