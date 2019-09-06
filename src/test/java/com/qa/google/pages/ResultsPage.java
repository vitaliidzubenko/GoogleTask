package com.qa.google.pages;

import com.qa.google.base.BasePage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.qa.google.base.Reporter.log;

@Getter
public class ResultsPage extends BasePage {
    private By navigateForwardButton = By.xpath("//a[@id = 'pnnext']");
    private By resultLinks = By.xpath("//div[@id = 'center_col']//cite");

    @Step
    public ResultsPage openFirstResultUrl() {
        log("Clicking at first link in ResultsPage");
        driverClick(resultLinks);
        return this;
    }

    public ResultsPage navigateForward() {
        log("Navigating to next Page using bottom menu");
        if (driverCheckIfVisible(navigateForwardButton))
            driverClick(navigateForwardButton);
        else {
            scrollToEndOfPage();
            driverClick(navigateForwardButton);
        }
        return this;
    }

    private void scrollToEndOfPage() {
        log("Scrolling to the End of Page using JS");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
