@Test @Order
Feature: Order details , Where order is created and history of the order is seen
  @TC-Order-001
  Scenario: Verify Order is created and history is shown
    Given User is registered and navigates to www.automationpractice.com
    And User search for an item T-shrit
    When User selects the T-shirt Item and clicks Add to cart
    And User selects to Proceed to checkout for address and shiping
    And user agrees to the Terms of services
    And User chooses a payment method Bank-wire payment
    And User Confirms the order
    Then the order confirmation page is displayed
    And User navigates to My account detail page
    And User clicks on Order History and details button
    Then navigated to Order history and verifies the order details





