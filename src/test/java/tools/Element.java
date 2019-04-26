package tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Element {
    private final Logger log = LogManager.getLogger(Element.class);
    private By selector;
    private WebDriver driver;
    private String description;

    public Element(WebDriver driver, By selector, String description) {
        this.selector = selector;
        this.driver = driver;
        this.description = description;
    }

    public void click() {
        log.info("[Clicking at Element: " + description + "]");
        waitForElement(500);
        get().click();
    }

    public void clickElem() {
        log.info("[Clicking at Element: " + description + "]");
        for (int i = 0; i < 10; i++) {
            if (get().isEnabled() && get().isDisplayed()) {
                click();
                break;
            } else {
                pause(1000);
            }
        }
    }

    public boolean isExist() {
        log.info("[Checking if Element exists: " + description + "]");
        for (int i = 0; i < 15; i++) {
            if (get().isEnabled() && get().isDisplayed()) {
                return true;
            } else {
                pause(1000);
            }
        }
        return false;
    }

    protected void pause(int delayMs) {
        log.info("[Paused for  " + delayMs + "]");
        try {
            Thread.sleep(delayMs);
        } catch (Exception e) {
        }
    }

    protected void waitForElement(int timeoutMs) {
        log.info("[Waiting for Element : " + description + "]");
        int delayMs = 100;
        while (timeoutMs > 0) {
            if (isExist())
                return;
            else
                timeoutMs = timeoutMs - delayMs;
            pause(delayMs);
        }
    }

    public void clearText() {
        log.info("[Clearing text for Element : " + description + "]");
        waitForElement(1000);
        get().clear();
    }

    public String getText() {
        log.info("[Getting text from Element : " + description + "]");
        String result = "";
        for (int i = 0; i < 6; i++) {
            try {
                result = get().getText();
            } catch (Exception ex) {
                waitForElement(1000);
            }
        }
        return result;
    }

    public void setText(String str) {
        log.info("[Setting text for Element : " + description + "]");
        waitForElement(1000);
        get().sendKeys(str);
    }

    public WebElement get() {
        log.info("[Getting selector from Element : " + description + "]");
        return driver.findElement(selector);
    }

    public WebElement get(int number) {
        log.info("[Getting Element : " + description + "]");
        return driver.findElements(selector).get(number);
    }

    public WebElement getLast() {
        log.info("[Getting last Element : " + description + "]");
        return driver.findElements(selector).get(driver.findElements(selector).size() - 1);
    }

    public List<WebElement> getAll() {
        log.info("[Getting all Elements : " + description + "]");
        return driver.findElements(selector);
    }

}
