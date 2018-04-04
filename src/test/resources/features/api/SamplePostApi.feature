@api
Feature: post request api

  Scenario: Verify the post request
    Given I send a request to demoqa customer register endpoint
    When  I post the below details
      | Key       | Values           |
      | FirstName | dfjsdfsd         |
      | LastName  | erwerwe          |
      | Password  | sdfsdfsd         |
      | Email     | dfsfsd@gmail.com |
    Then I get the success response with success code "OPERATION_SUCCESS"
