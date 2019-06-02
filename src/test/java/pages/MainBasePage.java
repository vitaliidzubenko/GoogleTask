package pages;

import org.openqa.selenium.By;
import tools.Element;

public class MainBasePage extends BasePage {
    private Element textInputField;
    private Element submitButton;

    public MainBasePage() {
        textInputField = new Element(By.xpath("//div[@class = 'A8SBwf']//input[@class = 'gLFyf gsfi']"), "MainBasePage -> textInputField");
        submitButton = new Element(By.xpath("//input[@name = 'btnK']"), "MainBasePage -> submitButton");
    }

    public MainBasePage searchText() {
        log.info("Searching input field for text");
        textInputField.setText(searchFor);
        return this;
    }

    public MainBasePage submitSearch() {
        if (submitButton.isExist()) {
            log.info("Submitting search");
            submitButton.click();
        }
        return this;
    }

    public MainBasePage searchText(String word) {
        log.info("Searching input field for text");
        textInputField.setText(word);
        return this;
    }
}
