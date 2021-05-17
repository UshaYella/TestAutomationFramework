package com.qa.web.driverclass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.qa.api.Cucumber.ScenarioContext;
import com.qa.web.componenthelper.ObjectRepository;
import com.qa.web.confighelper.ConfigReader;
import com.qa.web.confighelper.Settings;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.Node;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

import static com.qa.web.confighelper.Settings.browser;

public class BaseClass {
    static final Logger logger = Logger.getLogger(BaseClass.class);
    public static ExtentHtmlReporter extentHTMLReporter;
    public static ExtentReports extent;
    public static ExtentTest extentLogs;

    private static ChromeOptions GetChromeOptions() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        logger.info(" Using Chrome Options ");
        return option;
    }

    private static ChromeDriver GetChromeDriver() {
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/browser/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(GetChromeOptions());
        return driver;
    }

    public static void initialize(){
        String log4jConfPath = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        try {
            ConfigReader.PopulateSettings();
        } catch (IOException ie) {
            logger.error(ie.getLocalizedMessage());
            ie.printStackTrace();
        }
        initializeReports();
    }

    public static void initializeBrowser() {
        String log4jConfPath = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        try {
            ConfigReader.PopulateSettings();
        } catch (IOException ie) {
            logger.error(ie.getLocalizedMessage());
            ie.printStackTrace();
        }
        initializeReports();
        switch (browser) {
            case Firefox:
                logger.info(" Using Firefox Driver  ");
                WebDriverManager.firefoxdriver().setup();
                ObjectRepository.Driver = new FirefoxDriver();
                break;
            case Chrome:
                ObjectRepository.Driver = GetChromeDriver();
                logger.info(" Using Chrome Driver  ");
                break;
            default:
                break;
        }
    }

    public static void tearDown() {
          ObjectRepository.getDriver().close();

    }

    public static void initializeReports() {
        extentHTMLReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/test-results/html-report.html"));
        System.out.println(System.getProperty("user.dir") + "/test-results");
        logger.info(System.getProperty("user.dir") + "/test-results");
        extentHTMLReporter.config().setDocumentTitle("Code Challenge Reports");
        extentHTMLReporter.loadConfig(String.valueOf(new File(Settings.ReportConfigPath)));

        extentHTMLReporter.start();
        extent = new ExtentReports();

        extent.attachReporter(extentHTMLReporter);
        extent.setSystemInfo("Environment", "Local Automation testing");

       // extent.loadConfig(new File(Settings.ReportConfigPath));

    }
}
