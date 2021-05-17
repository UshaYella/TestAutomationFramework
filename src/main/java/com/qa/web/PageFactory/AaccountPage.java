package com.qa.web.PageFactory;
import com.qa.web.componenthelper.*;
import com.qa.web.driverclass.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.How.*;
public class AaccountPage extends PageBase {
    static final Logger logger = Logger.getLogger(AaccountPage.class);
    private static WebDriver driver = ObjectRepository.Driver;
    PageBase pageBase = new PageBase(driver);

    public AaccountPage() {
        super(driver);
    }

    /**
     * Webelement
     **/
    @FindBy(how = CLASS_NAME, using = "info-account")
    private WebElement displayMessage;
    @FindBy(how = CSS, using = "a[title='Dresses']")
    private WebElement btnDresses;
    @FindBy(how = CSS, using = "input#search_query_top")
    private WebElement searchText;
    @FindBy(how = CSS, using = "button[class='btn btn-default button-search']")
    private WebElement searchButton;
    @FindBy(how = XPATH, using = "//a[@class ='quick-view']")
    private WebElement findAction;
    //   @FindBy(how = CSS, using = "i.icon-th-list -list")
    @FindBy(how = XPATH, using = "//i[@class='icon-th-list']")
    private WebElement sortList;
    @FindBy(how = XPATH, using = "//a[@class = 'account']//child::span")
    private WebElement myAccountMenu;
    @FindBy(how = XPATH, using = "//span[contains(text(),'Order history and details')]")
    private WebElement orderListLink;

    //span[contains(text(),'Order history and details')]

    public String getMessage() {
        return displayMessage.getText();
    }

    public void clickOnDresses() {
        ButtonHelper.clickButton(btnDresses);
    }

    public void jsClickonDresses() {
        //  GenericHelper.isWebelementActive(btnSignin);
        GenericHelper.jsClickOnElement(btnDresses);
    }

    public void setSearchText(String text) throws InterruptedException {
        TextBoxHelper.TypeInTextBox(searchText, text);
        LinkHelper.ClickLink(searchButton);
        LinkHelper.ClickLink(sortList);
        /*
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(sortList));
        sortList.click();*/
    }

    public void moverCursorToCart() {
        Actions action = new Actions(driver);
        action.moveToElement(findAction);
    }

    public void clickOnAccountMenu() {
        LinkHelper.ClickLink(myAccountMenu);
    }

    public void clickOnOrderHistoryLink () {
        LinkHelper.ClickLink(orderListLink);
    }
}
