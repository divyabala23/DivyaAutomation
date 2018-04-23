@api

Feature: Get all books api

  Scenario: Check the weather report from location hyderabad

    Given I request all books api
    When  I request as a jsonpath
    And   I call using http request as a list
    Then  Verify the 200 responsecode is returned in the response


  Scenario:  Search JSON Response nodes as list of Type T using JSONPath (Serialization and De-serialization )
    Given I request all books api
    When  I request as a jsonpath
    Then  Verify the 200 responsecode is returned in the response
    And  I read all the books as a list of string by using model class


  Scenario: Verify the basic authentication process

    Given I navigate to restapi demoqa site
    When  request the check for authentication URI
    And   I get the status code




