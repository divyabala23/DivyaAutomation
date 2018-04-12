package com.salmon.test;

import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


@CucumberOptions(features = "target/test-classes", tags = "@demo", monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report/runjenkins",
        "json:target/cucumber-report/runjenkins/cucumber.json",
        "rerun:target/cucumber-report/runjenkins/rerun.txt"},
        glue = "com.salmon.test")
public class RunJenkinsSuite extends AbstractTestNGCucumberTests {

//        @BeforeClass
//        public static void setup() {
//            ExtentCucumberFormatter.initiateExtentCucumberFormatter(new File("target/feature-overview/SatishAutomationReport.html"));
//            // Loads the extent config xml to customize on the report.
//            ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));
//            // Also you can add system information using a hash map
//            Map systemInfo = new HashMap();
//            systemInfo.put("Cucumber version", "v1.2.5");
//            ExtentCucumberFormatter.addSystemInfo(systemInfo);
//        }
    //src/test/resources/features/mercurysiteTest
    }
