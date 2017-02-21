package com.apitests.TestSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources"},
        glue = {"com/testAPI/stepDefs"},
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        tags = {"@Test01"})
public class TestRunner {
}
