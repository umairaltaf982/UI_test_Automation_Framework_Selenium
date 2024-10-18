Feature: feature to test the search functionality

  Scenario: Check search is successful with given credentials
    Given User is on Dashboard page
    When User enters search creditentials
    And click on search button
    Then User is navigated to product related detail page