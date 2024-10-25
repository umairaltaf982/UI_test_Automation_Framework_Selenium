Feature: Selecting and Adding a Product to Cart

  Scenario: Successful Product Selection and Addition to Cart
    Given User is on the search results page
    When User selects the first product from the search results
    And clicks on Add to Cart button
    Then Product is successfully added to the cart
