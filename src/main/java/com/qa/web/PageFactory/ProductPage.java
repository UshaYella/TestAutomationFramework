package com.qa.web.PageFactory;
import com.qa.web.componenthelper.GenericHelper;
import com.qa.web.componenthelper.ObjectRepository;
import com.qa.web.driverclass.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.How.CSS;

public class ProductPage extends PageBase {
    static final Logger logger = Logger.getLogger(ProductPage.class);
    private static WebDriver driver = ObjectRepository.Driver;
    PageBase pageBase = new PageBase(driver);

    public ProductPage() {
        super(driver);
    }

    /**
     * Webelement
     **/
    @FindBy(how = CSS, using = "info-account")
    private WebElement displayMessage;
    @FindBy(how = CSS, using = "a[title='Dresses'][0]")
    private WebElement btnDresses;

    public String getMessage() {
        return displayMessage.getText();
    }

    /*
    public void clickOnDresses() {

        ButtonHelper.clickButton(btnDresses);
    } */
    public void jsClickonDresses() {
        //  GenericHelper.isWebelementActive(btnSignin);
        GenericHelper.jsClickOnElement(btnDresses);
    }
}
