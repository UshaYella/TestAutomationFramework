package com.qa.web.componenthelper;
import org.openqa.selenium.WebDriver;

public class ObjectRepository {
    public static WebDriver Driver;

    public static WebDriver getDriver() {
        return Driver;
    }

    public static void setDriver(WebDriver driver) {
        Driver = driver;
    }
}
