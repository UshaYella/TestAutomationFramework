package com.qa.api.ModelRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
public class Bookingdates {
    @JsonProperty
    public String checkin;
    @JsonProperty
    public String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
