package com.qa.web.PageFactory;

import com.qa.web.componenthelper.*;
import com.qa.web.driverclass.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.How.*;

public class CreateAccountPage extends PageBase {
    static final Logger logger = Logger.getLogger(CreateAccountPage.class);
    private static WebDriver driver = ObjectRepository.Driver;

    public CreateAccountPage() {
        super(driver);
    }

    /**
     * Webelement
     **/

   /* @FindBy(how = CSS, using = "#id_gender1")
    private WebElement radioBMr; */

    @FindBy(how = XPATH, using = "//input[@id='id_gender1']")
    private WebElement radioBMr;
   @FindBy(how = CSS, using = "#id_gender2")
    private WebElement radioBMrs;
    @FindBy(how = CSS, using = "#customer_firstname")
    private WebElement textCFirstName;
    @FindBy(how = CSS, using = "#customer_lastname")
    private WebElement textCLastName;
    @FindBy(how = CSS, using = "#email")
    private WebElement textEmailAddress;
    @FindBy(how = CSS, using = "#passwd")
    private WebElement textPassowrd;
    @FindBy(how = CSS, using = "#days")
    private WebElement dropdownDays;
    @FindBy(how = CSS, using = "#months")
    private WebElement dropdownMonths;
    @FindBy(how = CSS, using = "#years")
    private WebElement dropdownYears;
    @FindBy(how = CSS, using = "#firstname")
    private WebElement textFirstName;
    @FindBy(how = CSS, using = "#lastname")
    private WebElement textLastName;
    @FindBy(how = CSS, using = "#company")
    private WebElement textCompany;
    @FindBy(how = CSS, using = "#address1")
    private WebElement textAddress1;
    @FindBy(how = CSS, using = "#address2")
    private WebElement textAddress2;
    @FindBy(how = CSS, using = "#city")
    private WebElement textCity;

  /*  @FindBy(how = CSS, using = "#uniform-id_state")
    private WebElement dropDownStates; */
    @FindBy(how = NAME, using = "id_state")
    private WebElement dropDownStates;
    @FindBy(how = CSS, using = "#postcode")
    private WebElement textPostCode;
    @FindBy(how = CSS, using = "#id_country")
    private WebElement dropDownCountry;
    @FindBy(how = CSS, using = "#other")
    private WebElement textAddInfo;
    @FindBy(how = CSS, using = " #phone")
    private WebElement textHomePhone;
    @FindBy(how = CSS, using = " #phone_mobile")
    private WebElement textMobilePhone;
    @FindBy(how = CSS, using = "#alias")
    private WebElement textAliasName;
    @FindBy(how = CSS, using = "button#submitAccount")
    private WebElement btnRegister;

    public void selectTitle(String text) {
        if (text.equalsIgnoreCase("Mr")) {
            RadioButtonHelper.clickRadioBox(radioBMr);
        } else {
            RadioButtonHelper.clickRadioBox(radioBMrs);
        }
    }

    public void enterCFirstName(String text) {
        TextBoxHelper.TypeInTextBox(textCFirstName, text);
    }

    public void enterCLastName(String text) {
        TextBoxHelper.TypeInTextBox(textCLastName, text);
    }

    public void enterPassword(String text) {
        TextBoxHelper.TypeInTextBox(textPassowrd, text);
    }

    public void selectDOB(String text) {
        String[] s = text.split("-");
        SelectBoxHelper.selectByValue(dropdownDays, s[0]);
        SelectBoxHelper.selectByValue(dropdownMonths, s[1]);
        SelectBoxHelper.selectByValue(dropdownYears, s[2]);
    }

    public void enterFirstName(String text) {
        TextBoxHelper.TypeInTextBox(textFirstName, text);
    }

    public void enterLastName(String text) {
        TextBoxHelper.TypeInTextBox(textLastName, text);
    }

    public void enterAddress1(String text) {
        TextBoxHelper.TypeInTextBox(textAddress1, text);
    }

    public void enterAddress2(String text) {
        TextBoxHelper.TypeInTextBox(textAddress2, text);
    }

    public void enterCity(String text) {
        TextBoxHelper.TypeInTextBox(textCity, text);
    }

    public void selectState(String text) {
        // SelectBoxHelper.selectByValue(dropDownStates, text);
        SelectBoxHelper.selectByText(dropDownStates, text);
    }

    public void enterZipCode(String text) {
        TextBoxHelper.TypeInTextBox(textPostCode, text);
    }

    public void selectCountry(String text) {
        SelectBoxHelper.selectByValue(dropDownCountry, text);
    }

    public void enterHomePhNo(String text) {
        TextBoxHelper.TypeInTextBox(textHomePhone, text);
    }

    public void enterMobilePhNo(String text) {
        TextBoxHelper.TypeInTextBox(textMobilePhone, text);
    }

    public void enterAlias(String text) {
        TextBoxHelper.TypeInTextBox(textAliasName, text);
    }

    public void enterEmailAddress(String text) {
        TextBoxHelper.TypeInTextBox(textEmailAddress, text);
    }

    public void clickOnRegister() {
        ButtonHelper.clickButton(btnRegister);
    }
}
