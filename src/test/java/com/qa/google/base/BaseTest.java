package com.qa.google.base;

import com.qa.google.init.DriverFactory;
import com.qa.google.init.DriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.qa.google.base.Reporter.log;
import static com.qa.google.init.DriverManager.getDriver;
import static com.qa.google.init.TestParams.baseUrl;
import static com.qa.google.init.TestParams.browserName;

public class BaseTest {

    public void driverSetup() {
        WebDriver driver = DriverFactory.createInstance(browserName);
        DriverManager.setWebDriver(driver);
        DriverManager.setWait(new WebDriverWait(driver, 10));
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().setSize(new Dimension(1024, 768));
        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void navigateToBasePage() {
        log("*****Starting Test*****");
        getDriver().navigate().to(baseUrl);
    }

    public void driverFinish() {
        log("*****Ending Test*****");
        if (getDriver() != null)
            getDriver().quit();
    }
}
