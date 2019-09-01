package com.qa.google.uiTests;

import com.qa.google.base.BaseTest;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/resources/googleTest.feature"},
        glue = {"com.qa.google"},
        tags = {"@google"},
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"})
public class BddRunner extends AbstractTestNGCucumberTests {
    private BaseTest baseTest = new BaseTest();

    @Before
    public void beforeScenario() {
        baseTest.beforeTestRun();
        baseTest.navigateToBaseUrl();
    }

    @After
    public void afterScenario() {
        baseTest.afterTestRun();
    }
}