package com.qa.google.testRunners;

import com.qa.google.base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.qa.google.init.DriverManager.getDriver;
import static com.qa.google.init.TestParams.baseUrl;

public class Hook {

    @Before
    public void testSetup() {
        new BaseTest().driverSetup();
        getDriver().navigate().to(baseUrl);
    }

    @After
    public void afterScenario() {
        new BaseTest().driverFinish();
    }
}
