package pages;

import org.openqa.selenium.By;
import tools.Element;

public class FirstWebPage extends Page {
    private Element titleOfPage;
    private ResultsPage resPage;

    public FirstWebPage() {
        titleOfPage = new Element(By.xpath("//title"), "OpenedWebSite -> Title of page");
        resPage = new ResultsPage();
    }

    public String getTitle() {
        log.info("Getting title of Opened WebPage");
        if (titleOfPage.isExist()) {
            log.info(String.format("TEXT of TITLE is: [%s]", titleOfPage.getTextByAttribute()));
            return titleOfPage.getTextByAttribute();
        } else
            return "";
    }

    public boolean validateResult(String searchingDomain, int pageCount) {
        return validateResultWrapper(searchingDomain, pageCount);
    }

    private boolean validateResultWrapper(String searchingDomain, int pageCount) {
        for (int i = 0; i < pageCount; i++) {
            log.info(String.format("Results of Page #%s", (i + 1)));
            if (resPage.getResultsOnPage(searchingDomain)) {
                log.info(String.format("Domain [%s] is found at Page #%s", searchingDomain, (i + 1)));
                return true;
            } else
                resPage.navigateForward();
        }
        return false;
    }

}
