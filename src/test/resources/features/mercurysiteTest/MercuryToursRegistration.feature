@gui
Feature: As a new user I want to register in mercury travel site

  Background:

    Given the user is on the "Home" page


  Scenario: verify the registration form
    And I click on register link on home page
    Then the following fields are displayed in the registration form
      | Field Name      |
      | FirstName       |
      | LastName        |
      | Email           |
      | Address         |
      | City            |
      | State           |
      | Postalcode      |
      | Country         |
      | UserName        |
      | Password        |
      | ConfirmPassword |


  Scenario: Single user registration
    And I click on register link on home page
    When I enter valid data on page
    And I click on submit button
    Then Thankyou for registration message is displayed


  Scenario: verify the registered user can login
    And I click on signon button
    When I enter valid login credentials
#      | username | password   |
#      | saddasda | asdddasda  |
#      | testrav  | sasdsadasd |
    And I click on login button on MercuryTours Page
    Then I should be able to login successfully


  Scenario: Verify the title of the mercurysite page
    And the title is displayed as expected

  Scenario: verify the registered user can login using list
    And I click on signon button
    When I enter valid login credentials as listoflist of string
      | kumar    | ravuri     |
      | testrav  | sasdsadasd |
      | divya    | bala       |
    And I click on login button on MercuryTours Page
    Then I should be able to login successfully
