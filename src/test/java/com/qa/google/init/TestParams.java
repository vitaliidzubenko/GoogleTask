package com.qa.google.init;

import org.testng.annotations.DataProvider;

public class TestParams {

    public static String baseUrl;
    public static String browserName;

    static {
        baseUrl = System.getProperty("base.url");
        browserName = System.getProperty("browser.name");
    }

    @DataProvider(name = "SearchForWord")
    public static Object[] searchForData() {
        return new Object[]{"automation"};
    }

    @DataProvider(name = "SearchForDomain")
    public static Object[] pageCountData() {
        return new Object[][]{{"automation", "testautomationday.com", 5}};
    }

}
