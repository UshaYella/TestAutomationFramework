@Test @Booking
Feature: Checking playground API restful-booker.

  @TC-Booking-001
  Scenario: CreateBooking
    Given The Booking Api service is working
    Then  User create a booking with booking details
    And  User validates the booking has created

  @TC-Booking-002
  Scenario: UpdateBooking
    Given The Booking Api service is working
    Then  User create a booking with booking details
    And  User validates the booking has created
    Then User updates a booking
    And User validates the updated booking details

  @TC-Booking-003
  Scenario: DeleteBooking
    Given The Booking Api service is working
    Then  User create a booking with booking details
    And  User validates the booking has created
    Then User deletes a booking
    And User validates the booking details are deleted