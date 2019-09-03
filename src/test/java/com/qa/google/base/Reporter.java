package com.qa.google.base;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reporter {
    private static final Logger logger = LogManager.getLogger(Reporter.class);

    @Step("{0}")
    public static void log(String log) {
        logger.info("[##### Reporter #####]" + log);
    }
}
