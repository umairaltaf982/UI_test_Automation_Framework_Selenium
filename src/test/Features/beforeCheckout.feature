Feature: Filling the checkout form

  Scenario: Order is not placed successfully
    Given User is on checkout page
    When user proceeds to checkout
    And fills in checkout form details
    Then Checkout is completed successfully
