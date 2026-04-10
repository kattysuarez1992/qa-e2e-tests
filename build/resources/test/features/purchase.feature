Feature: Purchase flow in SauceDemo

  Scenario: Successful purchase
    Given the purchase data for "successfulPurchase" is loaded
    And the user opens SauceDemo

    When logs in
    And adds products to the cart
    Then the cart badge should show "2"

    And goes to the cart
    And completes the checkout
    And confirms the purchase

    Then should see the confirmation message
