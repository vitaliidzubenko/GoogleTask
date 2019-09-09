package com.qa.google.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    private static ThreadLocal<WebDriverWait> webDriverWait = new ThreadLocal<WebDriverWait>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    public static WebDriverWait getWebDriverWait() {
        return webDriverWait.get();
    }

    public static void setWait(WebDriverWait wait) {
        webDriverWait.set(wait);
    }
}

