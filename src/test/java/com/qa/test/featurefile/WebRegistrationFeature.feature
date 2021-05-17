Feature: Create an Account for Automation Practice Application

  @system
  Scenario Outline: Verify that user is able to create a new account
    Given User in on Automation home page
    When User clicks on Sign in link
    And  User enters Email Id <e-mail address>
    And User clicks on Create account button
    Then User navigates to createAccount page
    And enter personal details <firstName> <lastName> <address> <phoneNo><city>
    When user clicks on register
    Then user should be able to create an account

    Examples:
      | e-mail address 		    |firstName     |lastName     |address             | phoneNo        |city    |
      |"testcase001@gmail.com"	|"TestUserA"   |"Automation" |"6185 Retail Rd"    |"1 972-656-2196"|"Dallas"|
      |"testcase002@gmail.com"	|"TestUserB"   |"Automation" |"6185 Retail Rd"    |"1 972-656-2196"|"Dallas"|

  @system1
  Scenario: Verify that user is able to add an item to the cart
    Given User is logged in using valid credentials
    And User clicks on Dress Menu
    When  User selects an item and add to the cart
    Then the item should be successfully added
    And user clicks on continue shopping button

    @Test1
   Scenario: Verify that user able to register the user
      Given User in on Automation home page
      When User clicks on Sign in link
      And  User enters with Email address
        |e-mail address        |
        |testauto1@gmail.com   |
      And User enters personal information details
        |title |firstName    |lastName    |password   |dOB|
        |Mrs   |testcase100  |Automation01|Autotesto1 |10-6-2001|
      And User enters Address Details one details
        |FirstName|LastName    |Company|
        |Tester01 |Automation01|Companytest|
      And User enters Address Details two details
        |Address            |Address line 2 |City  |state |Postcode|
        |6185 Retail Rd     |Walmart        |Dallas|Texas |78384|
      And User enters Phone Number Details
        |Additinoal Information   |HomePhone     |MobilePhone   |Addressalias|
        |Testing Website          |1 972-656-2196|1 972-656-2196|SweetHome   |
      Then user should be able to create an account