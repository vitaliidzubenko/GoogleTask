package com.qa.google.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static String searchForDomain;
    public static String searchForWord;
    public static int pageCount;
    private static Logger log = LogManager.getLogger(BaseTest.class);
    private static WebDriver driver;
    private static String browserName;
    private static String baseUrl;

    static {
        searchForWord = System.getProperty("search.word");
        baseUrl = System.getProperty("base.url");
        searchForDomain = System.getProperty("search.domain");
        browserName = System.getProperty("browser.name");
        pageCount = Integer.parseInt(System.getProperty("page.count"));
    }

    @BeforeClass(alwaysRun = true)
    public void beforeTestRun() {
        driverSetup();
        driver.manage().deleteAllCookies();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @BeforeMethod(alwaysRun = true)
    public void navigateToBaseUrl() {
        log.info("*****Starting Test*****");
        driver.navigate().to(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void finish(ITestResult result) {
        if (!result.isSuccess())
            saveScreenshot(getDriver());
    }

    @AfterClass(alwaysRun = true)
    public void afterTestRun() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void implicitWait(int timeOut) {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

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

    @Attachment(value = "BasePage screenshot", type = "image/png")
    private byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
