package com.qa.google.uiTests;

import com.qa.google.base.BaseTest;
import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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

    @BeforeClass(alwaysRun = true)
    public void beforeTest() {
        baseTest.beforeTestRun();
    }

    @Before
    public void beforeScenario() {
        baseTest.navigateToBaseUrl();
    }

    @AfterClass
    public void afterScenario() {
        baseTest.afterTestRun();
    }
}