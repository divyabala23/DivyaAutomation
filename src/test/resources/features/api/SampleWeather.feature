@api

Feature: Weather API

  Scenario Outline: Check the weather report from location hyderabad

    Given I request GetWeatherDetails by location
    When  I request location by  "<city>"
    Then  Verify the 200 response in the request
    And   I get response with weather report

    Examples:

      | city      |
      | Hyderabad |
      | Mumbai    |
      | Delhi     |


  Scenario Outline: Verify the success response code
    Given I request GetWeatherDetails by location
    When  I request location by  "<city>"
    Then  Verify the 200 success response in the request

    Examples:

      | city       |
      | Vijayawada |


  Scenario Outline: Verify the error response code
    Given I request GetWeatherDetails by location
    When  I request location by  "<city>"
    Then  Verify the 200 success response in the request

    Examples:

      | city        |
      | 78789798798 |

  Scenario Outline: Verify the response status line
    Given I request GetWeatherDetails by location
    When  I request location by  "<city>"
    Then  Verify the “HTTP 200 OK” response is returned
    And   Verify the content type in the response header
    Examples:
      | city    |
      | Kolkata |


  Scenario Outline: Verify the response headers
    Given I request GetWeatherDetails by location
    When  I request location by  "<city>"
    Then  Verify the “HTTP 200 OK” response is returned
    And   Verify all the headers
    Examples:
      | city    |
      | Kolkata |


  Scenario Outline: Verify the response body
    Given I request GetWeatherDetails by location
    When  I request location by  "<city>"
    Then  Verify the “HTTP 200 OK” response is returned
    And   Verify the reponse body
    Examples:
      | city  |
      | Delhi |



