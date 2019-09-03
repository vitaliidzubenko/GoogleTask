package com.qa.google.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.qa.google.base.TestManager.browserName;

public class DriverInit {
    private static WebDriver driver;
    private static WebDriverWait wait;
    public JavascriptExecutor js = (JavascriptExecutor) getDriver();

    private void driverSetup() {
        if (browserName == null)
            browserName = "chrome";
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
    }

    private void driverWaitSetup() {
        wait = new WebDriverWait(driver, 10);
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driverSetup();
        }
        return driver;
    }

    public WebDriverWait getWait() {
        if (wait == null)
            driverWaitSetup();
        return wait;
    }

    protected void driverClick(By Locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(Locator)).click();
    }

    protected void driverSendKeys(By locator, String text) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    protected boolean driverCheckIfVisible(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    protected void waitForPageLoadComplete() {
        getWait().until(getDriver -> String
                .valueOf(((JavascriptExecutor) getDriver()).executeScript("return document.readyState"))
                .equals("complete"));
    }
}
