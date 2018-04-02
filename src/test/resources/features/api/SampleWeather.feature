@api

  Feature: Weather API

    Scenario Outline: Check the weather report from location hyderabad

      Given I requet GetWeatherDetails by location
      When  I request location by  "<city>"
      Then  Verify the 200 response in the request
      And   I get response with weather report

   Examples:

   | city      |
   | Hyderabad |
   | Mumbai    |
   | Delhi     |

