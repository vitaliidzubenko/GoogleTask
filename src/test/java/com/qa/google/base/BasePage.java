package com.qa.google.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
}
