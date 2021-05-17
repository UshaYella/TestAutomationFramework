package com.qa.web.PageFactory;
import com.qa.web.componenthelper.*;
import com.qa.web.driverclass.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.How.XPATH;
public class CategoryPage extends PageBase {
    static final Logger logger = Logger.getLogger(CategoryPage.class);
    private static WebDriver driver = ObjectRepository.Driver;
    PageBase pageBase = new PageBase(driver);

    public CategoryPage() {
        super(driver);
    }

    /**
     * Webelement
     **/
    @FindBy(how = CSS, using = "a.product-name")
    private WebElement clickPrintDressLink;
    @FindBy(how = XPATH, using = "//span[contains(text(),'Add to cart')]")
    private WebElement clickAddtoCart;
    @FindBy(how = XPATH, using = "(//h2)[1]")
    private WebElement getSuccessMessage;
    // @FindBy(how = XPATH, using = "//span[contains(text(),'Proceed to checkout')]")
    @FindBy(how = XPATH, using = "//a[@class ='btn btn-default button button-medium']//child::span")
    private WebElement proceedButton;
    @FindBy(how = XPATH, using = "(//span[contains(text(),'Proceed to checkout')])[2]")
    private WebElement proceedCartButton;
    @FindBy(how = XPATH, using = "//div[@id='uniform-cgv']")
    private WebElement termsCheckbox;
    @FindBy(how = XPATH, using = "//a[contains(text(),'Pay by bank wire')]")
    private WebElement paymentMethodLink;
    @FindBy(how = XPATH, using = "//span[contains(text(),'I confirm my order')]")
    private WebElement confirmOrderButton;
    @FindBy(how = XPATH, using = "//h1[@class ='page-heading']")
    private WebElement messageDisplay;
    @FindBy(how = XPATH, using = "//div[@class='box']")
    private WebElement orderText;

  /* @FindBy(how =CSS, using = "div>h2:nth-of-type(1)")
   private WebElement getSuccessMessage; */

    public void clickOnPrintDress() {
        ButtonHelper.clickButton(clickPrintDressLink);
    }

    public void clickOnAddToCart() {
        ButtonHelper.clickButton(clickAddtoCart);
    }

    public String getMessage() {
        return getSuccessMessage.getText();
    }

    public void clickOnProceedCheckOut() {
        ButtonHelper.clickButton(proceedButton);
    }
    public void clickOnProceedButton() {
        ButtonHelper.clickButton(proceedCartButton);
    }

    public void clickOnTermsCheckBox() {
        CheckBoxHelper.clickRadioButton(termsCheckbox);
    }

    public void clickOnPaymentMethodLink() {
        LinkHelper.ClickLink(paymentMethodLink);
    }

    public void clickOnConfirmOrder() {
        LinkHelper.ClickLink(confirmOrderButton);
    }

    public String getOrderConfirmationMessage() {
        return orderText.getText();
    }

}
