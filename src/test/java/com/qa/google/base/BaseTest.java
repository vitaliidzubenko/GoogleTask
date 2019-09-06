package com.qa.google.base;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import static com.qa.google.base.Reporter.log;
import static com.qa.google.base.TestManager.baseUrl;
import static com.qa.google.init.DriverManager.getDriver;

public class BaseTest {

    public void navigateToBaseUrl() {
        log("Navigating to BaseUrl");
        getDriver().navigate().to(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void finish(ITestResult result) {
        if (!result.isSuccess())
            saveScreenshot(getDriver());
    }

    @AfterClass(alwaysRun = true)
    public void afterTestRun() {
        log("*****Ending Test*****");
        if (getDriver() != null)
            getDriver().quit();
    }

    @Attachment(value = "BasePage screenshot", type = "image/png")
    private byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
