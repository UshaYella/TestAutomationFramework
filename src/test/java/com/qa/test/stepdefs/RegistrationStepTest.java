package com.qa.test.stepdefs;

import com.qa.web.PageFactory.AHomePage;
import com.qa.web.PageFactory.AaccountPage;
import com.qa.web.PageFactory.CategoryPage;
import com.qa.web.PageFactory.CreateAccountPage;
import com.qa.web.componenthelper.AssertHelper;
import com.qa.web.componenthelper.GenericHelper;
import com.qa.web.componenthelper.NavigationHelper;
import com.qa.web.confighelper.Settings;
import com.qa.web.driverclass.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

public class RegistrationStepTest {
    public final static Logger logger = Logger.getLogger(RegistrationStepTest.class);
    public AHomePage aHomePage = new AHomePage();
    public CreateAccountPage ca = new CreateAccountPage();
    public AaccountPage ap = new AaccountPage();
    public CategoryPage cp = new CategoryPage();

    @Given("User in on Automation home page")
    public void user_in_on_automation_home_page() {
        BaseClass.extentLogs.createNode("And", "I navigate to www.automationpractice.com");
        NavigationHelper.NavigateToUrl(Settings.Website);
        BaseClass.extentLogs.pass("I navigate to www.automationpractice.com");
    }
    @When("User clicks on Sign in link")
    public void user_clicks_on_sign_in_link() throws InterruptedException {
        aHomePage.clickSignin();
    }
    @When("User enters Email Id {string}")
    public void user_enters_email_id(String string) {
        GenericHelper.implicitlyWait();
        aHomePage.enterEmailAddress(string);
    }
    @When("User clicks on Create account button")
    public void user_clicks_on_create_account_button() {
        aHomePage.clickOnCreateAccount();
    }
    @Then("User navigates to createAccount page")
    public void user_navigates_to_create_account_page() throws InterruptedException {
        GenericHelper.implicitlyWait();
        aHomePage.getTitle();
    }
    @Then("enter personal details {string} {string} {string} {string}{string}")
    public void enter_personal_details(String firstName, String lastName, String address, String phoneNo, String city) {
        ca.selectTitle("Mr");
        ca.enterCFirstName(firstName);
        ca.enterCLastName(lastName);
        ca.enterPassword("Password@12");
        ca.selectDOB("10-6-2001");
        ca.enterFirstName(firstName);
        ca.enterLastName(lastName);
        ca.enterAddress1(address);
        ca.enterCity(city);
        ca.selectState("Texas");
        ca.enterZipCode("78384");
        // ca.selectCountry("");
        ca.enterHomePhNo("972-656-2196");
        ca.enterMobilePhNo("1 972-656-2196");
    }
    @When("user clicks on register")
    public void user_clicks_on_register() {
        ca.clickOnRegister();
    }
    @Then("user should be able to create an account")
    public void user_should_be_able_to_create_an_account() {
        String expectedMessage = "Welcome to your account. Here you can manage all of your personal information and " +
                "orders.";
        String actualMessage = ap.getMessage();
        AssertHelper.areEqual(expectedMessage, actualMessage);
    }
    @Given("User is logged in using valid credentials")
    public void user_is_logged_in_using_valid_credentials() {
       BaseClass.extentLogs.createNode("Given", "User is logged in using valid credentials");
        NavigationHelper.NavigateToUrl(Settings.Website);
        aHomePage.clickSignin();
        aHomePage.enterUsername(Settings.Username);
        aHomePage.enterPassword(Settings.Password);
        aHomePage.jsClickonSignin();
        BaseClass.extentLogs.pass("User is logged in using valid credentials");
    }
    @Given("User clicks on Dress Menu")
    public void user_clicks_on_dress_menu() {
        ap.jsClickonDresses();
    }
    @When("User selects an item and add to the cart")
    public void user_selects_an_item_and_add_to_the_cart() {
        cp.clickOnPrintDress();
        cp.clickOnAddToCart();
        GenericHelper.implicitlyWait();
    }
    @Then("the item should be successfully added")
    public void the_item_should_be_successfully_added() throws InterruptedException {
        String expectedMessage = "Product successfully added to your shopping cart";
        String actualMessage = cp.getMessage();
     //   AssertHelper.areEqual(expectedMessage, actualMessage);
    }
    @When("User enters with Email address")
    public void user_enters_with_email_address(DataTable emailAddressInfo) {
      List<Map<String,String>>   emailAddressMapList = emailAddressInfo.asMaps(String.class,String.class);
             for(Map<String,String> emailAddressMap : emailAddressMapList) {
            System.out.println(emailAddressMap);
          /*  String eMailAdd = emailAddressMap.get("e-mail address");
            aHomePage.enterEmailAddress(eMailAdd); */
           aHomePage.enterEmailAddress(emailAddressMap.get("e-mail address"));
            aHomePage.clickOnCreateAccount();
           GenericHelper.implicitlyWait();
        }
    }
    @When("User enters personal information details")
    public void user_enters_personal_information_details(DataTable personalInfo) {
        List<Map<String,String>>   personalInfoMapList = personalInfo.asMaps(String.class,String.class);
        for(Map<String,String> personalInfoMap : personalInfoMapList) {
            // System.out.println(personalInfoMapList);
            String title = personalInfoMap.get("title");
            String firstName = personalInfoMap.get("firstName");
            String lastName = personalInfoMap.get("lastName");
            String password = personalInfoMap.get("password");
            String doB = personalInfoMap.get("dOB");
            ca.selectTitle(title);
            ca.enterCFirstName(firstName);
            ca.enterCLastName(lastName);
            ca.enterPassword(password);
            ca.selectDOB(doB);
        }
    }
    @When("User enters Address Details one details")
    public void user_enters_address_details_one_details(DataTable dataTable) {

    }
    @When("User enters Address Details two details")
    public void user_enters_address_details_two_details(DataTable dataTable) {

    }
    @When("User enters Phone Number Details")
    public void user_enters_phone_number_details(DataTable dataTable) {

    }
    @Then("user clicks on continue shopping button")
    public void user_clicks_on_continue_shopping_button() {

    }
}
