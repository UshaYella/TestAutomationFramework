package com.qa.web.componenthelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ComboBoxHelper {
    private static Select select;
    /*
    private static WebDriverWait GetWebDriverWait(WebDriver driver, TimeSpan timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver,timeout)
        {
            PollingInterval = TimeSpan.FromMilliseconds(250)
        };
        wait.IgnoreExceptionTypes(typeof(NoSuchElementException));
        return wait;
    } */
/*
    public static void selectElementWithWait(WebElement locator, int index)
    {
        WebDriverWait wait = GetWebDriverWait(ObjectRepository.Driver, TimeSpan.FromSeconds(60));
        WebElement element =  wait.until(ExpectedConditions.visibilityOf(locator));
        select = new Select(element);
        select.selectByIndex(index);
    } */

    public static void selectElementByIndex(WebElement locator, int index) {
        select = new Select(GenericHelper.getElement(locator));
        select.selectByIndex(index);
    }

    public static void selectElementByText(WebElement locator, String visibletext) {
        select = new Select(GenericHelper.getElement(locator));
        select.selectByVisibleText(visibletext);
    }

    public static void selectElementByValue(WebElement locator, String valueTexts) {
        select = new Select(GenericHelper.getElement(locator));
        select.selectByValue(valueTexts);
    }
/*
    public static List<WebElement> getAllItem(WebElement locator)
    {
        select = new Select (GenericHelper.GetElement(locator));
        return select.Options.Select((x) => x.Text).ToList();
    } */

    public static void selectElement(WebElement element, String visibletext) {
        select = new Select(element);
        select.selectByValue(visibletext);
    }
}
