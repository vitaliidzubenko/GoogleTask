package com.qa.google.pages;

import com.qa.google.base.DriverInit;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.qa.google.base.Reporter.log;

public class MainPage extends DriverInit {
    private By textInputField = By.xpath("//input[@name = 'q']");
    private By submitButton = By.xpath("//input[@name = 'btnK']");

    @Step
    public MainPage submitSearch() {
        log("Submitting search");
        driverClick(submitButton);
        return this;
    }

    @Step
    public MainPage searchText(String word) {
        log("Searching input field for text");
        driverSendKeys(textInputField, word);
        return this;
    }
}
