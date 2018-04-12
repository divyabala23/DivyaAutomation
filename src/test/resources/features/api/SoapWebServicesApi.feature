@api
Feature: Web Service Test


  Scenario Outline: Verify the data can be retrieved using UKLocation WebService
    Given I have UK location service available
    When  I request GetUKLocationByCounty by "<county>"
    Then  verify  the status code 200 is returned
    And   verify that "<town>" is returned in the response

    Examples:
      | county          | town      |
      | Bedfordshire    | Wootton   |
