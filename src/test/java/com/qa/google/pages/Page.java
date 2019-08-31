package com.qa.google.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import com.qa.google.base.BaseTest;

public class Page extends BaseTest {
    public static Logger log = LogManager.getLogger(Page.class);
    private JavascriptExecutor js = (JavascriptExecutor) getDriver();

    public void scrollToEndOfPage() {
        log.info("Scrolling to the End of Page using JS");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
