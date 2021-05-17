package com.qa.web.componenthelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectBoxHelper {
    private static final Logger logger = Logger.getLogger(SelectBoxHelper.class);
    private static WebElement element;

    public static void selectByValue(WebElement locator, String value) {
        element = GenericHelper.getElement(locator);
        new Select(element).selectByValue(value);
        logger.info(" selected element by value : " + locator + value);
    }

    public static void selectByIndex(WebElement locator, int index) {
        element = GenericHelper.getElement(locator);
        new Select(element).selectByIndex(index);
        logger.info(" selected element by Index : " + locator + index);
    }

    public static void selectByText(WebElement locator, String value) {
        element = GenericHelper.getElement(locator);
        new Select(element).selectByVisibleText(value);
        logger.info(" selected element by value : " + locator + value);
    }
}
