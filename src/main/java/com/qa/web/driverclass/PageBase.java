package com.qa.web.driverclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    private WebDriver driver;

    public PageBase(WebDriver _driver) {
        PageFactory.initElements(_driver, this);
        this.driver = _driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
