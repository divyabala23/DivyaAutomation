package com.salmon.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features", tags = {"@mytest"}, monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report/runwebat",
        "json:target/cucumber-report/runwebat/cucumber.json",
        "rerun:target/cucumber-report/runwebat/rerun.txt"},
        glue = "com.salmon.test")
public class RunWebATSuite extends AbstractTestNGCucumberTests {
}
