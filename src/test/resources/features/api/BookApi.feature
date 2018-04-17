@api

Feature: Get all books api

  Scenario: Check the weather report from location hyderabad

    Given I request all books api
    When  I request as a jsonpath
    And   I call using http request
    Then  Verify the 200 responsecode is returned in the response


  Scenario:  Search JSON Response nodes as list of Type T using JSONPath (Serialization and De-serialization )
    Given I request all books api



