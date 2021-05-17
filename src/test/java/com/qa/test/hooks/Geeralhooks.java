package com.qa.test.hooks;

import com.aventstack.extentreports.Status;
import com.google.common.io.Files;
import com.qa.web.componenthelper.ObjectRepository;
import com.qa.web.driverclass.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;


public class Geeralhooks {
    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("testing");
        BaseClass.extentLogs = BaseClass.extent.createTest(scenario.getName());
        BaseClass.extentLogs.assignCategory(scenario.getName());
    }
    @After
    public void getResult(Scenario scenario) {
        System.out.println("Scenario status "+scenario.getStatus());
        if ("PASSED".equalsIgnoreCase(scenario.getStatus().toString())) {
            BaseClass.extentLogs.log(Status.PASS, "Test scenario passed");
        } else if ("FAILED".equalsIgnoreCase(scenario.getStatus().toString())) {
            BaseClass.extentLogs.log(Status.FAIL, "Test scenario failed");
        }
        else if ("PENDING".equalsIgnoreCase(scenario.getStatus().toString())) {
            BaseClass.extentLogs.log(Status.SKIP, "Test scenario skipped");
        }
        BaseClass.extent.flush();
    }
    @After(order = 0)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                //This takes a screenshot from the driver at save it to the specified location
                File sourcePath = ((TakesScreenshot) ObjectRepository.getDriver()).getScreenshotAs(OutputType.FILE);
                //Building up the destination path for the screenshot to save
                //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/" + screenshotName + ".png");
                //Copy taken screenshot from source location to destination location
                Files.copy(sourcePath, destinationPath);
                //This attach the specified screenshot to the test
                BaseClass.extentLogs.addScreenCaptureFromPath(destinationPath.toString());
            } catch (IOException e) {
                BaseClass.extentLogs.error(e.getLocalizedMessage());
            }
        }
    }

    @After(order = 1)
    public void AfterSteps() {
        BaseClass.extent.flush();
    }
}
