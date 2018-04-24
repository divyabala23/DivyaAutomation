@api
Feature: Check the authentication process

  Scenario: Verify the basic authentication process

    Given I navigate to restapi demoqa site
    When  request the check for authentication URI
    And   I get the success status code
  #  Then  I get the authorization error


