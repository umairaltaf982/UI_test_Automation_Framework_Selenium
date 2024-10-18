Feature: Filling the checkout form

  Scenario: Order is not placed successfully
    Given User is on checkout page
    When User fills the form
    And clicks the complete order button
    Then Checkout successfully

  @regression