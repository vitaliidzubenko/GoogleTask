package com.qa.google.init;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver createInstance(String browserName) {
        if (browserName.toLowerCase().contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserName.toLowerCase().contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
        return new ChromeDriver();
    }
}
