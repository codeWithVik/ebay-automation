Feature: Add a Product on Ebay Website

  Scenario: Verify item can be added to Cart
    Given User navigates to ebay website "https://www.ebay.com"
    When User Searches "Book" and clicks on 1 item in the list
    And User adds the item to cart
    Then Verify that cart has been updated and number of items in the cart are 1