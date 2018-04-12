@gui
Feature: Web Front-End Test
  Automated the following functional test using Selenium


  Scenario Outline: Verify the user is able to navigate and search for a given string in English
    Given I navigate to the wikipedia "Home" page
    And   I enter valid "<searchTerm>" in the input field
    And   I select "<language>" from the dropdown
    When  I click on search button
    Then  search results heading matches with input search data

    Examples:
      | searchTerm | language |
      | Apple Inc. | English  |


  Scenario Outline:: Verify the English language link is visible on navigating to Deutch language page
    Given I navigate to the wikipedia "Home" page
    And   I enter valid "<searchTerm>" in the input field
    And   I select "<language>" from the dropdown
    When  I click on search button
    Then  the Deutch results page contains English language link
    And   I click on English Language link
    Then  the results displays heading in English language

    Examples:
      | searchTerm | language |
      | Apple      | Deutsh   |



