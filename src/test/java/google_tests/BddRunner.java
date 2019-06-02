package google_tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/resources/googleTest.feature"},
        glue = {"google_tests"},
        tags = {"@Run"})
public class BddRunner extends AbstractTestNGCucumberTests {
}