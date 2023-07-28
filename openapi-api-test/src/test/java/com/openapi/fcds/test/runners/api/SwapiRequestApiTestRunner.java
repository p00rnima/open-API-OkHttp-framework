package com.openapi.fcds.test.runners.api;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
        plugin = {"pretty", "json:build/cucumber/cucumber-json-report-openapi-request-test.json"},
        monochrome = true,
        tags = "@swapi",
        features = "src/test/resources/feature_files",
        glue = {""})
@Test
public class SwapiRequestApiTestRunner extends AbstractTestNGCucumberTests {}
