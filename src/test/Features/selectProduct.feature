Feature: Selecting and Adding a Product to Cart

  Scenario: Successful Product Selection and Addition to Cart
    Given User is on the product details page
    When User selects the product
    And clicks the add to cart button
    Then Product is added to the cart

  @regression @medium