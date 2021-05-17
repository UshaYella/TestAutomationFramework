package com.qa.test.stepdefs;
import com.aventstack.extentreports.Status;
import com.qa.web.PageFactory.AHomePage;
import com.qa.web.PageFactory.AaccountPage;
import com.qa.web.PageFactory.CategoryPage;
import com.qa.web.PageFactory.OrderHistoryPage;
import com.qa.web.componenthelper.GenericHelper;
import com.qa.web.componenthelper.NavigationHelper;
import com.qa.web.confighelper.Settings;
import com.qa.web.driverclass.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class OrderDetailsStepsTest {
    AHomePage aHomePage = new AHomePage();
    AaccountPage aaccountPage = new AaccountPage();
    CategoryPage categoryPage = new CategoryPage();
    OrderHistoryPage orderHistoryPage = new OrderHistoryPage();
    public static String orderRefNo;

    @Given("User is registered and navigates to www.automationpractice.com")
    public void user_is_registered_and_navigates_to_www_automationpractice_com() {
        BaseClass.extentLogs.createNode("Given", "I am registered customer");
        NavigationHelper.NavigateToUrl(Settings.Website);
        GenericHelper.implicitlyWait();
        aHomePage.clickSignin();
        aHomePage.enterUsername(Settings.Username);
        aHomePage.enterPassword(Settings.Password);
        aHomePage.jsClickonSignin();
        BaseClass.extentLogs.pass("Test step passed");

    }
    @Given("User search for an item T-shrit")
    public void user_search_for_an_item_t_shrit() throws InterruptedException {
        BaseClass.extentLogs.createNode("Given", "User search for an item T-shrit");
        aaccountPage.setSearchText("T-shirt");
        BaseClass.extentLogs.pass("Test step passed");

    }
    @When("User selects the T-shirt Item and clicks Add to cart")
    public void user_selects_the_t_shirt_item_and_clicks_add_to_cart() {
        BaseClass.extentLogs.createNode("Given", "User selects the T-shirt Item and clicks Add to cart");
        categoryPage.clickOnAddToCart();
        GenericHelper.implicitlyWait();
        categoryPage.clickOnProceedCheckOut();
        BaseClass.extentLogs.pass("Test step passed");

    }
    @When("User selects to Proceed to checkout for address and shiping")
    public void user_selects_to_proceed_to_checkout_for_address_and_shiping() {
        BaseClass.extentLogs.createNode("Given", "User selects to Proceed to checkout for address and shipping");
        GenericHelper.implicitlyWait();
        categoryPage.clickOnProceedButton();
        GenericHelper.implicitlyWait();
        categoryPage.clickOnProceedButton();
        BaseClass.extentLogs.pass("Test step passed");
    }
    @When("user agrees to the Terms of services")
    public void user_agrees_to_the_terms_of_services() {
        BaseClass.extentLogs.createNode("Given", "user agrees to the Terms of services");
        GenericHelper.implicitlyWait();
        categoryPage.clickOnTermsCheckBox();
        categoryPage.clickOnProceedButton();
        BaseClass.extentLogs.pass("Test step passed");
    }
    @When("User chooses a payment method Bank-wire payment")
    public void user_chooses_a_payment_method_bank_wire_payment() {
        BaseClass.extentLogs.createNode("Given", "User chooses a payment method Bank-wire payment");
        GenericHelper.implicitlyWait();
        categoryPage.clickOnPaymentMethodLink();
        BaseClass.extentLogs.pass("Test step passed");
    }
    @When("User Confirms the order")
    public void user_confirms_the_order() {
        BaseClass.extentLogs.createNode("Given", "User Confirms the order");
        GenericHelper.implicitlyWait();
        categoryPage.clickOnConfirmOrder();
        BaseClass.extentLogs.pass("Test step passed");
    }
    @Then("the order confirmation page is displayed")
    public void the_order_confirmation_page_is_displayed() {
        BaseClass.extentLogs.createNode("Given", "the order confirmation page is displayed");
       // Assert.assertTrue("Order not confirmed",);
       String orderReferenceText = categoryPage.getOrderConfirmationMessage();
       // System.out.println(orderReferenceText);
        Pattern p = Pattern.compile("[A-Z]{9}");
        Matcher m = p.matcher(orderReferenceText);
        if(m.find()){

            System.out.println(m.group(0));
            orderRefNo = m.group(0);
        }
        Assert.assertNotNull(orderRefNo);
        BaseClass.extentLogs.pass("Test step passed");
    }
    @Then("User navigates to My account detail page")
    public void user_navigates_to_my_account_detail_page() {
        BaseClass.extentLogs.createNode("Given", "User navigates to My account detail page");
      GenericHelper.implicitlyWait();
      aaccountPage.clickOnAccountMenu();
        BaseClass.extentLogs.pass("Test step passed");
    }
    @Then("User clicks on Order History and details button")
    public void user_clicks_on_order_history_and_details_button() {
        BaseClass.extentLogs.createNode("Given", "User clicks on Order History and details button");
        GenericHelper.implicitlyWait();
        aaccountPage.clickOnOrderHistoryLink();
        BaseClass.extentLogs.pass("Test step passed");
    }
    @Then("navigated to Order history and verifies the order details")
    public void navigated_to_order_history_and_verifies_the_order_details() {
        BaseClass.extentLogs.createNode("Given", "navigated to Order history and verifies the order details");
        GenericHelper.implicitlyWait();
      String orderId =   orderHistoryPage.getOrderId();
        System.out.println(orderId);
          Assert.assertTrue("Order ref  not found",orderId.contains(orderRefNo));
        BaseClass.extentLogs.pass("Test step passed");

    }

}
