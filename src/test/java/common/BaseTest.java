package common;

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
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String BASE_URL = "https://www.google.com/";
    public static Logger log = LogManager.getLogger(BaseTest.class);
    public static String searchingDomain = "https://www.testautomationday.com";
    public static String searchFor;
    public static String browserName;
    public static int pageCount;
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void beforeTestRun() {
        searchFor = System.getProperty("search.for");
        browserName = System.getProperty("browser.name");
        pageCount = Integer.parseInt(System.getProperty("page.count"));
        browserSetup();
    }

    @BeforeMethod(alwaysRun = true)
    public void start() {
        log.info("########################################################");
        log.info("#####Starting Test");
        driver.manage().deleteAllCookies();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to(BASE_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void finish(ITestResult result) {
        if (!result.isSuccess()) {
            saveScreenshot(getDriver());
        }
        log.info("########################################################");
        log.info("#####Closing Browser");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    private void browserSetup() {
        if (browserName == null)
            browserName = "chrome";
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().version("73.0.3683.68").setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
