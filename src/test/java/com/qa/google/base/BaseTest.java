package com.qa.google.base;

import io.qameta.allure.Attachment;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static com.qa.google.base.Reporter.log;
import static com.qa.google.base.TestManager.baseUrl;
import static com.qa.google.init.DriverManager.getDriver;

public class BaseTest extends BasePage {

//    @BeforeClass(alwaysRun = true)
//    public void beforeTestRun() {
//        log("*****Starting Test*****");
//        getDriver().manage().deleteAllCookies();
//        getDriver().manage().window().setSize(new Dimension(1024, 768));
//        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    }

//    @BeforeMethod(alwaysRun = true)
//    public void navigateToBaseUrl() {
//        log("Navigating to BaseUrl");
//        getDriver().navigate().to(baseUrl);
//    }

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
