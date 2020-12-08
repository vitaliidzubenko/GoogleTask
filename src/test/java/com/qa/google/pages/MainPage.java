package com.qa.google.pages;

import com.qa.google.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.qa.google.base.Reporter.log;

public class MainPage extends BasePage {

    private final By textInputField = By.xpath("//input[@name = 'q']");
    private final By submitButton = By.xpath("//input[@name = 'btnK']");

    @Step
    public void submitSearch() {
        log("Submitting search");
        driverClick(submitButton);
    }

    @Step
    public MainPage searchText(String word) {
        log("Searching input field for text");
        driverSendKeys(textInputField, word);
        return this;
    }
}
