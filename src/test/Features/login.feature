Feature: Feature to test login functionality

  Scenario: Check login is successful with valid credentials from CSV file
    Given User is on login page
    When user enters username and password from CSV
    And click on login button
    Then User is navigated to home page

#  Scenario Outline: Check login is successful with valid credentials
#    Given User is on login page
#    When User enters <username> and <password>
#    And click on login button
#    Then User is navigated to home page
#
#    Examples:
#      | username | password |
#      | user1    | pass1    |
#      | user2    | pass2    |
#      | user3    | pass3    |
#      | user4    | pass4    |
