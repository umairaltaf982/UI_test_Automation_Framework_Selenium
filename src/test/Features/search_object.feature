Feature: feature to test the search functionality

  Scenario: Check search is successful with given credentials
    Given User is on Dashboard page after login
    When User enters search term
    And clicks on search button
    Then User is navigated to the search results page
