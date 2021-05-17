package com.qa.web.componenthelper;
import org.openqa.selenium.WebElement;

public class LinkHelper {
    private static WebElement element;

    public static void ClickLink(WebElement Locator) {
        element = GenericHelper.getElement(Locator);
        element.click();
        //  Logger.Info(" Clicking on link : " + Locator);
    }
}
