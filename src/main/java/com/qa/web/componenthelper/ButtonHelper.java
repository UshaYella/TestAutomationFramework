package com.qa.web.componenthelper;
import org.openqa.selenium.WebElement;

public class ButtonHelper {
    private static WebElement element;

    public static void clickButton(WebElement locator) {
        element = GenericHelper.getElement(locator);
        element.click();
        //      Logger.Info(" Button Click @ " + locator);
    }

    public static boolean isButtonEnabled(WebElement locator) {
        element = GenericHelper.getElement(locator);
        //         Logger.Info(" Checking Is Button Enabled ");
        return element.isEnabled();
    }

    public static String getButtonText(WebElement locator) {
        element = GenericHelper.getElement(locator);
        if (element.getAttribute("value") == null)
            //   return string.Empty;
            return String.valueOf(element);
        return element.getAttribute("value");
    }
}
