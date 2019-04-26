package tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class Page {
    public static Logger log = LogManager.getLogger(Page.class);
    protected WebDriver driver;
    protected JavascriptExecutor js;

    public Page(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    protected void pause(int delayMs) {
        try {
            Thread.sleep(delayMs);
        } catch (Exception e) {
            log.info("Something went wrong during setting pause!");
        }
    }

    public void scrollToEndOfPage() {
        log.info("Scrolling to the End of Page using JS");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollDownOnPage() {
        log.info("Scrolling Down on Page using JS");
        js.executeScript("window.scrollBy(0,300)");
    }

    public void scrollUpOnPage() {
        log.info("Scrolling Up on Page using JS");
        js.executeScript("window.scrollBy(0,-300)");
    }

}
