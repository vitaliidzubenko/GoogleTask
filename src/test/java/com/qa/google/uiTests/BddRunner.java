package com.qa.google.uiTests;

import com.qa.google.base.BaseTest;
import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.qa.google.base.Reporter.log;
import static com.qa.google.init.DriverManager.getDriver;
import static com.qa.google.init.TestParams.baseUrl;

@CucumberOptions(
        features = {"src/test/resources/googleTest.feature"},
        glue = {"com.qa.google"},
        tags = {"@google"},
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"})
public class BddRunner extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true)
    public void onTestStart() {
        new BaseTest().beforeTestRun();
    }

    @Before
    public void beforeScenario() {
        log("*****Starting Test*****");
        getDriver().navigate().to(baseUrl);
    }

    @AfterClass(alwaysRun = true)
    public void afterScenario() {
        log("*****Ending Test*****");
        if (getDriver() != null)
            getDriver().quit();
    }

}