package com.qa.web.componenthelper;
import org.openqa.selenium.WebElement;

public class TextBoxHelper {
    private static WebElement element;

    public static void TypeInTextBox(WebElement locator, String text) {
        element = GenericHelper.getElement(locator);
        element.sendKeys(text);

    }

    public static void ClearTextBox(WebElement locator) {
        element = GenericHelper.getElement(locator);
        element.clear();

    }
}
