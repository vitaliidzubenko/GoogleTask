package com.qa.google.base;

public class TestManager {
    public static String searchForDomain;
    public static String searchForWord;
    public static String browserName;
    public static String baseUrl;
    public static int pageCount;

    static {
        searchForWord = System.getProperty("search.word");
        baseUrl = System.getProperty("base.url");
        searchForDomain = System.getProperty("search.domain");
        browserName = System.getProperty("browser.name");
        pageCount = Integer.parseInt(System.getProperty("page.count"));
    }
}
