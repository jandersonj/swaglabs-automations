@Checkout @regression


Feature: Checkout end-to-end

  Scenario: Checkout of a single product

    Given i am in login page
    When log in with user "standard_user" and password "secret_sauce"
    Then i should be redirected to the products page
    When i add product "Sauce Labs Backpack" to the cart
    And i go to the cart page by clicking on the cart icon
    Then i should see product "Sauce Labs Backpack" in the cart
    When i click on checkout button
    Then i should be redirected to the checkout page
    When i fill the name "John", last name "Doe" and ZIP "54270100"
    And i click on continue
    Then i should be redirected to the checkout overview page
    When i click on finish
    Then i should see the order confirmation page
    And i should see the message "Thank you for your order!"