@Cart

Feature: Swag Labs - Add product to cart
 Scenario: Add  product 'Sauce Labs Backpack' to the cart
   Given I am logged in
   When  I add product 'Sauce Labs Backpack' to the cart
   And   I go to the cart page by clicking on the cart icon
   Then  I should see product 'Sauce Labs Backpack' in the cart