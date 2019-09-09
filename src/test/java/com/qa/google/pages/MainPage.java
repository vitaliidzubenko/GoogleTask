package com.qa.google.pages;

import com.qa.google.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.qa.google.base.Reporter.log;

public class MainPage extends BasePage {

    private By textInputField = By.xpath("//input[@name = 'q']");
    private By submitButton = By.xpath("//input[@name = 'btnK']");

    @Step
    public ResultsPage submitSearch() {
        log("Submitting search");
        driverClick(submitButton);
        return new ResultsPage();
    }

    @Step
    public MainPage searchText(String word) {
        log("Searching input field for text");
        driverSendKeys(textInputField, word);
        return this;
    }
}
