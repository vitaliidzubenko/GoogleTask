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
        log.info(String.format("[Clicking at Element: %s]", description));
        get().click();
    }

    public boolean isExist() {
        log.info(String.format("[Checking if Element exists: %s]", description));
        for (int i = 0; i < 10; i++) {
            if (get().isEnabled() || get().isDisplayed()) {
                return true;
            } else
                implicitWait(1);
        }
        return false;
    }

    public String getTextByAttribute() {
        log.info(String.format("[Getting text by attribute from Element : %s]", description));
        return get().getAttribute("text");
    }

    public void setText(String str) {
        log.info(String.format("[Setting text for Element : %s]", description));
        get().sendKeys(str);
    }

    private WebElement get() {
        log.info(String.format("[Getting selector from Element : %s]", description));
        return getDriver().findElement(selector);
    }

    public List<WebElement> getAll() {
        log.info(String.format("[Getting all Elements : %s]", description));
        return getDriver().findElements(selector);
    }
}
