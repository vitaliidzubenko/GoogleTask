package com.qa.google.uiTests;

import com.qa.google.base.BaseTest;
import com.qa.google.init.WebDriverListener;
import com.qa.google.pages.FirstWebPage;
import com.qa.google.pages.MainPage;
import com.qa.google.pages.ResultsPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.qa.google.base.TestManager.*;

@Listeners(WebDriverListener.class)
public class TestRunner extends BaseTest {

    @Test
    @Description("Checking text of title at first opened link at result pages")
    public void checkFirstLinkText() {
        new MainPage().searchText(searchForWord).submitSearch();
        new ResultsPage().openFirstResultUrl();
        Assert.assertTrue(new FirstWebPage().getPageTitle().toLowerCase().contains(searchForWord), String.format("Title of First Opened WebPage must contain [%s]", searchForWord));
    }

    @Test
    @Description("Searching for specific domain at result pages")
    public void searchForDomain() {
        new MainPage().searchText(searchForWord).submitSearch();
        Assert.assertTrue(new FirstWebPage().validateResult(searchForDomain, pageCount), String.format("Failed to find domain [%s] at [%s] result pages", searchForDomain, pageCount));
    }
}
