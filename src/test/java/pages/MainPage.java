package pages;

import org.openqa.selenium.By;
import tools.Element;

public class MainPage extends Page {
    private Element textInputField;
    private Element submitButton;

    public MainPage() {
        textInputField = new Element(By.xpath("//div[@class = 'A8SBwf']//input[@class = 'gLFyf gsfi']"), "MainBasePage -> textInputField");
        submitButton = new Element(By.xpath("//input[@name = 'btnK']"), "MainBasePage -> submitButton");
    }

    public MainPage submitSearch() {
        log.info("Submitting search");
        if (submitButton.isExist())
            submitButton.click();
        return this;
    }

    public MainPage searchText(String word) {
        log.info("Searching input field for text");
        if (textInputField.isExist())
            textInputField.setText(word);
        return this;
    }
}
