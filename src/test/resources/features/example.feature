Feature: Feature to test login functionality

  Scenario: Check login is successful with valid credentials from CSV file
    Given User is on login page
    When User enters username and password from CSV
    Then User should be logged in

