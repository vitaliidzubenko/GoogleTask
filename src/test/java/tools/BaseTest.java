package tools;

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
    protected static String searchFor;
    protected static int pageCount;
    private static Logger log = LogManager.getLogger(BaseTest.class);
    private static WebDriver driver;
    private final String BASE_URL = "https://www.google.com/";
    private String browserName;

    @BeforeClass(alwaysRun = true)
    public void beforeTestRun() {
        log.info("*****Starting Test*****");
        driverSetup();
        gettingAllParameters();
        driver.manage().deleteAllCookies();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @BeforeMethod(alwaysRun = true)
    public void navigateToBaseUrl() {
        driver.navigate().to(BASE_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void finish(ITestResult result) {
        if (!result.isSuccess()) {
            saveScreenshot(getDriver());
        }
    }

    @AfterClass(alwaysRun = true)
    public void afterTestRun() {
        log.info("*****Closing Browser*****");
        driver.manage().deleteAllCookies();
        driver.close();
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

    private void gettingAllParameters() {
        searchFor = System.getProperty("search.for");
        browserName = System.getProperty("browser.name");
        pageCount = Integer.parseInt(System.getProperty("page.count"));
    }

    @Attachment(value = "BasePage screenshot", type = "image/png")
    private byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
