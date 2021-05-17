package com.qa.api.Engine;
import com.qa.api.ModelRequest.BookingDetails;
import com.qa.api.ModelRequest.UserCredentials;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookingEndpoints {

    private static final String BASE_URL = "https://restful-booker.herokuapp.com";
    public static Response createBooking(BookingDetails bookingDetails) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Accept","application/json");

        request.log().all();
        Response response = request.body(bookingDetails).post("/booking");
        return response;
    }
    public static Response updateBooking(BookingDetails bookingDetails,String token) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Accept","application/json");
        request.header("Cookie","token="+token);
        request.log().all();
        Response response = request.body(bookingDetails).put("/booking/1");
        return response;
    }

    public static Response deleteBooking(String token,String id) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Accept","application/json");
        request.header("Cookie","token="+token);
        request.log().all();
        Response response = request.delete("/booking/"+id);
        return response;
    }

    public static Response healthCheck() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Accept","application/json");
        request.log().all();
        Response response = request.get("/ping");
        return response;
    }

    public static Response getToken(UserCredentials userCredentials) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Accept","application/json");
        request.log().all();
        Response response = request.body(userCredentials).post("/auth");
        return response;
    }
    public static Response getBookingDetails(String id) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Accept","application/json");
        request.log().all();
        Response response = request.get("/booking/" +id);
        return response;
    }



}
