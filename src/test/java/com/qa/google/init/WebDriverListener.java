package com.qa.google.init;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

import static com.qa.google.base.TestManager.baseUrl;
import static com.qa.google.init.DriverManager.getDriver;

public class WebDriverListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
            WebDriver driver = DriverFactory.createInstance(browserName);
            DriverManager.setWebDriver(driver);
            DriverManager.setWait(new WebDriverWait(driver, 10));
            getDriver().manage().deleteAllCookies();
            getDriver().manage().window().setSize(new Dimension(1024, 768));
            getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            getDriver().navigate().to(baseUrl);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = DriverManager.getDriver();
            if (driver != null)
                driver.quit();
        }
    }
}
