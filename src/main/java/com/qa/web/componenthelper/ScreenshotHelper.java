package com.qa.web.componenthelper;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {
    private static WebDriver driver = ObjectRepository.Driver;
    public static void takeScreenshot(Scenario scenario) {
        ((JavascriptExecutor) ObjectRepository.getDriver()).executeScript("window.scrollTo(0, document.body" +
                ".scrollHeight/3)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((JavascriptExecutor) ObjectRepository.getDriver()).executeScript("document.body.style.transform = \"scale(.33)\"");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File screenshot = ((TakesScreenshot) ObjectRepository.getDriver()).getScreenshotAs(OutputType.FILE);
        byte[] data = new byte[0];
        try {
            data = FileUtils.readFileToByteArray(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
       // scenario.embed(data, "image/png");

    }
}
