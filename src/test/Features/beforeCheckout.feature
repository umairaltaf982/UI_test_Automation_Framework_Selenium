Feature: Selecting the products in Cart before Checkout

  Scenario: Navigating to Checkout Page Successfully
    Given User is on the shopping cart page
    When User enter a random message
    And clicks the checkout button
    Then Checkout page will appear