Feature: Shopping on automation practice

  Scenario: Validate that user can navigate to summer dresses via megamenu
    Given Automation practice application is opened
    When I select summer dresses from the dresses megamenu
    Then I should see the summer dresses webpage

    And I select a dress
    And I select blue colour
    And I add to shopping cart
    Then the dress should appear in the Cart summary with same product name, colour and quantity

