package com.qa.web.PageFactory;

import com.qa.web.componenthelper.*;
import com.qa.web.driverclass.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.openqa.selenium.support.How.CSS;

public class AHomePage extends PageBase {
    static final Logger logger = Logger.getLogger(AHomePage.class);
    private static WebDriver driver = ObjectRepository.Driver;
    PageBase pageBase = new PageBase(driver);

    public AHomePage() {
        super(driver);
    }

    /**
     * Webelement - #authentication
     **/
    @FindBy(how = CSS, using = ".login")
    private WebElement signIn;
    @FindBy(how = CSS, using = "#email_create")
    private WebElement emailAddress;
    @FindBy(how = CSS, using = "button#SubmitCreate")
    private WebElement btnCreateAccount;
    /*  @FindBy(how = How.XPATH, using = "//input[@id='email']")
      private WebElement textUsername; */
    @FindBy(how = How.CSS, using = "#email")
    private WebElement textUsername;
    @FindBy(how = How.CSS, using = "#passwd")
    private WebElement textPassword;
    @FindBy(how = CSS, using = "#SubmitLogin")
    private WebElement btnSignin;

    public void clickSignin() {
        LinkHelper.ClickLink(signIn);
    }

    public void enterEmailAddress(String text) {
        TextBoxHelper.TypeInTextBox(emailAddress, text);
    }

    public void clickOnCreateAccount() {
        ButtonHelper.clickButton(btnCreateAccount);
    }

    public void enterUsername(String Text) {
        TextBoxHelper.TypeInTextBox(textUsername, Text);
    }

    public void enterPassword(String Text) {
        TextBoxHelper.TypeInTextBox(textPassword, Text);
    }

    public void clickOnSignin(String Text) {
        ButtonHelper.clickButton(btnSignin);
    }

    public void elementInteractive() {
        GenericHelper.jsClickOnElement(btnSignin);
    }

    public void jsClickonSignin() {
        GenericHelper.jsClickOnElement(btnSignin);
    }


}
