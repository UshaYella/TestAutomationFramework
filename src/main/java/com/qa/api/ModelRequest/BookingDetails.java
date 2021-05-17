package com.qa.api.ModelRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
public class BookingDetails {
 @JsonProperty
 public String firstname;
 @JsonProperty
 public String lastname;
 @JsonProperty
 public Double totalprice;
 @JsonProperty
 public Boolean depositpaid;
 @JsonProperty
 public Bookingdates bookingdates;
 @JsonProperty
 public String additionalneeds;

 public String getFirstname() {
  return firstname;
 }

 public void setFirstname(String firstname) {
  this.firstname = firstname;
 }

 public String getLastname() {
  return lastname;
 }

 public void setLastname(String lastname) {
  this.lastname = lastname;
 }

 public Double getTotalprice() {
  return totalprice;
 }

 public void setTotalprice(Double totalprice) {
  this.totalprice = totalprice;
 }

 public Boolean getDepositpaid() {
  return depositpaid;
 }

 public void setDepositpaid(Boolean depositpaid) {
  this.depositpaid = depositpaid;
 }

 public Bookingdates getBookingdates() {
  return bookingdates;
 }

 public void setBookingdates(Bookingdates bookingdates) {
  this.bookingdates = bookingdates;
 }

 public String getAdditionalneeds() {
  return additionalneeds;
 }

 public void setAdditionalneeds(String additionalneeds) {
  this.additionalneeds = additionalneeds;
 }
}
