package com.qa.api.ModelResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qa.api.ModelRequest.BookingDetails;
import com.qa.web.PageFactory.CreateAccountPage;
public class BookingResponse {
    @JsonProperty
    public int bookingid;
    @JsonProperty
    public BookingDetails booking;

    public int getBookingid() {
        return bookingid;
    }

    public BookingDetails getBooking() {
        return booking;
    }
}
