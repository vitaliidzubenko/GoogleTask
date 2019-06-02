package tools;

import org.testng.annotations.DataProvider;

public class TestParameters {

    @DataProvider(name = "searchDomain")
    public static Object[] searchDomain() {
        return new Object[]{"https://www.testautomationday.com"};
    }

}
