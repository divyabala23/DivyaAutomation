package com.salmon.test;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "target/test-classes", tags = {"@demo"}, monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report/desktop/",
        "json:target/cucumber-report/desktop/cucumber.json",
        "rerun:target/cucumber-report/desktop/rerun.txt"},
        glue = "com.salmon.test")

public class RunDesktopSuite extends AbstractTestNGCucumberTests {
}
