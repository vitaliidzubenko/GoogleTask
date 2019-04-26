package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tools.Element;
import tools.Page;

public class MainPage extends Page {
    private Element textInputField;
    private Element submitButton;

    public MainPage(WebDriver driver) {
        super(driver);
        textInputField = new Element(driver, By.xpath("//div[@class = 'A8SBwf']//input[@class = 'gLFyf gsfi']"), "MainPage -> textInputField");
        submitButton = new Element(driver, By.xpath("//input[@name = 'btnK']"), "MainPage -> submitButton");
    }

    public MainPage searchText(String text) {
        log.info("Searching input field for text");
        textInputField.setText(text);
        if (submitButton.isExist()) {
            log.info("Submitting search");
            submitButton.clickElem();
        }
        return this;
    }

}
