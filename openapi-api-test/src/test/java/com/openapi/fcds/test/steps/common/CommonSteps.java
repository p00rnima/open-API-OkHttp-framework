package com.openapi.fcds.test.steps.common;

import com.openapi.fcds.test.util.PropertyHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.openapi.fcds.test.util.PropertyHelper.getEnv;
import static com.openapi.fcds.test.util.WaitHelper.sleep;

public class CommonSteps {

    private final static Logger LOGGER = LoggerFactory.getLogger(CommonSteps.class);

    static {
        var classLoader = CommonSteps.class.getClassLoader();
        PropertyHelper.loadProperties(getEnv() + ".environment.properties", classLoader);
        PropertyHelper.loadProperties("endpoint.properties", classLoader);
        PropertyHelper.loadProperties("default.properties", classLoader);
    }

    private final Long threadId = Thread.currentThread().getId();
    private CommonData commonData;

    private static void logMessageWithLines(String msg) {
        LOGGER.info("=========================");
        LOGGER.info(msg);
        LOGGER.info("=========================\n");
    }

    @Before
    public void setup(Scenario scenario) throws IOException {
        logMessageWithLines("Scenario setup - Begin");

        CommonDataProvider.newCommonData(threadId);

        if ((commonData = CommonDataProvider.get(threadId)) == null) {
            throw new RuntimeException("Common data not found for id : " + threadId);
        } else {
            commonData.scenario = scenario;
            LOGGER.info("Initialised common data instance for scenario");
        }
        logMessageWithLines("Scenario setup - End");
    }

    @After
    public void tearDown() {
        logMessageWithLines("Scenario teardown - Begin");
        var commonData = CommonDataProvider.get(threadId);
        logMessageWithLines("Scenario teardown - End");
    }

    @SuppressWarnings("squid:S2925")
    @When("^wait for (\\d+) seconds to allow async processing$")
    public void wait_for_seconds_to_allow_async_processing(long seconds) throws Throwable {
        LOGGER.info("Waiting for {} seconds to allow async processing", seconds);
        sleep(seconds);
    }

    @SuppressWarnings("squid:S2925")
    @When("^wait (\\d+) seconds for cache update$")
    public void wait_seconds_cache_update(long seconds) throws Throwable {
        LOGGER.info("Waiting {} seconds for cache update", seconds);
        sleep(seconds);
    }


}
