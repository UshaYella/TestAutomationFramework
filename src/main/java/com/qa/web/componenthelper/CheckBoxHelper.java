package com.qa.web.componenthelper;
import org.openqa.selenium.WebElement;

public class CheckBoxHelper {
    //  private static readonly ILog Logger = Log4NetHelper.GetXmlLogger(typeof (CheckBoxHelper));
    private static WebElement element;

    public static void clickRadioButton(WebElement locator) {
        element = GenericHelper.getElement(locator);
        element.click();
        //     Logger.Info(" Click on Check box : " + locator);
    }

    public static void checkedCheckBox(WebElement locator) {
        element = GenericHelper.getElement(locator);
        element.click();
        //     Logger.Info(" Click on Check box : " + locator);
    }

    public static boolean isCheckBoxChecked(WebElement locator) {
        element = GenericHelper.getElement(locator);
        String flag = element.getAttribute("checked");
        //     Logger.Info(" Is CheckBox Checked : " + locator);
        if (flag == null)
            return false;
        else
            //  return flag.Equals("true") || flag.Equals("checked");
            return flag.equals("true") || flag.equals("true");
    }
}
