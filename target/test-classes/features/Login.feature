@Login @regression

Feature: Swag Labs submission - Login form submission

  Background:
    Given I access SwagLabs login form

   @smoke
  Scenario: Submitting a Login form
    When I enter a valid username standard_user
    And I enter a valid password secret_sauce
    And I click on the login button
    Then I should be redirected to the products page

  Scenario: Submitting a Login form with a invalid password
    When I enter a valid username standard_user
    And I enter an invalid password secret_sauce1
    And I click on the login button
    Then I should be presented with a unsuccessful validation message