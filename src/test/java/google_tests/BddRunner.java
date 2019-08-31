package google_tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/resources/googleTest.feature"},
        glue = {"google_tests"},
        tags = {"@Google"},
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports"},
        monochrome = true)
public class BddRunner extends AbstractTestNGCucumberTests {
}