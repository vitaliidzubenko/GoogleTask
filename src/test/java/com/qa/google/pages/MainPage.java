package com.qa.google.pages;

import com.qa.google.base.Page;
import org.openqa.selenium.By;
import com.qa.google.base.BaseElement;

public class MainPage extends Page {
    private BaseElement textInputField;
    private BaseElement submitButton;

    public MainPage() {
        textInputField = new BaseElement(By.xpath("//div[@class = 'A8SBwf']//input[@class = 'gLFyf gsfi']"), "MainBasePage -> textInputField");
        submitButton = new BaseElement(By.xpath("//input[@name = 'btnK']"), "MainBasePage -> submitButton");
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
