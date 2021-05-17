package com.qa.test.stepdefs;
import com.qa.api.Engine.BookingEndpoints;
import com.qa.api.ModelRequest.BookingDetails;
import com.qa.api.ModelRequest.Bookingdates;
import com.qa.api.ModelRequest.UserCredentials;
import com.qa.api.ModelResponse.BookingResponse;
import com.qa.api.ModelResponse.Token;
import com.qa.web.driverclass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;

import java.util.Date;
public class ApiBookingStepsTest {
    BookingDetails bookingDetails = new BookingDetails();
    Bookingdates bookingdates = new Bookingdates();
    UserCredentials userCredentials = new UserCredentials();
    BookingResponse bookingResponse;
    Token token;
    String bookingId;
    private static Response response;

    @Given("The Booking Api service is working")
    public void the_booking_api_service_is_working() {
        BaseClass.extentLogs.createNode("Given", "The Booking Api service is working");
        Response healthCheckResponse = BookingEndpoints.healthCheck();
        Assert.assertTrue("Health Check failed", healthCheckResponse.getStatusCode() == 201);
        BaseClass.extentLogs.pass("Test step passed");
    }
    @Then("User create a booking with booking details")
    public void user_create_a_booking_with_booking_details() {
        BaseClass.extentLogs.createNode("Given", "The Booking Api service is working");
        bookingDetails.setFirstname("Jim");
        bookingDetails.setLastname("Brown");
        bookingDetails.setTotalprice(121.00);
        bookingDetails.setDepositpaid(true);
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");
        bookingDetails.setBookingdates(bookingdates);
        bookingDetails.setAdditionalneeds("Breakfast");
        response = BookingEndpoints.createBooking(bookingDetails);
        System.out.println(response.asString());
        bookingResponse = response.getBody().as(BookingResponse.class);
        BaseClass.extentLogs.pass("Test step passed");
    }
    @Then("User validates the booking has created")
    public void user_validates_the_booking_has_created() {
        BaseClass.extentLogs.createNode("Given", "User validates the booking has created");
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        Assert.assertNotNull(bookingResponse.getBookingid());
        bookingId = String.valueOf(bookingResponse.getBookingid());
        Assert.assertEquals("Jim", bookingResponse.booking.getFirstname());
        BaseClass.extentLogs.pass("Test step passed");
    }
    @Then("User updates a booking")
    public void user_updates_a_booking() {
        BaseClass.extentLogs.createNode("Given", "User updates a booking");
        userCredentials.setUsername("admin");
        userCredentials.setPassword("password123");
        response = BookingEndpoints.getToken(userCredentials);
        token = response.as(Token.class);
        bookingDetails = BookingEndpoints.getBookingDetails(bookingId).as(BookingDetails.class);
        bookingDetails.setFirstname("Sally");
        response = BookingEndpoints.updateBooking(bookingDetails, token.getToken());
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        bookingDetails = response.as(BookingDetails.class);
        BaseClass.extentLogs.pass("Test step passed");
    }
    @Then("User validates the updated booking details")
    public void user_validates_the_updated_booking_details() {
        BaseClass.extentLogs.createNode("Given", "User validates the updated booking details");
        Assert.assertEquals("Sally", bookingDetails.getFirstname());
        BaseClass.extentLogs.pass("Test step passed");
    }
    @Then("User deletes a booking")
    public void user_deletes_a_booking() {
        BaseClass.extentLogs.createNode("Given", "User deletes a booking");
        userCredentials.setUsername("admin");
        userCredentials.setPassword("password123");
        response = BookingEndpoints.getToken(userCredentials);
        token = response.as(Token.class);
        response = BookingEndpoints.deleteBooking(token.getToken(), bookingId);
        BaseClass.extentLogs.pass("Test step passed");
    }
    @Then("User validates the booking details are deleted")
    public void user_validates_the_booking_details_are_deleted() {
        BaseClass.extentLogs.createNode("Given", "User validates the booking details are deleted");
        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCode());
        BaseClass.extentLogs.pass("Test step passed");
    }
}
