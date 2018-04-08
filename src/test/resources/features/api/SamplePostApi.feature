@api
Feature: post request api

  Scenario: Verify the post request
    Given I send a request to demoqa customer register endpoint
    When  I post the below details
      | FirstName | dfjsdfsd         |
      | LastName  | erwerwe          |
      | Password  | sdfsdfsd         |
      | Email     | dfsfsd@gmail.com |
    Then I get the success response with success code "OPERATION_SUCCESS"




  Scenario: Deserializing the post response recieved

    Given I send a request to demoqa customer register endpoint
    When  I post the below details
      | FirstName | dfjsdfsd         |
      | LastName  | erwerwe          |
      | Password  | sdfsdfsd         |
      | Email     | dfsfsd@gmail.com |

    And I Deserialise the response body into registration success response model class
    Then verify the response received in the response class