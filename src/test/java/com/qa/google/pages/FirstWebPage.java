package com.qa.google.pages;

import com.qa.google.base.BasePage;
import io.qameta.allure.Step;

import static com.qa.google.base.Reporter.log;
import static com.qa.google.init.DriverManager.getDriver;

public class FirstWebPage extends BasePage {

    @Step
    public String getPageTitle() {
        log("Getting title of Opened WebPage");
        waitForPageLoadComplete();
        String titleText = getDriver().getTitle();
        log(String.format("TEXT of TITLE is: [%s]", titleText));
        return titleText;
    }
}
