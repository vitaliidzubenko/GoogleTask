package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import tools.BaseTest;

public class BasePage extends BaseTest {
    public static Logger log = LogManager.getLogger(BasePage.class);
    private JavascriptExecutor js = (JavascriptExecutor) getDriver();

    public void scrollToEndOfPage() {
        log.info("Scrolling to the End of Page using JS");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollDownOnPage() {
        log.info("Scrolling Down on Page using JS");
        js.executeScript("window.scrollBy(0,300)");
    }

}
