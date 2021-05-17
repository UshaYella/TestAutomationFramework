package com.qa.test.TestRunners;

import com.aventstack.extentreports.Status;
import com.qa.web.driverclass.BaseClass;
//import io.cucumber.listener.Reporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:build/cucumber.json",
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        },
         features = {"src/test/java/com/qa/test/featurefile"},
          glue = {"com.qa.test.stepdefs","com.qa.test.hooks"},
           monochrome = true,
          stepNotifications = true,
      //  dryRun = true,
        tags = "@Test"
)
public class TestRunner {
    static final Logger logger = Logger.getLogger(TestRunner.class);
    @BeforeClass
    public static void setUp() {
           BaseClass.initializeBrowser();
    }
    @AfterClass
    public static void tearDown() {
        BaseClass.tearDown();
    }


}



