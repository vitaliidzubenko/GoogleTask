package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tools.Element;
import tools.Page;

public class OpenedWebSite extends Page {
    private Element titleOfPage;

    public OpenedWebSite(WebDriver driver) {
        super(driver);
        titleOfPage = new Element(driver, By.xpath("//h1[@class = 'heading']"), "dfgdfg");
    }

    public String getTitle() {
        log.info("Getting title of Opened Page");
        if (titleOfPage.isExist()) {
            log.info("TEXT of TITLE is: [" + titleOfPage.getText() + "]");
            return titleOfPage.getText();
        } else {
            return "";
        }
    }
}
