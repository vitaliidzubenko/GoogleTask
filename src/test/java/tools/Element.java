package tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Element extends BaseTest {
    private final Logger log = LogManager.getLogger(Element.class);
    private String description;
    private By selector;

    public Element(By selector, String description) {
        this.selector = selector;
        this.description = description;
    }

    public void click() {
        log.info("[Clicking at Element: " + description + "]");
        get().click();
    }

    public boolean isExist() {
        log.info("[Checking if Element exists: " + description + "]");
        for (int i = 0; i < 10; i++) {
            implicitWait(1);
            if (get().isEnabled() || get().isDisplayed()) {
                return true;
            } else {
                implicitWait(1);
            }
        }
        return false;
    }

    public String getTextByAttribute() {
        log.info("[Getting text by attribute from Element : " + description + "]");
        String result = "";
        for (int i = 0; i < 3; i++) {
            try {
                result = get().getAttribute("text");
            } catch (Exception ex) {
                implicitWait(1);
            }
        }
        return result;
    }

    public void setText(String str) {
        log.info("[Setting text for Element : " + description + "]");
        get().sendKeys(str);
    }

    private WebElement get() {
        log.info("[Getting selector from Element : " + description + "]");
        return getDriver().findElement(selector);
    }

    public List<WebElement> getAll() {
        log.info("[Getting all Elements : " + description + "]");
        return getDriver().findElements(selector);
    }

}
