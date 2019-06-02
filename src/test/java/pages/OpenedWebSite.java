package pages;

import org.openqa.selenium.By;
import tools.Element;

public class OpenedWebSite extends BasePage {
    private Element titleOfPage;
    private ResultsPage resPage;

    public OpenedWebSite() {
        titleOfPage = new Element(By.xpath("//title"), "OpenedWebSite -> Title of page");
        resPage = new ResultsPage();
    }

    public String getTitle() {
        log.info("Getting title of Opened BasePage");
        if (titleOfPage.isExist()) {
            log.info("TEXT of TITLE is: [" + titleOfPage.getTextByAttribute() + "]");
            return titleOfPage.getTextByAttribute();
        } else {
            return "";
        }
    }

    public boolean validateResult(String searchingDomain) {
        return validateResultWrapper(searchingDomain, pageCount);
    }

    public boolean validateResult(String searchingDomain, int pageCount) {
        return validateResultWrapper(searchingDomain, pageCount);
    }

    private boolean validateResultWrapper(String searchingDomain, int pageCount) {
        for (int i = 0; i < pageCount; i++) {
            log.info("Results of Page #" + (i + 1));
            if (resPage.getResultsOnPage(searchingDomain)) {
                log.info("Domain found at Page #" + (i + 1));
                return true;
            } else {
                resPage.navigateForward();
            }
        }
        return false;
    }

}
